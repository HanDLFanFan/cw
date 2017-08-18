package com.cw.chwo.common.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by handl on 2017/8/17.
 *
 *   Spring Aware:是为了spring容器内部使用
 *
 *      BeanNameAware:获得到容器中bean的名称
 *      BeanFactoryAware:获得当前bean factory，这样可以调用容器的服务
 *      ApplicationContextAware*:当前的application context，这样可以调用容器的服务
 *      MessageSourceAware:获得message source，这样可以获得文本信息
 *      ApplicationEventPublisherAware:应用04:44:26发布器event包下的publisher类也可以实现此接口
 *      ResourceLoaderAware:获得资源加载器，可以获得外部资源文件
 *
 *      Spring Aware的目的是为了让bean获得Spring容器的服务。因为ApplicationContext接口
 *      集成了MessageSource接口、ApplicationEventPublisher接口和ResourceLoader接口，
 *      所以Bean继承ApplicationContextAware可以获得Spring容器的所有服务，
 *      但原则上我们还是用到什么接口，就实现什么接口
 *
 *
 *
 *      此类是获取Aware提供的功能
 */
@Service
public class AwareService implements ApplicationContextAware,BeanNameAware{

    private String name;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("服务本身名称=="+name);

        String[] names = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println("beanName==="+names[i]);
        }
        Resource resource = applicationContext.getResource("classpath:/aware.txt");
        try {
            System.out.println("awareText文件内容==="+ IOUtils.toString(resource.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
