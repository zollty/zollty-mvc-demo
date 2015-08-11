package com.zollty.mvcdemo.unittest.di.dao;

import org.zollty.framework.core.annotation.Component;
import org.zollty.framework.core.annotation.Inject;

import com.zollty.mvcdemo.unittest.bean.entity.Student;

@Component("diDao")
public class DiDaoImpl implements DiDao {
    
    @Inject("stuZollty")
    private Student stu;
    
    
    public Student getUser() {
        
        return stu;
    }

}
