<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 上午 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>1</h2>


<%--<jsp:include></jsp:include>--%>
<%-- http://localhost:8080/jsptag.jsp?name=jzy&age=2 --%>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="name" value="jzy"/>
    <jsp:param name="age" value="2"/>
</jsp:forward>


</body>
</html>
