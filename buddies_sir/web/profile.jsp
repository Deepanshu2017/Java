<%@ page session="false" import="java.sql.*" isELIgnored="false"%>
<html>
<head>
    <title>Profile</title>
    <head>
<body>
<%
    HttpSession session=request.getSession(false);
    if(session==null)
    {
        out.print("<script>alert('Login first');</script>");
%>
<jsp:include page="index.jsp"></jsp:include>
<%
        return;
    }

%>
<div class="container">
    <div class="header">
        <%@ include file="header.jsp" %>
    </div><!-- end .header -->
    <div class="sidebar1">
        <%@ include file="sidebar1.jsp" %>
    </div><!-- end .sidebar1 -->
    <div class="content">
        <jsp:useBean id="p1" class="buddies.Profile" ></jsp:useBean>
        <%
            String mode=request.getParameter("mode");
            if("display".equals(mode))
            {
                try
                {
                    ResultSet rst=p1.display("${sessionScope.userid}");
                    rst.next();
        %>
        <table>
            <tr>
                <td>Name</td>
                <td><%=rst.getString("fname")%> <%=rst.getString("lname")%></td>
            </tr>
            <tr>
                <td>DOB</td>
                <td><%=rst.getString("dob")%></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><%=rst.getString("gender")%></td>
            </tr>
        </table>
        <%
            }
            catch(SQLException e)
            {
                out.print(e);
            }
        }
        else if("edit".equals("mode"))
        {
            try
            {
                ResultSet rst=p1.display("${sessionScope.userid}");
                rst.next();
        %>
        <form action="profile.jsp?mode=update" method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="fname" value="<%=rst.getString("fname")%>" /><input type="text" name="lname" value="<%=rst.getString("lname")%>" /></td>
                </tr>
                <tr>
                    <td>DOB</td>
                    <td><input type="date" name="dob" value="<%=rst.getString("dob")%>" /></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <%
                            String gender=rst.getString("gender");
                            if("male".equals(gender))
                            {
                        %>
                        <input type="radio" name="gender" value="male" checked="on" /><input type="radio" name="gender" value="female" />
                        <%
                        }
                        else
                        {
                        %>
                        <input type="radio" name="gender" value="male" /><input type="radio" name="gender" value="female" checked="on" />
                        <%
                            }
                        %>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="submit" value="update" />
                </tr>
            </table>
        </form>
        <%
            }
            catch(SQLException e)
            {
                out.print(e);
            }

        }
        else
        {
        %>
        <jsp:setProperty name="p1" property="fname" param="fname" ></jsp:setProperty>
        <jsp:setProperty name="p1" property="lname" param="lname" ></jsp:setProperty>
        <jsp:setProperty name="p1" property="dob" param="dob" ></jsp:setProperty>
        <jsp:setProperty name="p1" property="gender" param="gender" ></jsp:setProperty>
        <%
                p1.update((Integer)session.getAttribute("userid"));
            }
        %>


    </div><!-- end .content -->
    <div class="sidebar2">
        <%@ include file="sidebar2.jsp" %>
    </div><!-- end .sidebar2 -->
    <div class="footer">
        <%@ include file="footer.jsp" %>
    </div><!-- end .footer -->
</div><!-- end .container -->
</body>
</html>