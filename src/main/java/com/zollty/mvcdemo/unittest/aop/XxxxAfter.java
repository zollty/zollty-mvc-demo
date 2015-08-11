package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.aop.MvcAfter;

public class XxxxAfter implements MvcAfter {

    @Override
    public void doAfter(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(toString()+"++++++++++++++++++execute.....++++++++++++++++++");
    }
    
    @Override
    public String toString() {
        return getClass().getName();
    }

}
