package com.zollty.mvcdemo.unittest.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcBefore;
import org.zollty.framework.mvc.aop.annotation.AopMapping;

//@AopMapping({"99:/lesson1/hello-jsp", "100:/lesson1/hello-json"})
@AopMapping({"-2:/aop/*"})
public class KxxxBefore implements MvcBefore {

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
