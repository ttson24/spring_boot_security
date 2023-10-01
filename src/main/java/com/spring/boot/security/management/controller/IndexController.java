package com.spring.boot.security.management.controller;

import com.spring.boot.security.management.common.MyConstantScreen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }
    @GetMapping("/admin")
    public  String admin(){
        return MyConstantScreen.AD_HOME;
    }

    @GetMapping("/leader")
    public  String manager(){
        return MyConstantScreen.MN_HOME;
    }
}
