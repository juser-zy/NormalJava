<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 下午 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.jzy.pojo.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
//  People people = new People();
//  people.setAddress("南京");
//  people.setId(1);
//  people.setAge(5);
//  people.setName("jzy");
%>

<jsp:useBean id="people" class="com.jzy.pojo.People" scope="page"></jsp:useBean>
<jsp:setProperty name="people" property="address" value="南京"></jsp:setProperty>
<jsp:setProperty name="people" property="age" value="12"></jsp:setProperty>
<jsp:setProperty name="people" property="id" value="1"></jsp:setProperty>
<jsp:setProperty name="people" property="name" value="jzy"></jsp:setProperty>

姓名：<jsp:getProperty name="people" property="name"/>
ID ：<jsp:getProperty name="people" property="id"/>
年龄：<jsp:getProperty name="people" property="age"/>

</body>
</html>
