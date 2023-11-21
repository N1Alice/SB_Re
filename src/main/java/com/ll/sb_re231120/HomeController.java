package com.ll.sb_re231120;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/Calc")
    @ResponseBody
    String showCalc(int a, int b){
        return "계산결과 : %d" .formatted(a + b);
    }

    @GetMapping("/Calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b){
        return "a :" + a + ", b : " + b;
    }

    @GetMapping("/Calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b
    ) {
        return "계산결과 : %d" .formatted(a + b);
    }

    @GetMapping("/Calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b
    ) {
        return "계산결과 : %f" .formatted(a + b);
    }

    @GetMapping("/Calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue = "0") String a,
            @RequestParam(defaultValue = "0") String b
    ) {
        return "계산결과 : %s" .formatted(a + b);
    }
}
