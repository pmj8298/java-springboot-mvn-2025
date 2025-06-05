package com.pknu.my01.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pknu.my01.dto.ChatRequest;

@RestController
public class My02Controller {

    @PostMapping("/final_chatbot")
    @ResponseBody
    public Map<String, String> chat(@RequestBody ChatRequest request) {
        System.out.println(request.getMessage());
        String message = request.getMessage();
        // String answer = message + "입니다";
        String answer;
        if ("안녕".equals(message)) {
            answer = "반가워요🤗";
        } else if ("배고파".equals(message)) {
            answer = "뭐 먹을까?";
        } else {
            answer = "네 확인해볼게요";
        }

        return Map.of("reply", answer);
    }
}
