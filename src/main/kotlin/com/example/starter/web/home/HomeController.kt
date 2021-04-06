package com.example.starter.web.home

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping(value= ["/", "/index"])
    fun home(model: Model): String {
        model["title"] = "Home";
        return "home";
    }

}
