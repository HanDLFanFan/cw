package com.cw.chwo.controller.testcontroller;

import com.cw.chwo.service.DemoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 编写测试案例：普通Controller的实例
 *
 * Created by handl on 2017/8/19.
 */
@Controller
public class TestController {

    @Autowired
    private DemoTestService demoTestService;

    @RequestMapping("testController")
    public String testController(Model model){
        model.addAttribute("msg",demoTestService.sayHello());
        return "testcontroller/test";
    }

}
