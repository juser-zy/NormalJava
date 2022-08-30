<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8"  %>
</head>
<body>
<h2>Hello World!</h2>


<%--这里的提交的路径，需要寻找到项目的路径--%>
<%--${pageContext.request.contextPath}代表当前的项目--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    <div>
        用户名username:<input type="text" name="username">
    </div>
    <div>
        密  码password:<input type="password" name="password">
    </div>
    <input type="submit">
</form>
</body>
</html>
