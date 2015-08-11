package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcAfterThrow;
import org.zollty.framework.mvc.aop.annotation.AopMapping;
import org.zollty.framework.mvc.view.TextView;

@AopMapping({"/aop0/*"}) // 默认order=100
public class ZxxxAfterThrow implements MvcAfterThrow {

    @Override
    public View doAfterThrow(HttpServletRequest request, HttpServletResponse response, Throwable t) {
        System.out.println(toString()+"++++++++++++++++++execute.....++++++++++++++++++");
        
        return new TextView("xxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    @Override
    public String toString() {
        return getClass().getName();
    }

}
