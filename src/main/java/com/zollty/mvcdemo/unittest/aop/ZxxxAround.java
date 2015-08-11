package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcAround;
import org.zollty.framework.mvc.aop.MvcJoinPoint;
import org.zollty.framework.mvc.aop.annotation.AopMapping;

@AopMapping({"/aop/*"})
public class ZxxxAround implements MvcAround {

    @Override
    public View doAround(HttpServletRequest request, HttpServletResponse response, MvcJoinPoint pjp) throws Throwable {
        System.out.println(toString()+"++++++++++++++++++execute.....++++++++++++++++++");
        
        System.out.println("start TimeMs="+System.currentTimeMillis());
        View retView = pjp.proceed();
        System.out.println("end   TimeMs="+System.currentTimeMillis());
        
        return retView;
    }
    
    @Override
    public String toString() {
        return getClass().getName();
    }

}