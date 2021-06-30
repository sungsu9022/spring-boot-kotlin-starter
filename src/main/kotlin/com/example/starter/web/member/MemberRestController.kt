package com.example.starter.web.member

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

interface Log {
	val logger: Logger get() = LoggerFactory.getLogger(this.javaClass)
}

@RestController
class MemberRestController(private val memberService: MemberService) {
	companion object : Log

	@GetMapping(value= ["/members/{id}"])
	fun getMember(@PathVariable id : Long): String {
		logger.info("test")
		return "member";
	}
}
