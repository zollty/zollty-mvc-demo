package com.zollty.mvcdemo.lesson1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.aop.MvcBefore;

public class AxxxxBefore3 implements MvcBefore {
    
    int i;

    @Override
    public View doBefore(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("++++++++++++++++++Before333333 execute.....++++++++++++++++++"+i++);
        int i=9;
        if(i>0){
            //throw new NestedRuntimeException(new IllegalArgumentException("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"));
        }
        return null;
    }
    
    @Override
    public String toString() {
        return AxxxxBefore3.class.getName();
    }

}
