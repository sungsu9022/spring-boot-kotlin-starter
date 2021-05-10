package com.example.starter.web.home

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(private val homeService: HomeService) {

	@GetMapping(value= ["/", "/index"])
	fun home(model: Model): String {

		homeService.test();
		model["title"] = "test";
		return "home";
	}
}
