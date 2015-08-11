package com.zollty.mvcdemo.tool;

import javax.servlet.http.HttpServletRequest;

import org.zollty.util.ExceptionUtils;

import com.zollty.mvcdemo.tool.json.SimpleJsonWrapper;

/**
 * @author zollty 
 * @since 2013-10-21
 */
public class WebUtils {

    private WebUtils(){
    }
    
	/**
	 * 获取网站主路径，比如 http://localhost:8080/report/
	 * @param request
	 * @return 网站主路径
	 * @author zollty
	 */
	public static String getContextPath(HttpServletRequest request){
		StringBuilder sb = new StringBuilder(50);
		sb.append(request.getScheme());
		sb.append("://");
		sb.append(request.getServerName());
		sb.append(':');
		sb.append(request.getServerPort());
		sb.append(request.getContextPath());
		sb.append('/');
		return sb.toString();
	}
	
	/**
	 * 先弹出提示信息，然后在跳转到指定页面
	 * @param alertmsg
	 * @param location
	 * @return 组装好的html页面
	 * @author zollty
	 */
	public static String jumpTo(String alertmsg, String location) {
	    StringBuilder sb = new StringBuilder(200+alertmsg.length());
		sb.append("<html><head><script>window.onload=function(){alert('");
		sb.append(alertmsg);
		sb.append("');window.location='"+location+"'}</script></head><body></body></html>");
		return sb.toString();
	}
	public static String jumpTo(String alertmsg, String uri, HttpServletRequest request) {
		return jumpTo(alertmsg, WebUtils.getContextPath(request)+uri);
	}
	/**
	 * 
	 * 先弹出提示信息，然后再跳转到Iframe上一级的指定页面
	 * @param alertmsg
	 * @param location
	 * @return 组装好的html页面
	 * @author zollty
	 */
	public static String jumpOutIframe(String alertmsg, String location) {
	    StringBuilder sb = new StringBuilder(200+alertmsg.length());
		sb.append("<html><head><script>window.onload=function(){alert('");
		sb.append(alertmsg);
		sb.append("');parent.location.href='"+location+"'}</script></head><body></body></html>");
		return sb.toString();
	}
	public static String jumpOutIframe(String alertmsg, String uri, HttpServletRequest request) {
		return jumpOutIframe(alertmsg, WebUtils.getContextPath(request)+uri);
	}
	
	/**
	 * 弹出alert信息
	 * @param alertmsg
	 * @return 组装好的html页面
	 * @author zollty
	 */
	public static String alertHtml(String alertmsg) {
	    StringBuilder sb = new StringBuilder(120+alertmsg.length());
		sb.append("<html><head><script>window.onload=function(){alert('");
		sb.append(alertmsg);
		sb.append("');}</script></head><body></body></html>");
		return sb.toString();
	}
	
	/**
	 * 将错误信息精简成便于网页alert显示的长度
	 * @param e
	 * @param prompt
	 * @author zollty
	 */
	public static String processAlertErrorInfo(Throwable e, String prompt){
		if(e!=null){
			String em = e.getMessage();
			if( em!=null && em.length()>10){
				return ExceptionUtils.getExceptionProfile(e, prompt, 150);
			}else{
				return ExceptionUtils.getStackTraceStr(null, e, prompt);
			}
		}else{
			return prompt;
		}
	}
	
	
    /**
     * 返回一个最简单的错误结果，举例如下： {"resultType": "000", "errorCode": "0x0001",
     * "errorMsg": "maxNum: 10; currentNum: 11"} 注意resultType默认为000
     */
    public static String buildErrorResultJson(String errorCode, String errorMsg) {
        errorMsg = ExceptionUtils.errorMsgCut(errorMsg, 200); // 裁剪错误信息，最多只保留200长度
        SimpleJsonWrapper sjson = new SimpleJsonWrapper();
        sjson.addItem("resultType", "000");
        sjson.addItem("errorCode", errorCode);
        sjson.addItem("errorMsg", errorMsg);
        return sjson.toString();
    }
	

}
