package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcAround;
import org.zollty.framework.mvc.aop.MvcJoinPoint;
import org.jretty.util.ThreadUtils;

public class OpenSessionSwitchAoundInterceptor implements MvcAround {

    @Override
    public View doAround(HttpServletRequest request, HttpServletResponse response, MvcJoinPoint pjp)
            throws Throwable {

        System.out.println("------------------------------------------------------Open Session: ");
        
        View view = pjp.proceed();
        
        ThreadUtils.sleepThread(2000L);

        System.out.println("------------------------------------------------------Close Session: ");
        return view;
    }

}
