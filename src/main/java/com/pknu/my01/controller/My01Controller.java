package com.pknu.my01.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.my01.dto.BungBBang;
import com.pknu.my01.dto.MemberData;

@Controller
public class My01Controller {
    @GetMapping("/")
    public String mainPage(Model model) {
        List<String> pageNames = List.of("model", "increase", "fragments", "if-unless", "DTO_ex1", "DTO_ex2",
                "GET_querystring", "GET_pathvariable", "POST_formdata", "final_chatbot");
        model.addAttribute("pages", pageNames);

        return "index";
    }

    @GetMapping("/model")
    public String ex01(Model model) {
        model.addAttribute("hello", "만나서 반갑습니다");
        model.addAttribute("name", "쭈");
        model.addAttribute("age", 26);
        return "ex01";
    }

    @GetMapping("/ex01a")
    public String ex01a(Model model) {
        model.addAttribute("test1", "테스트1");
        model.addAttribute("test2", "테스트2");
        model.addAttribute("test3", "테스트3");
        return "ex01a";
    }

    @GetMapping("/increase")
    public String ex02(Model model) {
        List<Integer> sampleNumbers = List.of(11, 22, 33, 44, 55, 66, 77);
        model.addAttribute("numbers", sampleNumbers);

        return "ex02";
    }

    @GetMapping("/fragments")
    public String ex03(Model model) {

        return "ex03";
    }

    @GetMapping("/if-unless")
    public String ex04(Model model) {
        model.addAttribute("isAdmin", true);
        model.addAttribute("who", "나");
        List<String> itm = new ArrayList<>();
        itm.add("사과");
        itm.add("바나나");
        itm.add("망고");
        itm.add("수박");
        itm.add("포도");
        itm.add("토마토");
        itm.add("거봉");
        model.addAttribute("items", itm);

        return "ex04";
    }

    @GetMapping("/DTO_ex1")
    public String ex05(Model model) {

        MemberData member = new MemberData("팥붕", LocalDate.of(2001, 5, 5));
        MemberData member1 = new MemberData("슈붕", LocalDate.of(2000, 7, 8));
        // MemberData member2 = new MemberData("홍길남", LocalDate.of(2001, 5, 5));
        model.addAttribute("member", member);
        model.addAttribute("member1", member1);

        return "ex05";
    }

    @GetMapping("/DTO_ex2")
    public String ex06(Model model) {
        // BungBBang(String flavor, int price, LocalDate madeDate)
        List<BungBBang> bungs = List.of(

                new BungBBang("팥붕", 1000, LocalDate.of(2025, 6, 1)),
                new BungBBang("슈붕", 1200, LocalDate.of(2025, 6, 4)),
                new BungBBang("피자붕", 1500, LocalDate.of(2025, 6, 4)));
        model.addAttribute("bungs", bungs);

        // BungBBang redbean = new BungBBang("팥붕", 1000, LocalDate.of(2025, 6, 4));
        // BungBBang cream = new BungBBang("슈붕", 1200, LocalDate.of(2025, 6, 4));
        // BungBBang pizza = new BungBBang("피자붕", 1500, LocalDate.of(2025, 6, 4));
        // // MemberData member2 = new MemberData("홍길남", LocalDate.of(2001, 5, 5));
        // model.addAttribute("redbean", redbean);
        // model.addAttribute("cream", cream);
        // model.addAttribute("pizza", pizza);

        return "ex06";
    }

    @GetMapping("/GET_querystring")
    public String ex07(@RequestParam(required = false) String inpName, String inpAge, String inpGen, String want,
            String allow, Model model) {
        // String inpName, int inpAge, String inpGen, String want, String allow;

        System.out.println("이름: " + inpName);
        System.out.println("나이: " + inpAge);
        System.out.println("성별: " + inpGen);
        System.out.println("언어: " + want);
        System.out.println("동의: " + allow);

        List<String> content = List.of(
                "이름: " + inpName,
                "나이: " + inpAge,
                "성별: " + inpGen,
                "언어: " + want,
                "동의: " + allow);
        model.addAttribute("content", content);
        return "ex07";
    }

    @GetMapping({ "/GET_pathvariable", "/ex08/{name}", "/ex08/{name}/{age}" })
    public String ex08(@PathVariable(required = false) String name, @PathVariable(required = false) String age,
            Model model) {
        System.out.println("이름: " + name + " / 나이: " + age);

        if (name != null && age != null) {
            List<String> content = List.of(
                    "이름: " + name,
                    "나이: " + age);
            model.addAttribute("content", content);
        }
        ;
        // model.addAttribute("name", name);
        // model.addAttribute("age", age);
        return "ex08";
    }

    @GetMapping("/POST_formdata")
    public String ex09() {
        return "ex09";
    }

    @PostMapping("/POST_formdata")
    public String ex09Post(@RequestParam String name, @RequestParam String age, Model model) {
        System.out.println("이름: " + name + " / 나이: " + age);
        // if (name != null && age != null) {
        // List<String> content = List.of(
        // "이름: " + name,
        // "나이: " + age);
        // model.addAttribute("content", content);
        // }

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        try {
            int parseAge = Integer.parseInt(age);
            model.addAttribute("name", name);
            model.addAttribute("age", parseAge);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "나이는 숫자로 입력해야 합니다.");
        }

        return "ex09";
    }

    @GetMapping("/final_chatbot")
    public String ex10Chat(Model model) {
        return "ex10";
    }

}
