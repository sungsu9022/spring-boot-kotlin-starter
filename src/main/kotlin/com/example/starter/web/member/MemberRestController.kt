package com.example.starter.web.member

import mu.KotlinLogging
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
class MemberRestController(private val memberService: MemberService) {
	@GetMapping(value= ["/members/{id}"])
	fun getMember(@PathVariable id : Long): String {
		logger.info("test")
		return "member";
	}
}
