<%--
  Created by IntelliJ IDEA.
  User: deepanshu
  Date: 12/28/15
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home page</title>
        <link rel="stylesheet" type="text/css" href="css/stylehome.css" />
    </head>
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
            <form action="statusupdate.jsp" method="post">
                <input type="Text" placeholder="Enter your message" name="msg" /><br />
                Upload Image<input type="file" name="pic" /><br />
                <input type="submit" name="submit1" value="Post" />
            </form>
            <jsp:useBean id="dcon" class="buddies.DConnection"></jsp:useBean>
            <%
                try
                {
                    ResultSet rst=dcon.getData("select * from post");
                    while(rst.next())
                    {
            %>
            <div id="<%=rst.getString(1)%>">

            </div>
            <%
                    }
                }
                catch(SQLException e)
                {
                    out.print(e);
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