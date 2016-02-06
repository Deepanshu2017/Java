<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/22/15
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Third page</title>
</head>
<body>
    <%!
        int result;
        int sum(int a, int b){ return a + b; }
        int avg(int a, int b) { return sum(a, b) / 2; }
    %>
    <%
        int a = Integer.parseInt(request.getParameter("number1"));
        int b = Integer.parseInt(request.getParameter("number2"));
        String want = request.getParameter("submit");
        if("sum".equals(want))
            result = sum(a, b);
        else
            result = avg(a, b);
    %>
    Result is <%=result%><br />
</body>
</html>
