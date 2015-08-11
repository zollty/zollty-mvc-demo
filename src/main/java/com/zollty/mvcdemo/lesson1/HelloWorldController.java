package com.zollty.mvcdemo.lesson1;

import org.zollty.framework.mvc.View;
import org.zollty.framework.mvc.annotation.Controller;
import org.zollty.framework.mvc.annotation.HttpParam;
import org.zollty.framework.mvc.annotation.RequestMapping;
import org.zollty.framework.mvc.view.ForwardView;
import org.zollty.framework.mvc.view.HtmlView;
import org.zollty.framework.mvc.view.JsonView;
import org.zollty.framework.mvc.view.JspView;
import org.zollty.framework.mvc.view.RedirectView;

import com.zollty.mvcdemo.lesson1.vo.CatVO;

/**
 * ZolltyMVC Controller用法示例
 * <p>
 * 要点如下：
 * <p>
 * 1、用“@Controller”标注 Controller 类<p>
 * 2、用“@RequestMapping”标注 处理请求的方法
 * 
 */
//@CBefore(AxxxxBefore3.class)
//@Controller("/lesson1")
@Controller
public class HelloWorldController {
    
//    @CBefore({AxxxxBefore.class, AxxxxBefore2.class, AxxxxBefore3.class})
    // 访问URL示例： http://127.0.0.1:8080/zollty-mvc-demo/lesson1/hello
    @RequestMapping("/hello")
    public View hello() {
        
        String name = "ZolltyMVC!";
        
        // 返回一个HTML页面视图（动态组装的HTML）
        return new HtmlView("<html><head><title></title></head><body><h1>"
                + "Hello " + name
                + "</h1></body></html>");
    }
    
    // 访问URL示例： http://127.0.0.1:8080/zollty-mvc-demo/lesson1/hello-html
    @RequestMapping("/lesson1/hello-html")
    public View helloHtml() {
        
        // 返回一个静态资源视图（静态HTML页面）
        return new ForwardView("/pages/lesson1/hello.html");
    }
    
    @RequestMapping("/lesson1/hello-png")
    public View helloPng() {
        
        // 返回一个静态资源视图（静态PNG图片）
        return new RedirectView("/resources/lesson1/hello.png");
    }
    
    @RequestMapping("/lesson1/hello-jsp")
    public View helloJsp() {
        
        // 返回一个JSP页面视图
        return new JspView("/lesson1/hello.jsp"); //其文件路径为 /WEB-INF/views/lesson1/hello.jsp
    }
    
    
    @RequestMapping("/lesson1/hello-json")
    public View helloJosn() {
        
        // 返回一个Json数据视图
        return new JsonView("{\"title\": \"hello\", \"name\": \"ZolltyMVC\"}");
    }
    
    
    
    // ~ 以下是高级使用方法：自动接收参数
    
    
    // 访问URL时，可以附带参数，比如 http://127.0.0.1:8080/zollty-mvc-demo/lesson1/hello-cat?catName=Kitty
    @RequestMapping("POST:/lesson1/hello-cat")
    public View hello(@HttpParam("catName") String catName) {
        
        // 返回一个HTML页面视图（动态组装的HTML）
        return new HtmlView("<html><head><title></title></head><body><h1>"
                + "Hello " + catName
                + "</h1></body></html>");
    }
    
    // 提示： @HttpParam不仅可以接收 String 类型的参数，还可以接收对象参数哦！ 比如 UserVO ，它会自动把里面的值封装
    // 访问URL示例： http://127.0.0.1:8080/zollty-mvc-demo/lesson1/hello-catvo?name=Kitty&age=27
    @RequestMapping("/lesson1/hello-catvo")
    public View hello(@HttpParam("cat") CatVO cat) { // 自动封装一个标准Bean对象
        
        // 返回一个HTML页面视图（动态组装的HTML）
        return new HtmlView("<html><head><title></title></head><body><h1>"
                + "Hello " + cat.getName() + ", Age: " + cat.getAge()
                + ", Width: " + cat.getWidth() + "</h1></body></html>");
    }
    
    
    
    // ~ 以下是高级使用方法：限定HTTP请求的方式（GET、POST、PUT、DELETE等）
    
    @RequestMapping("GET:/lesson1/hello-get") // 前面跟上“GET:”表示该URL只允许以 GET方式 访问
    public View helloGet() {
        
        // 返回一个静态资源视图（静态HTML页面）
        return new RedirectView("/pages/lesson1/hello.html");
    }
    
    @RequestMapping("POST:/lesson1/hello-post") // 前面跟上“POST:”表示该URL只允许以 POST方式 访问
    public View helloPost() {
        
        // 返回一个静态资源视图（静态HTML页面）
        return new RedirectView("/pages/lesson1/hello.html");
    }
    
    
    ////// hello world 教程至此结束，小伙伴们，学会了吗？ 还有更多好用的、DIY的高级用法，参见后续的lesson哦！
    ///// 有任何宝贵意见，改进意见，都欢迎 @zollty 哦！ 发送到：zollty@163.com

}
