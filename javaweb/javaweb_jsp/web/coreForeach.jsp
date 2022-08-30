<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 下午 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  List<String> personList = new ArrayList<>();
  personList.add(0, "张三");
  personList.add(1, "李四");
  personList.add(2, "王五");
  personList.add(3, "赵六");
  request.setAttribute("personList", personList);
%>

<%--
var 每一次遍历出来的变量
item 要遍历的对象
begin 开始下标
end 结束下标
step  步长
--%>
<c:forEach var="person" items="${personList}">
  <c:out value="${person}"/><br/>
</c:forEach>
<hr/>
<c:forEach var="person" items="${personList}" begin="1" end="3" step="2">
  <c:out value="${person}"/><br/>
</c:forEach>



</body>
</html>
