package com.cw.chwo.controller;

import com.cw.chwo.module.User;
import com.cw.chwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by handl on 2017/5/21.
 */
@Controller
@RequestMapping("userhome")
public class UserHomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("reg")
    public String reg(User vo){
        return "userhome/reg";
    }

    @RequestMapping("regok")
    public ModelAndView regok(User vo){
        ModelAndView modelAndView = new ModelAndView("userhome/regok");
        String msg = userService.reg(vo);
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }

    @RequestMapping("index")
    public String index(){
        return "userhome/index";
    }

    @RequestMapping(value = "jspfindUser/{id}"/*,produces = MediaType.APPLICATION_JSON_VALUE*/)
    public String jspfindUser(@PathVariable String id, Model model){

        User user = userService.findUser(id);
        model.addAttribute("user",user);
        return "userhome/userinfo";
    }

    @RequestMapping(value = "findUser/{id}"/*,produces = MediaType.APPLICATION_JSON_VALUE*/)
    public String findUser(@PathVariable String id, Model model){

        User user = userService.findUser(id);
        model.addAttribute("user",user);
        return "velocity/myvelocity";
    }

    @RequestMapping("restfulData")
    public @ResponseBody
    Map<String,String> restfulData(){
        Map<String,String> list = new HashMap<>();
        list.put("haha","123");
        list.put("yes","456");
        list.put("ok","789");
        return list;
    }
}
