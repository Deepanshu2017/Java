<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/23/15
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Forward include demo</title>
</head>
<body>
  1 ka 1 <br />
  <%
    request.setAttribute("at", "attribute");
  %>
  <jsp:forward page="second.jsp">
    <jsp:param name="pa" value="parameter"></jsp:param>
  </jsp:forward>
  1 ka 2 <br />
</body>
</html>
