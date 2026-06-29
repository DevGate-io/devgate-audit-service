package com.devgate.audit.services.impl

import com.devgate.audit.dto.LogMessagePayload
import com.devgate.audit.services.AuditLogService
import com.devgate.audit.services.MessageService
import com.devgate.audit.utils.info
import org.springframework.amqp.rabbit.annotation.Exchange
import org.springframework.amqp.rabbit.annotation.Queue
import org.springframework.amqp.rabbit.annotation.QueueBinding
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl @Autowired constructor(
	private val auditLogService: AuditLogService,
): MessageService {
	@RabbitListener(
		bindings = [QueueBinding(
			value = Queue(value = "#{@environment.getProperty('rabbitmq.queue')}", durable = "true"),
			exchange = Exchange(value = "#{@environment.getProperty('rabbitmq.exchange')}"),
			key = ["#{@environment.getProperty('rabbitmq.routingKey')}"]
		)]
	)
	override fun listener(message: LogMessagePayload) {
		info("message: $message")

		auditLogService.saveLog(message.toAuditLog())
	}
}