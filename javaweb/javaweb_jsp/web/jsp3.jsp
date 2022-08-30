<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 上午 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@include file="common/header.jsp"%>
    <h1>body</h1>
    <%@include file="common/footer.jsp"%>

    <%--jsp标签--%>
    <jsp:include page="common/header.jsp"></jsp:include>
    <h1>jspbody</h1>
    <jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>
