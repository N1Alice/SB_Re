package com.ll.sb_re231120.domain.home.home.controller;

import com.ll.sb_re231120.global.rq.Rq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdmHomeController {
    private final Rq rq;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/adm")
    public String showMain() {
        return "home/home/adm/main";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/adm/home/about")
    public String showAbout() {

        return "home/home/adm/about";
    }
}