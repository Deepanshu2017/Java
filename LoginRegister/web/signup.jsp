<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 1/1/16
  Time: 3:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
    <form action="submit.jsp?mode=2" method="post">
        <table>
            <tr>
                <td> First Name: </td>
                <td> <input type="text" name="first_name" placeholder="Enter First Name" /> </td>
            </tr>
            <tr>
                <td> Last Name: &emsp;</td>
                <td> <input type="text" name="last_name" placeholder="Enter Last Name" /> </td>
            </tr>
            <tr>
                <td> Email: &emsp;</td>
                <td> <input type="email" name="email" placeholder="Enter Email" /> </td>
            </tr>
            <tr>
                <td> Password: &emsp;</td>
                <td> <input type="password" name="password" placeholder="Enter Password" /> </td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" name="submit" value="submit" /> </td>
            </tr>
        </table>
    </form>
</body>
</html>
