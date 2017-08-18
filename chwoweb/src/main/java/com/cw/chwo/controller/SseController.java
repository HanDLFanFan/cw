package com.cw.chwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by handl on 2017/8/18.
 *
 * 服务器端推送技术：SSE(Server Send Event) 和Servlet3.0+异步方法处理
 *
 * SSE：要求支持EventSource对象的浏览器才可以
 *
 * produces = "text/ecent-stream":媒体类型为text/ecent-stream，这是服务器端SSE的支持
 *
 */
@RestController
public class SseController {

    /**
     * 每隔5秒钟向浏览器推送随机消息
     * 注意：媒体类型是text/ecent-stream
     *
     *
     * 页面名称：sse.jsp
     *
     * @return
     */
    @RequestMapping(value = "/push",produces = "text/ecent-stream")
    public String push(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SSE---"+System.currentTimeMillis()+"---"+r.nextInt()+"\n\n";
    }

}
