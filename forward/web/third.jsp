<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/23/15
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Third</title>
</head>
<body>
First Message from third jsp<br />
Second Message from third jsp<br />
<jsp:useBean id="object" class="deep.Test"></jsp:useBean>
<jsp:setProperty name="object" property="var1" param="10"></jsp:setProperty>
<jsp:setProperty name="object" property="var2" param="10"></jsp:setProperty>
<%
    object.sum();
%>
Sum is <jsp:getProperty name="object" property="result"></jsp:getProperty><br />
<%
    object.avg();
%>
Avg is <jsp:getProperty name="object" property="result"></jsp:getProperty><br />
</body>
</html>
