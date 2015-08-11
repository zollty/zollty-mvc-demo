package com.zollty.mvcdemo.lesson1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcBefore;
import org.zollty.framework.mvc.aop.annotation.AopMapping;

@AopMapping({"99:/lesson1/hello-jsp", "100:/lesson1/hello-json"})
public class AxxxxBefore implements MvcBefore {

    @Override
    public View doBefore(HttpServletRequest request, HttpServletResponse response) {
        
        System.out.println("++++++++++++++++++Before111111 execute.....++++++++++++++++++");
        return null;
    }
    
    @Override
    public String toString() {
        return AxxxxBefore.class.getName();
    }

}
