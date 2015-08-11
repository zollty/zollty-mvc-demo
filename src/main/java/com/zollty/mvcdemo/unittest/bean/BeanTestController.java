package com.zollty.mvcdemo.unittest.bean;

import org.zollty.framework.core.annotation.Inject;
import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.annotation.Controller;
import org.zollty.framework.mvc.annotation.RequestMapping;
import org.zollty.framework.mvc.view.TextView;

import com.zollty.mvcdemo.unittest.bean.entity.Student;

@Controller
public class BeanTestController {

    @Inject("stuZollty")
    private Student stu;
    
    @RequestMapping("/unit/bean/test-bean")
    public View testBean() {
        
        return new TextView(stu.toString());
    }
    
}
