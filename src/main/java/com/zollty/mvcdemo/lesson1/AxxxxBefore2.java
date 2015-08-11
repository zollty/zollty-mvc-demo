package com.zollty.mvcdemo.lesson1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcBefore;
import org.zollty.framework.mvc.aop.annotation.AopMapping;

@AopMapping({"100:/lesson1/hello-jsp", "101:/lesson1/hello-json"})
public class AxxxxBefore2 implements MvcBefore {
    
    // @AopMapping
    
    
    @Override
    public View doBefore(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("++++++++++++++++++Before222222 execute.....++++++++++++++++++");
        
        return null;
    }
    
    @Override
    public String toString() {
        return AxxxxBefore2.class.getName();
    }

}
