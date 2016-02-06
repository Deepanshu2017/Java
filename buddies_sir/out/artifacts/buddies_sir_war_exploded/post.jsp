<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.io.output.DeferredFileOutputStream"%>
<%
    {
        int postid=0;
        DConnection dcon=new DConnection();
        ResultSet rst=dcon.getData("select max(postid) from post");
        try
        {
            rst.next();
            postid=rst.getInt(1)+1;
            rst.close();
            dcon.close();
        }
        catch(SQLException e)
        {
            out.print(e);
        }
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart)
        {

            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            try
            {
                items = upload.parseRequest(request);
            }
            catch (FileUploadException e)
            {
                e.printStackTrace();
            }
            Iterator itr = items.iterator();
            String msg="",pic="";
            while (itr.hasNext())
            {
                FileItem item = (FileItem) itr.next();
                if (!item.isFormField())
                {
                    try
                    {
                        File savedFile=null;
                        if(item.getFieldName().equals("pic"))
                        {
                            pic=item.getName();
                            pic=postid+itemName.substring(itemName.lastIndexOf("."));

                            savedFile = new File(config.getServletContext().getRealPath("/")+"userimages/"+itemName);
                        }
                        item.write(savedFile);

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    String fieldname = item.getFieldName();
                    String fieldvalue = item.getString();
                    if(fieldname.equals("msg"))
                        msg=fieldvalue;
                }
            }
        }
    }
%>
