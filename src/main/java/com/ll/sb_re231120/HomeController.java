package com.ll.sb_re231120;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 컨트롤러 입니다. 스프링부트와 의 약속
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    // 이 함수의 리턴값을 그대로 브라우저에 전송해라
    String showMain(){
        return "Hello SpringBoot!";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout(){
        return "Director Comunity";
    }
}
