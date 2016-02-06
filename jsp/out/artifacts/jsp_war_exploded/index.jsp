<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/22/15
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>This is first jsp page</title>
    <style>
      .box {
        width:200px;
        height:200px;
        margin: 10px 10px 10px 10px;
        padding: 5px 5px 5px 5px;
        background-color: silver;
      }
    </style>
  </head>
  <body>

    <form action="second.jsp" method="post">
      Name<input type="text" name="name" value="" /><br />
      <input type="submit" name="submit" value="submit" />
    </form>

    <select name="days">
      <%
        for(int i = 1; i < 32; ++i) {
      %>
      <option value="<%=i%>"><%=i%></option>
      <%
        }
      %>
    </select><br />

    <form action="third.jsp" method="post">
      Number1<input type="text" name="number1" value="" /><br />
      Number2<input type="text" name="number2" value="" /><br />
      <input type="submit" name="submit" value="sum" />&nbsp;&nbsp;
      <input type="submit" name="submit" value="average" />
    </form><br />
  <div class="box">
    Pooja
  </div>
  </body>
</html>
