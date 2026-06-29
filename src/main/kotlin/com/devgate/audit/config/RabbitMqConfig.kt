package com.devgate.audit.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMqConfig(
	@Value($$"${rabbitmq.queue}")
	private val queueName: String
) {
	@Bean
	fun converter(): MessageConverter {
		return JacksonJsonMessageConverter()
	}

	@Bean
	fun queue(): Queue {
		return Queue(queueName)
	}
}