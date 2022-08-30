<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 上午 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--内置对象--%>
<%
  session.setAttribute("user","jzy");
  pageContext.setAttribute("name1","jzyy01");//保存的数据只在一个页面中有效
  request.setAttribute("name2","jzyy02");//保存的数据只在一次请求中有效，请求转发会携带这个数据
  session.setAttribute("name3","jzyy03");//保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
  application.setAttribute("name4","jzy04");//保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>

<%--脚本片段中的代码，会原封不动生成xxx.jsp.java
要求：这里面的代码，必须保证java语法的正确性
--%>
<%
  //从pageContext取出，我们通过寻找的方式来
  String name1 = (String) pageContext.findAttribute("name1");
  String name2 = (String) pageContext.findAttribute("name2");
  String name3 = (String) pageContext.findAttribute("name3");
  String name4 = (String) pageContext.findAttribute("name4");
  String name5 = (String) pageContext.findAttribute("name5");//不存在
%>

<%--使用el表达式输出  ${} --%>
<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}不存在</h3>
<h3><%=name5%>不存在</h3>
</body>
</html>
