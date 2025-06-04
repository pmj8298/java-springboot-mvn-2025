package com.pknu.my01.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class My01Controller {
    @GetMapping("/")
    public String mainPage(Model model) {
        List<String> pageNames = List.of("model", "increase", "fragments", "if-unless");
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

        return "ex04";
    }

}
