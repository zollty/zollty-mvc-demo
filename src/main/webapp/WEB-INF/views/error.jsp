<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.zollty.util.StringUtils, org.zollty.util.ExceptionUtils"%>

<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"></base>
<%@ include file="/WEB-INF/views/meta.jsp"%>
<title>Internal Error</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<style type="text/css">
.content {
	background-color: #e5e5e5;
}
</style>
</head>

<body>
  <h3>An Unexpected Error Occurred! Detailed info is as follows: </h3>
  <pre>
  <%
  out.println("ErrorMsg: <br><pre class=content>"+request.getAttribute("msg")+"</pre>");
  Object oe = request.getAttribute("e");
  if(oe!=null){
	  out.println("StatckInfo: <br><pre class=content>"+StringUtils.simpleHtmlEscape(ExceptionUtils.getStackTraceStr(null, (Throwable)oe))+"</pre>");
  }
  %>
  </pre>
</body>
</html>