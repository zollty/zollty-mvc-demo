package com.zollty.mvcdemo.unittest.aop;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.annotation.Controller;
import org.zollty.framework.mvc.annotation.HttpParam;
import org.zollty.framework.mvc.annotation.RequestMapping;
import org.zollty.framework.mvc.annotation.URIParam;
import org.zollty.framework.mvc.aop.annotation.CAfter;
import org.zollty.framework.mvc.aop.annotation.CAfterThrow;
import org.zollty.framework.mvc.aop.annotation.CAround;
import org.zollty.framework.mvc.aop.annotation.CBefore;
import org.zollty.framework.mvc.aop.annotation.CBeforeRender;
import org.zollty.framework.mvc.view.TextView;

/**
 * ZolltyMVC Controller AOP 单元测试
 */
@CBefore({HxxxBefore.class})
@CAround({HxxxAround.class, H2xxAround.class})
@CBeforeRender({HxxxBeforeRender.class, H2xxBeforeRender.class})
@CAfter(HxxxAfter.class)
@Controller
public class AopUnitTestController {
    
    
    @CBefore({AxxxBefore.class, BxxxBefore.class})
    @CAround({XxxxAround.class, YxxxAround.class})
    @CBeforeRender({XxxxBeforeRender.class, YxxxBeforeRender.class})
    @CAfterThrow(HxxxAfterThrow.class)
    @CAfter(XxxxAfter.class)
    @RequestMapping("GET:/aop/a1") // http://localhost:8080/zollty-mvc-demo/aop/a1?f=3
    public View doService(@HttpParam("f") int flag) {
        
        if(flag==1) { // 报错，执行 CAfterThrowing
            int i=0;
            i = 100/i;
        }
        
        return new TextView("OK！");
    }
    
    @CAround({OpenSessionSwitchAoundInterceptor.class, TransactionAoundInterceptor.class})
    @RequestMapping("GET:/aop/c/[age]")
    public View doServicec(@URIParam("age") int age) {
        
        return new TextView("OK！ Age="+age);
    }

}
