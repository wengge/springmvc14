package com.newer.controller;


import com.newer.bean.UserInfo;
import com.newer.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
@SessionAttributes({"user1","user2"})
public class UserTestController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value="/users",method = RequestMethod.GET)
    public String findAll(ModelMap map){
       //ModelMap代表当前控制器能得到的模型数据Map
        List<UserInfo> list=userInfoService.findAll();
        map.put("users",list);
        return "list";
    }

    @RequestMapping(value = "/users/{userId:\\d+}/{userName}",method = RequestMethod.GET)
    public String findById(@PathVariable("userId") Integer userId,@PathVariable("userName")String userName){
         //PathVariable用于注解将指定路径变量的值注入对应方法参数
        System.out.println(userId);
        return "index";
    }

    @RequestMapping(value = "/p1",params = "username=admin")
    public String testParam(@RequestParam("username") String uname){
        System.out.println(uname);
        return "index";
    }

    @RequestMapping(value = "/p1",params = "username!=admin")
    public String testParam1(@RequestParam("username") String uname){
        System.out.println("testParam1"+uname);
        return "index";
    }

    @ModelAttribute("user1")
    public UserInfo getOneUser(){
        //ModelAttribute注解在方法上
        //方法没有RequestMapping注解
        //表示在当前控制器类的任何方法执行前，先执行这个方法
        //将方法的返回值放入当前控制器类的ModalMap
       return userInfoService.findAll().get(0);
    }

    @RequestMapping("/get1")
    public String getUser1(ModelMap map){
        UserInfo u1=(UserInfo) map.get("user1");
        System.out.println(u1.getUserName());
        return "index";
    }


    @ModelAttribute("user2")
    @RequestMapping("/get2")
    public UserInfo get2(){
        //ModelAttribute注解在方法上
        //方法有RequestMapping注解
        //将方法的返回值放入当前控制器类的ModalMap
        return userInfoService.findAll().get(1);
    }

    @RequestMapping("/get3")
    public String get3(@ModelAttribute("user1")UserInfo user1){
        //ModelAttribute注解在方法参数上，表示参数绑定
        user1.setUserName("get3:"+user1.getUserName());
        return "index";
    }

    @RequestMapping("/testSession")
    public String testSession(){
        return "redirect:/suc.jsp";
    }

    @RequestMapping("/testSession2")
    public String testSession2(){
        return "redirect:/admin/get1";
    }


    @ResponseBody
    @RequestMapping("/allusers")
    public List<UserInfo> findAllJson(){
        //ResponseBody用于将方法返回值自动转换成json对象返回前台
        return userInfoService.findAll();
    }

}
