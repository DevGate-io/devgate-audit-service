package com.devgate.audit.services

import com.devgate.audit.models.AuditLog

interface AuditLogService {
	fun getLogs(): List<AuditLog>
	fun getLogById(id: Long): AuditLog
	fun saveLog(log: AuditLog)
	fun deleteLog(id: Long)
}