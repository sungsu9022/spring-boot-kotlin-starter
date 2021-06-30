package com.example.starter.config.env

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "spring.profiles")
class EnvConfig {
	var active: String? = null
	val isLocal: Boolean
		get() = active?.let { Phase.from(it) } == Phase.LOCAL
}

internal enum class Phase {
	LOCAL, DEV, REAL;

	companion object {
		fun from(phase: String): Phase {
			return valueOf(phase.toUpperCase())
		}
	}
}

