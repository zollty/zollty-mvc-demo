package com.zollty.mvcdemo.unittest.web;


//@Interceptor(uri = {"/user/**","/lesson1/**"}, order = 0)
public class InterceptorUnitTestInterceptor {
    
//    public View dispose(HandlerChain chain, HttpServletRequest request,
//            HttpServletResponse response) {
//        
//        boolean ajaxRequest = HttpHelper.isAjaxRequest(request);
//        
//        String user = (String) request.getParameter("user");
//        
//        if (user == null) {
//            if (!ajaxRequest) {
//                return new HtmlView(WebUtils.jumpTo("对不起,你未登录!","index.html",request));
//            } else {
//                try {
//                    response.sendError(408);
//                } catch (IOException e) {
//                }
//                return new TextView("对不起,你未登录!");
//            }
//        }
//        
//        return chain.doNext(request, response, chain);
//    }

}
