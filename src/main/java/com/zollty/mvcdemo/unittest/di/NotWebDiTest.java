package com.zollty.mvcdemo.unittest.di;

import org.junit.Test;
import org.zollty.framework.core.beans.BeanDefinition;
import org.zollty.framework.core.beans.ConfigurableBeanFactory;
import org.zollty.framework.core.config.impl.DefaultXmlConfig;
import org.zollty.framework.core.context.ApplicationContext;
import org.zollty.framework.core.context.support.ClassPathAnnotationAndXmlApplicationContext;

public class NotWebDiTest {
    
    private ApplicationContext appContext = new ClassPathAnnotationAndXmlApplicationContext(new DefaultXmlConfig());
    
    
    @Test
    public void test(){
        for(BeanDefinition def: appContext.getBeanDefinitions()) {
            System.out.println(def.getClassName()+": "+def.getId());
        }
        
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        
        ((ConfigurableBeanFactory) appContext).refresh();
    }

}
