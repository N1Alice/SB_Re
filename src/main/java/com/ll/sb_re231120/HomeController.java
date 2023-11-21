package com.ll.sb_re231120;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
// 컨트롤러 입니다. 스프링부트와 의 약속
public class HomeController {
    @GetMapping("/")
    @ResponseBody
        // 이 함수의 리턴값을 그대로 브라우저에 전송해라
    String showMain() {
        return "Hello SpringBoot!";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout() {
        return "Director Comunity";
    }

    @GetMapping("/Calc")
    @ResponseBody
    String showCalc(int a, int b) {
        return "계산결과 : %d".formatted(a + b);
    }

    @GetMapping("/Calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b) {
        return "a :" + a + ", b : " + b;
    }

    @GetMapping("/Calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b
    ) {
        return "계산결과 : %d".formatted(a + b);
    }

    @GetMapping("/Calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b
    ) {
        return "계산결과 : %f".formatted(a + b);
    }

    @GetMapping("/Calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue = "-") String a,
            @RequestParam(defaultValue = "-") String b
    ) {
        return "계산결과 : %s".formatted(a + b);
    }

    @GetMapping("/Calc6")
    @ResponseBody
    int showCalc6(
            int a, int b
    ) {
        return a + b;
    }

    @GetMapping("/Calc7")
    @ResponseBody
    Boolean showCalc7(
            int a, int b
    ) {
        return a > b;
    }

    @GetMapping("/Calc8")
    @ResponseBody
    Person showCalc8(
            String name, int age
    ) {
        return new Person(name, age);
    }

    @GetMapping("/Calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ) {
        return new Person2(name, age);
    }

    @GetMapping("/Calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ) {
        //Object가 제일 큰 개념이다. 객체와 Map은 비슷한 식이다.
        Map<String, Object> personMap = Map.of(
                "name", name,
                "age", age
        );
        return personMap;
    }

    @GetMapping("/Calc11")
    @ResponseBody
    List<Integer> showCalc11() {
        List<Integer> nums = new ArrayList<>(){{
            add(10);
            add(-1510);
            add(15007);
        }};
        return nums;
    }

    @GetMapping("/Calc12")
    @ResponseBody
    int[] showCalc12() {
        int[] nums = new int[]{10, -510, 15570};
        // 리스트는 계속 추가가 가능하다, 배열은 사이즈가 정해져있다(고정길이)
        return nums;
    }

    @GetMapping("/Calc13")
    @ResponseBody
    List<Person2> showCalc13(
            String name, int age
    ) {
        List<Person2> persons = new ArrayList<>(){{
            add(new Person2(name, age));
            add(new Person2(name + "!", age + 1));
            add(new Person2(name + "!!", age + 2));
        }};
        return persons;
    }
}

@AllArgsConstructor
class Person {
    public  String name;
    public  int age;
}

@AllArgsConstructor
class Person2 {
    @Getter
    private  String name;
    @Getter
    private   int age;
}

