package com.cw.chwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by handl on 2017/8/18.
 *
 * 服务器端推送技术：SSE(Server Send Event) 和Servlet3.0+异步方法处理
 *
 * SSE：要求支持EventSource对象的浏览器才可以
 *
 * produces = "text/event-stream":媒体类型为text/event-stream，这是服务器端SSE的支持
 *
 *发送的数据前面格式是：“data:”
 */
@Controller
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
    @RequestMapping(value = "/push")
    public void push(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Content-Type", "text/event-stream");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");

        String id = new Date().toString();
        try {
            response.getWriter().println("id:" + id);
            // 向客户端写两行数据
            response.getWriter().println("data:server-sent event is working.");
            response.getWriter().println("data:test server-sent event multi-line data");
            response.getWriter().println();
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
