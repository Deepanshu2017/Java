<%@ page import="java.sql.*" session="false"%>
<!doctype html>
<html>
<head>
</head>
<body>
<jsp:useBean id="dcon" class="buddies.DConnection"></jsp:useBean>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String dob = request.getParameter("dob");
    String gen = request.getParameter("gender");
    String mobile=request.getParameter("mobile");

    try {
        dcon.setData("insert into users(email, password, mobile) values('"+email+"', '"+password+"', '"+mobile+"')");
        ResultSet rst = dcon.getData("select max(userid) from users");
        rst.next();
        int userid = rst.getInt(1);
        dcon.setData("insert into usersprofile(userid, fname, lname, dob, gender) values("+userid+", '"+fname+"', '"+lname+"', '"+dob+"', '"+gen+"')");
    }
    catch(SQLException e) {
        e.printStackTrace();
    }
%>


<jsp:forward page="index.jsp"></jsp:forward>
</body>
</html>