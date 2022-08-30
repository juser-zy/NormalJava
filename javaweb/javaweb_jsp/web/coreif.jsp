<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 下午 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>if测试</h4>

<hr>

<form action="coreif.jsp" method="get">
<%--
EL表达式获取表单中的数据
${param.参数名}
--%>
    <input type="text" name="user" value="${param.user}">
    <%--<input type="text" name="user" value="${username}">--%>
    <input type="submit" value="登录">
</form>
<%--判断如果提交的用户名是管理员，则登录成功--%>
<%--注意会报错，原因是没有拿到传递的值
<%
    String user = (String) pageContext.findAttribute("user");
    if (user.equals("admin")){
        out.println("登录成功");
    }
%>

--%>


<%--
<c:if test="${param.user=='admin'}" var="isAdmin">
    <c:out value="管理员欢迎你"></c:out>
</c:if>
<c:out value="${param.user}"></c:out>
--%>

</body>
</html>
