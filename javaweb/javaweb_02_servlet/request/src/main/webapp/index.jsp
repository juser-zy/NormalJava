<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/10
  Time: 下午 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<div style="text-align: center">
<%--表示以post的方式提交表单，提交到我们的login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="pwd"/><br/>
        爱好：
        <input type="checkbox" name="hobbies" value="看电影"/>看电影
        <input type="checkbox" name="hobbies" value="阅读"/>阅读
        <input type="checkbox" name="hobbies" value="爬山"/>爬山
        <input type="checkbox" name="hobbies" value="摄影"/>摄影
        <br/>
        <input type="submit"/>
    </form>
</div>

</body>
</html>
