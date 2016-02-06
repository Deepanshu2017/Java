<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/28/15
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <jsp:useBean id="dcon" class="buddies.DConnection" />
        <%
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String mobile = request.getParameter("mobile");
            String gender = request.getParameter("gender");
            try {
                dcon.setData("insert into users(email, password, mobile) values('"+email+"', '"+password+"', '"+mobile+"')");
                ResultSet rst = dcon.getData("select max(id) from users");
                rst.next();
                int id = rst.getInt(1);
                dcon.setData("insert into usersprofile(id, fname, lname, dob, gender) values("+id+", '"+fname+"', '"+lname+"', '"+dob+"', '"+gender+"')");
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        %>
        <jsp:forward page="index.jsp" />
    </body>
</html>