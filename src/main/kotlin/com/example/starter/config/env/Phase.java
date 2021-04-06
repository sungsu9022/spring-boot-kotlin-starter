package com.example.starter.config.env;

enum Phase {
	LOCAL, DEV, REAL;

	static Phase from(String phase) {
		return Phase.valueOf(phase.toUpperCase());
	}


}
