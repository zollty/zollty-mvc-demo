package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcAfterThrow;

public class HxxxAfterThrow implements MvcAfterThrow {

    @Override
    public View doAfterThrow(HttpServletRequest request, HttpServletResponse response, Throwable t) {
        System.out.println(toString()+"++++++++++++++++++execute.....++++++++++++++++++");
        
        t.printStackTrace();
        
        return null;
    }
    
    @Override
    public String toString() {
        return getClass().getName();
    }

}
