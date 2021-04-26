package com.example.SpringSecuityLocalDataBase

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeResource {
    @GetMapping("/")
    fun home():String{
        return "Home"
    }

    @GetMapping("/user")
    fun user():String{
        return "user"
    }

    @GetMapping("/admin")
    fun admin():String{
        return "admin"
    }
}