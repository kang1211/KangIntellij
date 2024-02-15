package com.example.jpatest.control;

import com.example.jpatest.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "main/index";
    }

    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("memberDto", new MemberDto());
        return "member/signupForm";
    }

    @GetMapping("/signin")
    public String signinForm(Model model){
        model.addAttribute("memberDto", new MemberDto());
        return "member/signinForm";
    }
}
