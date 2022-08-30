<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 上午 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  pageContext.forward("${pageContext.request.contextPath}/index.jsp");
  //request.getRequestDispatcher("/index.jsp").forward(request, response);
%>

</body>
</html>
