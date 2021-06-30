package com.example.starter.web.home

import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class HomeService {
	fun test() {
		logger.debug { "HomeService test" };
	}
}
