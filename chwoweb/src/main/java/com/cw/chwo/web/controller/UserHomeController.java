package com.cw.chwo.web.controller;

import com.cw.chwo.server.pojo.User;
import com.cw.chwo.server.service.UserService;
import com.cw.chwo.server.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView reg(User vo){
        ModelAndView modelAndView = new ModelAndView();
        String msg = userService.reg(vo);
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }

    @RequestMapping("index")
    public String index(User vo){
        return "userhome/index";
    }
}
