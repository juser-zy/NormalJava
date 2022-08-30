<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/11
  Time: 下午 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--JSP表达式
  作用,用来将程序的输出,输出到客户端
  <%=变量或者表达式%>
  --%>
  <%=new java.util.Date()%>

  <hr>
  <%--JSP脚本片段--%>
  <%
    int sum = 0;
    for(int i = 0 ; i <=100 ;i++){
      sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
  %>

  <%
    int x = 10;
    out.println(x);
  %>
  <p>这是一个JSP文档</p>
  <%
    int y = 2;
    out.println(y);
  %>
  <hr>
  <%--在代码中嵌入html元素--%>
  <%
    for (int j = 0; j < 5; j++) {
  %>
  <h2>hello<%=j%></h2>
  <%
    }
  %>

  <hr>
  <%--声明--%>
  <%!
    static {
      System.out.println("servlet is loading...");
    }

    private String globalVar = "jzy";

    public void jzy() {
      System.out.println("jzy method");
    }
  %>

  <%jzy();%>


  </body>
</html>
