package com.zollty.mvcdemo.unittest.di.dao;

import org.zollty.framework.core.annotation.Component;
import org.zollty.framework.core.annotation.Inject;

import com.zollty.mvcdemo.unittest.bean.entity.Student;

// TODO 加上这个会报错，因为已经有一个 DiDaoImpl @Component("diDao") 了，而这个无ID，那么根据类型注入的时候，就不知道选择哪一个了
// 同理，当有按类型注入DiDao时，@Component("diDao2")也会报错，因为存在两个DiDao接口的实例，不知道要注入哪一个。
//@Component
@Component("diDao2")
public class DiDaoJdbcImpl implements DiDao {
    
    @Inject("stuZollty")
    private Student stu;
    
    
    public Student getUser() {
        
        return stu;
    }

}
