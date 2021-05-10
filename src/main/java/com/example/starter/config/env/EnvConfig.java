package com.example.starter.config.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.profiles")
public class EnvConfig {
	private String active;

	public boolean isLocal() {
		return Phase.from(active) == Phase.LOCAL;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getActive() {
		return active;
	}
}
