package com.cw.chwo.controller;

import com.cw.chwo.module.User;
import com.cw.chwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public String index(User vo){
        return "userhome/index";
    }

    @RequestMapping("findUser")
    public String findUser(Model model){

        User user = userService.findUser();
        model.addAttribute("user",user);
        return "userhome/userinfo";
    }
}