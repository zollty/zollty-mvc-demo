package com.zollty.mvcdemo.unittest.di;

import java.util.Map;

import org.junit.Test;
import org.zollty.framework.core.beans.ConfigurableBeanFactory;
import org.zollty.framework.core.config.impl.DefaultXmlConfig;
import org.zollty.framework.core.context.ApplicationContext;
import org.zollty.framework.core.context.support.ClassPathAnnotationAndXmlApplicationContext;

public class NotWebDiTest {
    
    private ApplicationContext appContext = new ClassPathAnnotationAndXmlApplicationContext(new DefaultXmlConfig());
    
    
    @Test
    public void test(){
        for(Map.Entry<String, Object> entry : appContext.getBeanMap().entrySet()) {
            System.out.println(entry.getValue().getClass().getName()+": "+entry.getKey());
        }
        
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        
        ((ConfigurableBeanFactory) appContext).refresh();
    }

}
