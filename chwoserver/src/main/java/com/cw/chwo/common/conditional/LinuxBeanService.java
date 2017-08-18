package com.cw.chwo.common.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * Created by handl on 2017/8/17.
 *
 * 分支子类
 *
 * 艾特Conditional(子类生成判断条件)
 */
@Service
@Conditional(LinuxConditional.class)
public class LinuxBeanService implements BeanService {
    @Override
    public String showBeanCmd() {
        return "ls";
    }
}
