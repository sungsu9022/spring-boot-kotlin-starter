package com.example.starter.web.home

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping(value= ["/", "/index"])
    fun home(model: Model): String {
        model["title"] = "test";
        return "home";
    }

}
