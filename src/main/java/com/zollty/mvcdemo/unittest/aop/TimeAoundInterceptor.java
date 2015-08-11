package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcAround;
import org.zollty.framework.mvc.aop.MvcJoinPoint;
import org.zollty.framework.mvc.aop.annotation.AopMapping;

@AopMapping("/aop/**")
public class TimeAoundInterceptor implements MvcAround {

    @Override
    public View doAround(HttpServletRequest request, HttpServletResponse response, MvcJoinPoint pjp)
            throws Throwable {
        
        
        long begin = System.currentTimeMillis();
        System.out.println("------------------------------------------------------New time: "
                + begin);
        
        View view = pjp.proceed();

        System.out.println("------------------------------------------------------Cost time: "
                + (System.currentTimeMillis() - begin));
        return view;
    }

}