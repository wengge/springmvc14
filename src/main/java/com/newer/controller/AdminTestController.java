package com.newer.controller;

import com.newer.bean.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/admin")
@SessionAttributes("user1")
public class AdminTestController {

    @RequestMapping("/get1")
    public String get1(@ModelAttribute("user1") UserInfo userInfo){
        userInfo.setUserName("admin:"+userInfo.getUserName());
        return "suc";
    }

    @RequestMapping("/testError")
    public String testError(){
        int result=5/0;
        return "index";
    }


}
