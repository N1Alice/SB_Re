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
        if (!rq.isAdmin()) {
            throw new RuntimeException("관리자만 접근할 수 있습니다.");
        }

        return "home/home/adm/main";
    }
}