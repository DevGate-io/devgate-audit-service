package com.devgate.audit.services

import com.devgate.audit.dto.LogMessagePayload

interface MessageService {
	fun listener(message: LogMessagePayload)
}