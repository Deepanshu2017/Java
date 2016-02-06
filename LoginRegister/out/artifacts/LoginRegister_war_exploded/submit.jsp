<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 1/1/16
  Time: 3:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>submit</title>
</head>
<body>
    <jsp:useBean id="dc" class="submit.DatabaseConnection"/>
    <%
        int mode = Integer.parseInt(request.getParameter("mode"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(mode == 1) {
            ResultSet resultSet = dc.getData("select * from details where email='" + email + "' and password='"
                    + password + "'");
            //Now you can use resultSet and get Data
        }
        else if (mode == 2) {
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            dc.setData("insert into details(first_name, last_name, email, password) values (" +
                    "'" + first_name + "', " +
                    "'" + last_name + "', " +
                    "'" + email + "', " +
                    "'" + password + "')");
        }
    %>
        <jsp:forward page="index.jsp" />
</body>
</html>
