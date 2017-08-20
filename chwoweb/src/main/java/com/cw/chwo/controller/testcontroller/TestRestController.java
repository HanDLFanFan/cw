package com.cw.chwo.controller.testcontroller;

import com.cw.chwo.service.DemoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 编写测试案例：RestController的实例
 * Created by handl on 2017/8/19.
 */
@RestController
public class TestRestController {

    @Autowired
    private DemoTestService demoTestService;

    @RequestMapping(value = "testRestController")
    public @ResponseBody String testRestController(){

        System.out.println("进来了！！！");
        return demoTestService.sayHello();
    }

}
