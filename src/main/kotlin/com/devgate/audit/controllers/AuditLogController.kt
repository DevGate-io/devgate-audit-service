package com.devgate.audit.controllers

import com.devgate.audit.models.AuditLog
import com.devgate.audit.services.AuditLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/audit")
class AuditLogController @Autowired constructor(
	private val auditLogService: AuditLogService
) {
	@GetMapping
	fun getLogs(): ResponseEntity<List<AuditLog>> {
		val logs = auditLogService.getLogs()

		return ResponseEntity.ok(logs)
	}
}