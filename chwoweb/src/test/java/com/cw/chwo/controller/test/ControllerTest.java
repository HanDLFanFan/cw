package com.cw.chwo.controller.test;

import com.cw.chwo.service.DemoTestService;
import com.cw.chwo.springconfig.WebSpringRootConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by handl on 2017/8/19.
 *
 * 编写基础的基于Controller的测试用例,使用mockmvc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebSpringRootConfig.class)
/**
 * @WebAppConfiguration用来声明加载的ApplicationContext是一个WebApplicationContext
 * 它的属性指定的是Web资源的位置，默认为src/main/webapp
 */
@WebAppConfiguration("src/main/webapp")
public class ControllerTest {

    /**
     * MockMvc模拟mvc对象，
     * 通过MockMvcBuilders.webAppContextSetup(this.mockMvc).build()初始化
     * 初始化在@before注解的方法中
     */
    private MockMvc mockMvc;

    /**
     * 注入需要测试的服务类
     */
    @Autowired
    private DemoTestService demoTestService;

    /**
     * 注入WebApplicationContext(应用上下文环境)
     */
    @Autowired
    WebApplicationContext wac;

    /**
     * 注入模拟的http session,本例只注入并未使用
     */
    @Autowired
    MockHttpSession mockHttpSession;

    /**
     * 注入模拟的http request，本例只注入并未使用
     */
    @Autowired
    MockHttpServletRequest mockHttpServletRequest;

    /**
     * @Before 在测试开始之前执行的初始化工作
     */
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * 测试普通的@Controller
     * @throws Exception
     */
    @Test
    public void testNormalController() throws Exception {
                //模拟向/test发起get请求
        mockMvc.perform(get("/testController"))
                //预期控制返回状态为200
                .andExpect(status().isOk())
                //预期view的名称为test
                .andExpect(view().name("testcontroller/test"))
                //预期页面转向的真正路径/WEB-INF/classes/view/userhome/testcontroller/test.jsp
                .andExpect(forwardedUrl("/WEB-INF/view/userhome/testcontroller/test.jsp"))
                //预期model里的值是demoTestService.sayHello()返回值"hello"
                .andExpect(model().attribute("msg",demoTestService.sayHello()));
    }

    /**
     * 测试@RestController
     * @throws Exception
     */
    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRestController"))
                .andExpect(status().isOk())
                //预期返回值的媒体类型为text/plain;charset=UTF-8
//                .andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE))
                //预期返回值的内容为demoTestService.sayHello()返回值"hello"
                .andExpect(content().string(demoTestService.sayHello()));
    }

}
