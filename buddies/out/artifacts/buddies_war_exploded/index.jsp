<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/28/15
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
    <head>
        <title>Buddies</title>
    </head>
    <body>
        <%
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                String email="", password="";
                for(Cookie cook : cookies) {
                    if(cook.getName().equals("email"))
                        email = cook.getValue();
                    if(cook.getName().equals("password"))
                        password = cook.getValue();
            }
            if(!"".equals(email) && !"".equals(password)) {
        %>
                <jsp:forward page="logincheck.jsp">
                    <jsp:param name="email" value="<%=email%>" />
                    <jsp:param name="password" value="<%=password%>" />
                </jsp:forward>
        <%
                    return;
                }
            }
        %>

        <!--Login form-->
        <form action="logincheck.jsp" method="post" id="loginform">
            email<input type="mail" name="email">
            password<input type="password" name="password">
            <input type ="checkbox" name="km">Keep me Logged
            <input type="submit" name="sub1" value="Log In">
        </form>

        <!--SignUp form-->
        <form action="signup.jsp" method="post" id="signupform">
            <input type="text" name="fname" placeholder="Enter First Name"><br />
            <input type="text" name="lname" placeholder="Enter Last Name"><br />
            <input type="email" name="email" placeholder="Enter Email ID"><br />
            <input type="email" name="retypeemail" placeholder="Enter Email ID again"><br />
            <input type="password" name="password" /><br />
            Birthday<br />
            <input type="date" name="dob" /><br />
            <input type="text" name="mobile"/><br />
            <input type="radio" name="gender" value="male" />Male
            <input type="radio" name="gender" value="female" />FeMale <br />
            By clicking Sign Up, you agree to our <a href="terms.jsp">Terms</a>.
            <input type="submit" name="sub2" value="Sign Up" />
        </form>
    </body>
</html>