package com.zollty.mvcdemo.unittest.web;


public interface MvcInterceptor {

    /**
     * 
     * @param request current HTTP request
     * @param response current HTTP response
     * @return true if the execution chain should proceed with the next interceptor or the handler itself. Else,
     *         DispatcherServlet assumes that this interceptor has already dealt with the response itself.
     * @throws Exception
     */
    //boolean preHandle(HttpServletRequest request, HttpServletResponse response, MvcContext context) throws Exception;

    //void postHandle(HttpServletRequest request, HttpServletResponse response, MvcContext context) throws Exception;

    //void afterCompletion(HttpServletRequest request, HttpServletResponse response, MvcContext context, Exception ex) throws Exception;
    
    
    //
    //A 加在controller类上，直接拦截所有的controller method。
    //B 直接加在controller method上，则只拦截该方法
    //C 直接在 interceptor 上，配置拦截url pattern
    
    /**
     * 
     * @Before(AxxxInterceptor.class)
     * public void post() {
     * 
     * 
     *  @Interceptor(uri={"/admin/*"})
     *  public class AxxxInterceptor implements MvcInterceptor {
     *  
     *    public boolean before(MvcContext context) {}
     *    
     *    public void beforeRender(MvcContext context) {}
     * 
     * 
     */
    
    // 三种模式的匹配顺序：
    // 实现 org.springframework.web.servlet.HandlerInterceptor 接口
    // 继承 org.springframework.web.servlet.handler.HandlerInterceptorAdapter抽象类。
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    // public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    // public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) throws Exception
    
    // Before    (preHandle)     return View 如果传回非null，则接下来的Interceptor或Controller就不处理请求
    // BeforeRender (postHandle) return void
    // AfterThrowing             return View 
    // （AfterReturning）此处没必要
    // After (afterCompletion)   return void
    
    // execute
    // After和AfterThrowing 是否可以合并。如果throw了异常，则 after也可以处理
    
    // 注意，拦截器最好是不要拦截图片、css等资源文件
    
    
    
    /**
     * 如 果有多个通知想要在同一连接点运行会发生什么？Spring AOP
    遵循跟AspectJ一样的优先规则来确定通知执行的顺序。 在“进入”
    连接点的情况下，最高优先级的通知会先执行
    （所以给定的两个前置通知中，优先级高的那个会先执行）。 在“退出”
    连接点的情况下，最高优先级的通知会最后执行。（所以给定的两个后置通知中， 
    优先级高的那个会第二个执行）。
     */
    // 
    
    // 定义切入点
    /**
     * @Before(uri={"/admin/*"}, order=10)
     * public boolean before(MvcContext context) {}
     * 
     * 
     * public class AxxxBefore implements MvcBefore {
     * 
     * 
     * 方式一，定义在 controller method 上
     * @CBefore(cls={AxxxBefore.class}, order={10}) // order可以省略，默认为 4000+n 最后执行【如果是 @CAfter 则是最先执行】
     * public void post() {
     * 
     * @CBefore(cls=AxxxBefore.class, order=10) // order可以省略，默认为 2000+n 中间执行
     * public class RxxxController {
     * 
     * 
     * 方式二，定义在AOP类上，自动匹配
     * 
     * @AOPMapping(uri={"/admin/*"}, order=10) // order可以省略，默认为 0+n 首先执行
     * public class AxxxBefore implements MvcBefore {
     * 
     * 
     * 拦截器顺序问题：
     * 
     * 
     * 对同一个 controller method 上的所有相同类型的拦截器，会按order值进行从小到大排序（小的先执行）
     * 
     * 例如：
     * 
     * @AOPMapping(uri={"/admin/*"})
     * @AOPMapping(uri={"/admin/*", "/lesson1/hello"}, order={0, 2})
     * @AOPMapping({"0:/admin/*", "2:/lesson1/hello"})
     * public class KxxxBefore implements MvcBefore {
     * 
     * @CBefore(cls={AxxxBefore.class, HxxxBefore.class})
     * @Controller
     * public class OneController {
     * 
     *    @CBefore(cls=BxxxBefore.class)
     *    @RequestMapping("/admin/[vv]")
     *    public void doService() {
     * 
     * 
     * 那么执行顺序 为： KxxxBefore(0~999)、AxxxBefore(2000)、HxxxBefore(2001)、BxxxBefore(4000~4999)
     * 
     * 如果要调整顺序，[-1000~0]（1000~2000）[1~999]（2000~3000）[3000+]
     * 通常调整 BxxxBefore 的顺序，则可以指定为 -1000~-1（在Mapping前面）、1000~1999（在Controller前面）
     * 如果调整 AxxxBefore、HxxxBefore 的顺序，则可以指定为 -1000~-1（在Mapping前面）、5000+（在Method后面）
     * 如果调整 KxxxBefore 的顺序，则可以指定为 3000~3999（在Controller后面）、5000+（在Method后面）
     * 
     * 对Before、BeforeRender而言，越前面的、越小的先执行，所以执行顺序： 全局的KxxxBefore(0~999)，AxxxBefore(2000)、HxxxBefore(2001)，BxxxBefore(4000~4999)
     * 对After、AfterThrowing而言，执行顺序： BxxxBefore(4000~4999)，AxxxBefore(2000)、HxxxBefore(2001)，全局的KxxxBefore(0~999)
     * 
     */
    
    
    
    
    

}