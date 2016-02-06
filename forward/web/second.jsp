<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/23/15
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 2</title>
</head>
<body>
    2 ka 1 <br />
    <%=(String)request.getAttribute("at")%><br />
    <jsp:include page="third.jsp"></jsp:include>
    <%
        out.print(request.getParameter("pa"));
    %> <br />
    2 ka 2
</body>
</html>