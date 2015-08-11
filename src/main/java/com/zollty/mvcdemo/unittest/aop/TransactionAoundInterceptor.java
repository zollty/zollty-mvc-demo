package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcAround;
import org.zollty.framework.mvc.aop.MvcJoinPoint;

public class TransactionAoundInterceptor implements MvcAround {

    @Override
    public View doAround(HttpServletRequest request, HttpServletResponse response, MvcJoinPoint pjp)
            throws Throwable {

        System.out.println("------------------------------------------------------Open Transaction: ");
        
        View view = pjp.proceed();

        System.out.println("------------------------------------------------------Close Transaction: ");
        return view;
    }

}
