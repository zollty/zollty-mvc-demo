package com.zollty.mvcdemo.unittest.di;

import org.zollty.framework.core.annotation.Inject;
import org.zollty.framework.core.annotation.MethodBeanId;
import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.annotation.Controller;
import org.zollty.framework.mvc.annotation.RequestMapping;
import org.zollty.framework.mvc.view.TextView;

import com.zollty.mvcdemo.unittest.bean.entity.Student;
import com.zollty.mvcdemo.unittest.di.service.DiService;

@Controller
public class DiTestController {
    
    // 属性注入，支持按类型注入
    // TODO @Inject("diService")
    @Inject
    private DiService diService;
    
    
    // 方法注入，也支持按bean ID注入【@MethodBeanId("stuZollty")】
    // 支持注入多个bean
    // @see org.zollty.framework.core.beans.support.AbstractBeanFactory#methodInject()
    private Student methodSetStu;
    @Inject // method 注入的好处在于，它可以间接给父类继承的属性赋值，比如继承JdbcTemplate，给DataSource赋值。
    public void setUser(@MethodBeanId("stuZollty") Student stu, DiService diService) {
        stu.setName( stu.getName() + diService.getUser().getName() );
        this.methodSetStu = stu;
    }
    
    @Inject("methodCreateStu")
    private Student methodCreateStu;
    // XML中可以通过此方法获取一个Student实例
    // 注意，该方法暂时不支持参数，若要传参数，可以通过类的属性来传。
    private String name;
    private int age;
    public Student createStudent() {
        Student stu = new Student();
        stu.setName(this.getName());
        stu.setAge(this.getAge());
        return stu;
    }
    
    
    @RequestMapping("/unit/di/test-di")
    public View testBean() {
        
        return new TextView(diService.getUser().toString());
    }
    
    @RequestMapping("/unit/di/method-create")
    public View testMethodCreat() {
        
        return new TextView(methodCreateStu.toString());
    }
    
    @RequestMapping("/unit/di/method-inject")
    public View testMethodInject() {
        
        return new TextView(methodSetStu.toString());
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
