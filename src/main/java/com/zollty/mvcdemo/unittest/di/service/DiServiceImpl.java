package com.zollty.mvcdemo.unittest.di.service;

import org.zollty.framework.core.annotation.Component;
import org.zollty.framework.core.annotation.Inject;

import com.zollty.mvcdemo.unittest.bean.entity.Student;
import com.zollty.mvcdemo.unittest.di.dao.DiDao;

@Component("diService")
public class DiServiceImpl implements DiService {
    
    @Inject("diDao")
    private DiDao diDao;

    public Student getUser() {
        return diDao.getUser();
    }

}
