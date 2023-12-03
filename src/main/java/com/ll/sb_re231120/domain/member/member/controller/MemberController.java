package com.ll.sb_re231120.domain.member.member.controller;

import com.ll.sb_re231120.domain.member.member.entity.Member;
import com.ll.sb_re231120.domain.member.member.service.MemberService;
import com.ll.sb_re231120.global.rq.Rq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/member/login")
    String showLogin() {
        return "member/member/login";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/member/join")
    String showJoin() {
        return "member/member/join";
    }

    @Data
    public static class WriteForm {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/member/join")
    String join(@Valid WriteForm joinForm) {
        Member member = memberService.join(joinForm.username, joinForm.password);

        return rq.redirect("/member/login", "회원가입이 완료되었습니다.");
    }
}