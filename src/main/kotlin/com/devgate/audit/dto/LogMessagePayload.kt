package com.devgate.audit.dto

import com.devgate.audit.models.Action
import com.devgate.audit.models.AuditLog
import com.devgate.audit.models.Target
import java.time.LocalDateTime
import java.util.UUID

data class LogMessagePayload(
	val action: Action? = null,
	val actorId: UUID? = null,
	val target: Target? = null,
	val payload: String? = null,
	val createdAt: LocalDateTime? = null
) {
	fun toAuditLog() = AuditLog().apply {
		this.action = this@LogMessagePayload.action
		this.actorId = this@LogMessagePayload.actorId
		this.target = this@LogMessagePayload.target
		this.payload = this@LogMessagePayload.payload
		this.createdAt = this@LogMessagePayload.createdAt ?: LocalDateTime.now()
	}
}
