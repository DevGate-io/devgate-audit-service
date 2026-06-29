package com.devgate.audit.repositories

import com.devgate.audit.models.AuditLog
import org.springframework.data.jpa.repository.JpaRepository

interface AuditLogRepository: JpaRepository<AuditLog, Long>