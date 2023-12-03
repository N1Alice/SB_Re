package com.ll.sb_re231120.domain.member.member.controller;

import com.ll.sb_re231120.domain.member.member.entity.Member;
import com.ll.sb_re231120.domain.member.member.service.MemberService;
import com.ll.sb_re231120.global.rq.Rq;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    @GetMapping("/member/login")
    String showLogin() {
        return "member/member/login";
    }

    @Data
    public static class LoginForm {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }

    @PostMapping("/member/login")
    String login(@Valid LoginForm loginForm, HttpServletRequest req, HttpServletResponse response) {
        Member member = memberService.findByUsername(loginForm.username).get();
        // True만 넘긴다. 유저네임이 틀려도, 유저네임은 맞으나 비밀번호가 다르면 터진다.
        if (!member.getPassword().equals(loginForm.password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        rq.setSessionAttr("loginedMemberId", member.getId());

        return rq.redirect("/article/list", "로그인이 완료되었습니다.");
    }

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

    @PostMapping("/member/join")
    String join(@Valid WriteForm joinForm) {
        Member member = memberService.join(joinForm.username, joinForm.password);

        return rq.redirect("/member/login", "회원가입이 완료되었습니다.");
    }
}