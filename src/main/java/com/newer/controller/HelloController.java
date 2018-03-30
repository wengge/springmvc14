package com.newer.controller;

import com.newer.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {



    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello被执行");
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username,String pwd){
        System.out.println(username+":"+pwd);

        return "jsp/hello";
    }

    @RequestMapping("/login1")
    public String login1(User user){
        System.out.println(user.getUsername()+":"+user.getPwd());
        return "jsp/hello";
    }

    @RequestMapping("/getUser")
    public ModelAndView getUser(){
        ModelAndView mav=new ModelAndView();
        User u1=new User();
        u1.setUserId(1);
        u1.setUsername("Jack");
        u1.setPwd("111111");
        mav.addObject("u1",u1);
        //内部转发按照视图解析器生成视图路径
        //mav.setViewName("jsp/hello");
        //重定向不按视图解析器的配置路径跳转
        //重定向以/开头，从当前项目应用上下文根目录开始的绝对路径
        mav.setViewName("redirect:/jsp/hello.jsp");
        return mav;
    }


}
