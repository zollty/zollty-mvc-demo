package com.zollty.mvcdemo.lesson1;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.annotation.Controller;
import org.zollty.framework.mvc.annotation.HttpParam;
import org.zollty.framework.mvc.annotation.RequestMapping;
import org.zollty.framework.mvc.view.TextView;
import org.zollty.util.StringUtils;

import com.zollty.mvcdemo.lesson1.vo.RegistVO;

/**
 * ZolltyMVC Controller用法示例
 * <p>
 * 要点如下：
 * <p>
 * 1、用“@Controller”标注 Controller 类<p>
 * 2、用“@RequestMapping”标注 处理请求的方法
 * 
 */

@Controller
public class UserController {
    
    public static Map<String, String> loginUsers = new HashMap<String, String>();
    
    static {
        loginUsers.put("admin", "admin");
    }
    
    /**
     * 用户登录： http://127.0.0.1:8080/zollty-mvc-demo/user/login
     */
    @RequestMapping("/user/login")
    public View login(
            @HttpParam("username") String username, 
            @HttpParam("password") String password) {
        
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return new TextView("对不起，请输入正确的用户名和密码");
        }
        
        if( !loginUsers.containsKey(username) ) {
            return new TextView("对不起，该用户不存在，请用admin/admin，或者注册一个新用户！");
        }
        
        if( !password.equals(loginUsers.get(username)) ) {
            return new TextView("对不起，密码错误！");
        }
        
        return null;
    }
    
    @RequestMapping("POST:/user/regist")
    public View regist(HttpServletRequest request, 
            @HttpParam("registVO") RegistVO registVO){
        
        if(StringUtils.isBlank(registVO.getUsername()) || StringUtils.isBlank(registVO.getPassword())) {
            return new TextView("对不起，请输入正确的用户名和密码");
        }
        
        if( loginUsers.containsKey(registVO.getUsername()) ) {
            return new TextView("对不起，该用户已存在，请换一个用户名！");
        }
        
        loginUsers.put(registVO.getUsername(), registVO.getPassword());
        
        return null;
    }

}
