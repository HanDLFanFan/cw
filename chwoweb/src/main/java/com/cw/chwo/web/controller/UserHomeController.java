package com.cw.chwo.web.controller;

import com.cw.chwo.server.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by handl on 2017/5/21.
 */
@Controller
@RequestMapping("userhome")
public class UserHomeController {

    @RequestMapping()
    public ModelAndView userHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","handl");
        return modelAndView;
    }

    @RequestMapping("index")
    public ModelAndView hase(User vo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("state","haha! nai si to mi te you");
        return modelAndView;
    }
}
