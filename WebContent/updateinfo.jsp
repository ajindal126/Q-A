<%@ page import="com.dao.*" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Q&amp;A</title>

<link href="tabmenu.css" rel="stylesheet" type="text/css" />
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
       if(request.getParameter("msg")!=null) 
       {
    	  String msg=request.getParameter("msg");
  	   out.println("<center><h2><font color='red'>"+msg+"</font></h2></center>");
      }
   %>
   <div id="navbar">
<div id="holder">
<ul>
<li><a href="ask.jsp">Ask</a></li>
<li><a href="allquestions.jsp" >All Questions</a></li>
<li><a href="myquestions.jsp" >My Questions</a></li>
<li><a href="updateinfo.jsp"  id="onlink">Update Info</a></li>
<li><a href="logout.jsp">Logout</a></li>
</ul>
</div>
</div>

<%
String email=(String)session.getAttribute("UNAME");
String sql="select * from registration where email=?";
ResultSet rs=ConnectionMake.FetchUserDataByName(sql,email);


out.println("<form method='post' action='UpdateServlet'>");
out.println("<table width='458' height='406' border='6' align='center' cellpadding='4' cellspacing='0'>");
while(rs.next())
{
	out.println("<tr><td>FIRST NAME</td><td><input type='text' name='fname' value='"+rs.getString(1)+"'/></td></tr>");
	out.println("<tr><td>LAST NAME</td><td><input type='text' name='lname' value='"+rs.getString(2)+"'/></td></tr>");
	out.println("<tr><td>EMAIL</td><td><input type='text' name='email' value='"+rs.getString(3)+"' readonly='readonly'/></td></tr>");
	out.println("<tr><td>PHONE</td><td><input type='text' name='phone' value='"+rs.getString(4)+"'/></td></tr>");
	out.println("<tr><td>PASSWORD</td><td><input type='text' name='pwd' value='"+rs.getString(5)+"'/></td></tr>");
	
	
}
out.println("<tr><td><input type='submit' value='Update'></td><td></td></tr>");
out.println("</table>");
out.println("</form>");
%>
</body>
</html>