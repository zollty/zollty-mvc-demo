package com.zollty.mvcdemo.unittest.web;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.annotation.Controller;
import org.zollty.framework.mvc.annotation.RequestMapping;
import org.zollty.framework.mvc.annotation.URIParam;
import org.zollty.framework.mvc.view.TextView;

/**
 * ZolltyMVC Controller 单元测试
 */
@Controller
public class ControllerUnitTestController {
    
    ///////////////////////以下两个方法URI相同，但是请求方式不同，也是OK的。
    @RequestMapping("POST:/user/ll1")
    public View rest1() {
        return null;
    }

    @RequestMapping("GET:/user/ll1")
    public View rest2() {
        return new TextView("OK！");
    }
    
    
    // 注意 '/user/ll1/'与 '/user/ll1'的区别，前者多一个'/'符号，这个符号也是有效的，
    // 可以把它视为普通字母，多一个和少一个是有区别的
    @RequestMapping("GET:/user/ll1/")
    public View rest3() {
        return new TextView("OK3！");
    }  
    
    
    /////////////////以下两个方法会冲突，只能选择一个///////////////////////////
    @RequestMapping("GET:/user/{name}/")
    public View rest4() {
        return new TextView("OK4！");
    }
    // TODO
//    @RequestMapping("GET:/{kk}/{name}/")
//    public View rest5() {
//        return new TextView("OK5！");
//    }
    //////////////////////////////////////////////
    
    // 以下这个定义，是已经包含在上面的 'GET:/user/{name}/' 之中的，我们不推荐这么做，但是仍然允许这种定义。
    // 框架启动时，检测到有这种情况时，会给出WARN级别的提示。
    @RequestMapping("GET:/user/joe/")
    public View rest6() {
        return new TextView("OK6！");
    }
    
    //////////////////////////////// 复杂匹配测试
    @RequestMapping("GET:/{v1}/ab/{v2}-{v3}/{v4}") // 例如 /P/ab/CC-TD/S -- [P, CC, TD, S]
    public View rest7(@URIParam("v1") String v1,
            @URIParam("v2") String v2,
            @URIParam("v3") String v3,
            @URIParam("v4") String v4) {
        
        return new TextView("OK7！"+v1+"]["+v2+"]["+v3+"]["+v4);
    }
    
    // 注意 中括号的[v1]代表是'**'，而花括号的{v2}代表的是'*'
    @RequestMapping("POST:/ab/[v1]/f/{v2}/c/") // 例如 /ab/a/f/CC/f/M/c/ -- [a/f/CC, M]
    public View rest7(@URIParam("v1") String v1,
            @URIParam("v2") String v2) {
        
        return new TextView("OK7！["+v1+"]["+v2+"]");
    }
    
    // 以下方法和上面那个方法匹配规则有重叠，但是这个是GET，上面那个是POST，所以不会有冲突
    @RequestMapping("GET:[v1]/ab/[v2]/f/{v3}/c/[v4]") // 例如 /ab/a/f/CC/f/M/c/ -- [, a/f/CC, M, ]
    public View rest8(@URIParam("v1") String v1,
            @URIParam("v2") String v2,
            @URIParam("v3") String v3,
            @URIParam("v4") String v4) {
        
        return new TextView("OK8！["+v1+"]["+v2+"]["+v3+"]["+v4);
    }
    
    @RequestMapping("GET:[v1]/a[v2]c{v3}d/") // 例如 /a/c/ac/d/cd/ -- [, /c/ac/d/, ]
    public View rest8(@URIParam("v1") String v1,
            @URIParam("v2") String v2,
            @URIParam("v3") String v3) {
        
        return new TextView("OK8！["+v1+"]["+v2+"]["+v3+"]");
    }
    
    
}
