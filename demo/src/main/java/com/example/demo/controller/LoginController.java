package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // 로그인 페이지
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "accessDenied"; // 권한 부족 시 보여줄 페이지
    }
}
