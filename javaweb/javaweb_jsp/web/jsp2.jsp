<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 上午 9:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--定制错误页面--%>
<%@page errorPage="error/500.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  int i = 1/0;
%>

</body>
</html>
