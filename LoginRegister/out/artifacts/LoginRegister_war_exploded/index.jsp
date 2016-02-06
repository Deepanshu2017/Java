<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 1/1/16
  Time: 3:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <form action="submit.jsp?mode=1" method="post">
      <table>
        <tr>
          <td> Email: &emsp;</td>
          <td> <input type="email" name="email" placeholder="Enter Email" /> </td>
        </tr>

        <tr>
          <td> Password: &emsp;</td>
          <td> <input type="password" name="password" placeholder="Enter password" /> </td>
        </tr>
        <tr>
          <td colspan="2"> <input type="submit" name="submit" value="submit" /> </td>
        </tr>
      </table>
    </form>
    <br />
    Not registered already? <a href="signup.jsp">SignUp</a>
  </body>
</html>
