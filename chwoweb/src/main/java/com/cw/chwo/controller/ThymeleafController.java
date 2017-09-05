package com.cw.chwo.controller;

import com.cw.chwo.module.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by handl on 2017/8/24.
 */
@Controller
public class ThymeleafController {

    @RequestMapping("thymeleaf")
    public String index(Model model){
        System.out.println("ok ,thi is thymeleaf controller");
        User user = new User();
        user.setName("hahahah");
        user.setAge(16);
        model.addAttribute("user",user);
        return "thymeleaf/thymeleaf";
    }

}
