<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/28/15
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Check page</title>
    </head>
    <body>
        <jsp:useBean id="dcon" class="buddies.DConnection" />
        <%
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            ResultSet rst = dcon.getData("select * from users where email='"+email+"' and password='"+password+"'");
            Cookie cookie[] = request.getCookies();
            if(cookie != null) {
                for (Cookie cook : cookie) {
                    if (cook.getName().equals("email"))
                        cook.setMaxAge(0);
                    if (cook.getName().equals("password"))
                        cook.setMaxAge(0);
                }
            }
            try {
                if(rst.next()) {
                    int id = rst.getInt(1);
                    String mobile = rst.getString("mobile");
                    rst.close();
                    dcon.close();
                    HttpSession session=request.getSession();
                    session.setAttribute("email", email);
                    session.setAttribute("userid", id);
                    session.setAttribute("mobile", mobile);
                    /*
                    rst=dcon.getData("select * from usersprofile where userid="+userid+"");
                    String fname=rst.getString("fname");
                    rst.close();
                    dcon.close();
                    session.setAttribute("fname",fname);
                    image also
                    */
                    String km = request.getParameter("km");
                    if(km != null && km.equals("on")) {
                        Cookie c1 = new Cookie("email", email);
                        Cookie c2 = new Cookie("password", password);
                        c1.setMaxAge(15*24*3600);
                        c2.setMaxAge(15*24*3600);
                        response.addCookie(c1);
                        response.addCookie(c2);
                    }
        %>
                    <jsp:forward page="home.jsp" />
        <%

                }
                else {
                    out.print("<script>alert('Invalid user or password');</script>");
        %>
                    <jsp:forward page="index.jsp" />
        <%
                }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        %>
    </body>
</html>