package com.example.starter.web.home

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@Controller
class HomeController(private val homeService: HomeService) {

	@GetMapping(value= ["/", "/index"])
	fun home(): String {
		homeService.test();
		return "home/home";
	}
}

@RestController
class HomeRestController(private val homeService: HomeService) {

	@GetMapping(value = ["/home"])
	fun getHome(): ResponseEntity<HomeResult> {
		val items = listOf("abc","def","ghi")
		return ResponseEntity(HomeResult(items, items.size), HttpStatus.OK)
	}

}

data class HomeResult(
		var items: List<String>,
		var count: Int

)