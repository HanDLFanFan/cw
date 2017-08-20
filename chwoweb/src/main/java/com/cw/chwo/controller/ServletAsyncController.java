package com.cw.chwo.controller;

import com.cw.chwo.common.scheduled.ServletAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by handl on 2017/8/19.
 *
 * 服务器端推送技术：SSE(Server Send Event) 和Servlet3.0+异步方法处理
 *
 * ervlet3.0+异步方法处理
 */
@RestController
public class ServletAsyncController {

    @Autowired
    private ServletAsyncService servletAsyncService;

    @RequestMapping("/async")
    public DeferredResult<String> deferredCall(){
        return servletAsyncService.getAsyncUpdate();
    }

}
