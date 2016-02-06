<%@ page session="false" %>
<html>
<head>
    <title>Buddies</title>
    <head>
<body>
<%
    Cookie cookies[] = request.getCookies();
    if(cookies!=null)
    {
        String email="", password="";
        for(int i = 0; i < cookies.length; ++i)
        {
            if(cookies[i].getName().equals("email"))
                email = cookies[i].getValue();
            if(cookies[i].getName().equals("password"))
                password = cookies[i].getValue();
        }
        if(!"".equals(email) && !"".equals(password))
        {
%>
<jsp:forward page="logincheck.jsp">
    <jsp:param name="email" value="<%=email%>"></jsp:param>
    <jsp:param name="password" value="<%=password%>"></jsp:param>
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
    <input type="password" name="password" ><br />
    <input type="text" name="mobile" placeholder="Enter Mobile Number"><br/>
    Birthday<br />
    <input type="date" name="dob"><br />
    <input type="radio" name="gender" value="male" />Male
    <input type="radio" name="gender" value="female" />Female <br />
    By clicking Sign Up, you agree to our <a href="terms.jsp">Terms</a>.
    <input type="submit" name="sub2" value="Sign Up" />
</form>

</body>
</html>