package com.ll.sb_re231120.domain.home.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 컨트롤러 입니다. 스프링부트와 의 약속
public class HomeController {
    @GetMapping("/")
    public String goToArticleList() {
        return "redirect:/article/list";
    }
}

