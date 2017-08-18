package com.cw.chwo.common.conditional;

import com.cw.chwo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Created by handl on 2017/8/17.
 */
public class ConditionalServiceTest extends BaseTest {

    @Autowired
    private Environment environment;

    //预编译检查报错不用处理，在运行时环境加载后可正常出结果
    @Autowired
    private BeanService beanService;

    @Test
    public void beanServiceTest(){
        System.out.println("操作系统是："+environment.getProperty("os.name")+
                ",查看目录命令为"+beanService.showBeanCmd());
    }

}
