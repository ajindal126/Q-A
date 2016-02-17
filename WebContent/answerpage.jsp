<%@ page import="com.dao.*" %>
<%@ page import="java.sql.*" %>
<%@page import="com.models.UpdateModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Q&A</title>
</head>

<body>
<%
  if(session.getAttribute("UNAME")!=null)
  {
	  String username=(String)session.getAttribute("UNAME");
	  out.println("<p align='right'>WELCOME USER <font color='green'>"+username);
	  
  }
  else
  {
	  response.sendRedirect("login.jsp");
  }
  
  %>
  <%
 if(session.getAttribute("COUNT")!=null)
  {
	  String count1=(String)session.getAttribute("COUNT");
  }
  %>
       <%
       int coun=0;
       if(session.getAttribute("COUNT")!=null)
       {
     	   String c=(String)session.getAttribute("COUNT");
     	   coun=Integer.parseInt(c);
       }
      // String sql="select * from questiondetails where count="+coun;
       UpdateModel obj=new UpdateModel();
       //obj.setCount(count);
       ResultSet rs=ConnectionMake.FetchDetails(coun);
out.println("<form method='post' action='Answers'>");
out.println("<table align='left' border='4' width='1034' cellpadding='4' >");
while(rs.next())
{
out.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(5)+"</td></tr>"); 
}
out.println("<tr><textarea name='answer' cols='1000'   placeholder='Provide answer here!(Max 4000 words)!!!'></textarea></tr>");
out.println("<tr><input type='submit' value='Answer'></tr>");
out.println("</table>");
out.println("</form>");
%>

  <p>&nbsp;</p>
  <p>&nbsp;</p>
   <p>&nbsp;</p>
  <p>&nbsp;</p>
   <p>&nbsp;</p>
  <p>&nbsp;</p>
   <p>&nbsp;</p>
  <p>&nbsp;</p>
  <%
 
  if(session.getAttribute("COUNT")!=null)
  {
	  String c=(String)session.getAttribute("COUNT");
	   coun=Integer.parseInt(c);
  }
ResultSet rs1=ConnectionMake.FetchAnswers(coun);



out.println("<table align='left' border='4' cellpadding='4' cellspacing='2'>");
while(rs1.next())
{
	out.println("<tr>"+rs1.getString(1)+"</tr>"+"\n"); 
	
}
out.println("</table>");
out.println("</form>");
%>
  
</body>
</html>
