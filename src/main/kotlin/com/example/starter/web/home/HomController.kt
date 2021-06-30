package com.example.starter.web.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(private val homeService: HomeService) {

	@GetMapping(value= ["/", "/index"])
	fun home(): String {
		homeService.test();
		return "home/home";
	}
}
