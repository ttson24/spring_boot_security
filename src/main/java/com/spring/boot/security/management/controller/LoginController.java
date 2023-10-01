package com.spring.boot.security.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spring.boot.security.management.common.MyConstantScreen;
import com.spring.boot.security.management.dto.security.LoginDto;

@Controller
public class LoginController {
   @GetMapping("/login")
   public String login(Model model) {
       model.addAttribute("loginDto", new LoginDto());
       System.out.println("Login form");
       return MyConstantScreen.LOGIN;
   }

   @PostMapping("/authUser")
   public String authUser(@ModelAttribute LoginDto dtoLogin) {
       System.out.println("Go to authUser");
       System.out.println(dtoLogin);
       return MyConstantScreen.REDIRECT +"/";
   }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return MyConstantScreen.ER_403;
    }
}
