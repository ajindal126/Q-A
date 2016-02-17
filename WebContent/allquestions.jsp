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
<div>
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





<div id="navbar">
<div id="holder">
<ul>
<li><a href="ask.jsp">Ask</a></li>
<li><a href="allquestions.jsp"  id="onlink">All Questions</a></li>
<li><a href="myquestions.jsp">My Questions</a></li>
<li><a href="updateinfo.jsp">Update Info</a></li>
<li><a href="logout.jsp">Logout</a></li>
</ul>
</div>
</div>
 <p>&nbsp;</p>
  <p>&nbsp;</p>
   <p>&nbsp;</p>
  <p>&nbsp;</p>
<%
String sql="select * from questiondetails";
ResultSet rs=ConnectionMake.FetchQuestionDetails(sql);


out.println("<form method='post' action='AllQuestions'>");
out.println("<table align='left' border='4' cellpadding='4' >");
while(rs.previous())
{
	out.println("<tr><td><a href='' >"+rs.getString(2)+"</a></td><td><input type='text' name='date' value='"+rs.getString(4)+"'/></td><td><input type='hidden' name='count' value='"+rs.getString(5)+"'/></td><td><input type='submit'  value='submit'/></td></tr>"); 
}
out.println("</table>");
out.println("</form>");
%>
</div>
</body>
</html>