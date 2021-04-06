package com.example.starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.starter"])
class StarterApplication

fun main(args: Array<String>) {
	runApplication<StarterApplication>(*args)
}
