package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcBefore;
import org.zollty.framework.mvc.aop.annotation.AopMapping;

@AopMapping(value={"/aop/*"})
public class K2xxBefore implements MvcBefore {

    @Override
    public View doBefore(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(toString()+"++++++++++++++++++execute.....++++++++++++++++++");
        return null;
    }
    
    @Override
    public String toString() {
        return getClass().getName();
    }

}
