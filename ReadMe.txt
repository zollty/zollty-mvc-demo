ZolltyMVC Framework DEMO ( ZolltyMVC 示例项目 )
============================================
See: https://github.com/zollty/zollty-mvc-demo
Docs pages: https://github.com/zollty-org/zollty-mvc/tree/master/docs

// ~~ 以下是新手教程。。。。。。

一、工程搭建说明
==============================================================================
本工程采用Maven构建，以下以新版本Eclipse为例，说明如何导入工程。

1) 打开Eclipse，用Maven方式导入Project：
在项目导航面板鼠标右键 -> import -> Existing Maven Projects -> 选择zollty-mvc-demo项目路径 ->直接导入

2) 导入后就可以直接使用了。比如运行Maven的各种命令：
在项目名上鼠标右键 -> Run as -> Maven Clean
在项目名上鼠标右键 -> Run as -> Maven Install

3) 然后，您可以发布到Tomcat等服务器上去运行。

二、基础 概念和术语 简介
==============================================================================
1、@Controller
	也叫“Action”，即 MVC 中的 "C" 层，“控制层”或者“Web层”或者“Action层”，
	其 类的命名方式 通常为“XxxxController”或者“XxxxAction”（前者常见于SpringMVC中，后者常见于Struts中）
  
2、RESTful风格的URL
	比如：
	http://c.example.com/project/user/login
	http://c.example.com/project/user/regist
	http://c.example.com/project/user/home
	http://c.example.com/project/query/user
	
	Struts常用 ".do" 后缀，比如 “user/login.do”，但是RESTful风格的URL通常“不使用后缀”。

3、@RequestMapping
	请求匹配，寻找该请求对应的处理方法，一个 URI 对应 一个 Java方法去处理。
	比如 /user/login 这个URL（http://c.example.com/project/user/login），对应 像public View login(...)这样的方法 去处理。

4、View
	即视图，表现层，MVC中的“V”层。通常为 HTML、文本（JSON、String）、视图模板（JSP、FreeMaker、Velocity）、二进制文件等
	比如 HtmlView、JspView、JsonView、TextView、FreeMakerView……

5、@HttpParam
	即HTTP请求中的参数（Parameter），常见用法为 request.getParameter("paramName"); 可以简写为 @HttpParam("paramName")

6、HttpServletRequest 和 HttpServletResponse
	HTTP Servlet中的核心类。有很多有用的API可以直接调用。
	
	