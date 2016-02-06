<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/24/15
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/login.tld" prefix="my" %>
<html>
<head>
    <title>Second</title>
</head>
<body>
<%
    String s1 = request.getParameter("username");
    String s2 = request.getParameter("password");
%>
    <my:login user="<%=s1%>" pass="<%=s2%>"></my:login>
</body>
</html>
