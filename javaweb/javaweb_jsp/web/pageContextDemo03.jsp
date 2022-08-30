<%--
  Created by IntelliJ IDEA.
  User: JWhale
  Date: 2022/8/12
  Time: 上午 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--

public void setAttribute(String name, Object attribute, int scope) {
        switch (scope) {
            case 1:
                this.mPage.put(name, attribute);
                break;
            case 2:
                this.mRequest.put(name, attribute);
                break;
            case 3:
                this.mSession.put(name, attribute);
                break;
            case 4:
                this.mApp.put(name, attribute);
                break;
            default:
                throw new IllegalArgumentException("Bad scope " + scope);
        }
--%>

<%
  pageContext.setAttribute("name1","jzy01",PageContext.SESSION_SCOPE);
  //等价于 request.setAttribute("name1","jzy01");
%>
</body>
</html>
