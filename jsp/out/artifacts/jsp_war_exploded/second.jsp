<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/22/15
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second page</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        out.print("Hello, " + name);
    %>
</body>
</html>
