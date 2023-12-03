package com.ll.sb_re231120.domain.home.home.controller;

import com.ll.sb_re231120.global.rq.Rq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdmHomeController {
    private final Rq rq;

    @GetMapping("/adm")
    public String showMain() {
        return "home/home/adm/main";
    }

    @GetMapping("/adm/home/about")
    public String showAbout() {

        return "home/home/adm/about";
    }
}