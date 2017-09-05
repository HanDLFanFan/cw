package com.cw.chwo.common.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by handl on 2017/8/19.
 *
 *
 * Servlet3.0异步方法定时服务
 *
 * 通过@Scheduled注解的方法定时更新DeferredResult
 * 在ServletAsyncService里产生的DeferredResult给Controller使用，
 *
 *
 */
@Service
public class ServletAsyncService {

    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate(){
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 10000)
    public void refresh(){
        if (deferredResult != null){
            deferredResult.setResult("ServletAsync---"+new Long(System.currentTimeMillis()).toString());
        }
    }
}
