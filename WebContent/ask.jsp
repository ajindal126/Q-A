<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ASK</title>
<style type="text/css">
<!--
.main1 td {
	font-family: Georgia, "Times New Roman", Times, serif;
}
.main1 td {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
}
.main1 #p01 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 36px;
	font-weight: bolder;
}
.main1 #p02 {
	font-family: "Times New Roman", Times, serif;
	font-size: 18px;
	font-weight: bold;
}
.main1 #form1 #question {
	width: 650px;
	height: 30px;
	padding-top: 5px;
	margin-top: 2px;
	border-top-style: double;
	border-right-style: double;
	border-bottom-style: double;
	border-left-style: double;
	border-top-width: medium;
	border-right-width: medium;
	border-bottom-width: medium;
	border-left-width: medium;
}
.main1 #form1 div {
	width: 0px;
}
.main1 #form1 #details {
	width: 1100px;
	height: 120px;
	border-top-style: double;
	border-right-style: double;
	border-bottom-style: double;
	border-left-style: double;
	border-top-width: medium;
	border-right-width: medium;
	border-bottom-width: medium;
	border-left-width: medium;
}
.main1 #form1 #submit {
	width: 120px;
	height: 35px;
	padding-top: 2px;
}
-->
</style>
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
<li><a href="ask.jsp" id="onlink">Ask</a></li>
<li><a href="allquestions.jsp">All Questions</a></li>
<li><a href="myquestions.jsp">My Questions</a></li>
<li><a href="updateinfo.jsp">Update Info</a></li>
<li><a href="logout.jsp">Logout</a></li>
</ul>
</div>
</div>


<div class="main1">
  <table width="636" height="222" align="left" cellpadding="4" cellspacing="0">
     <tr>
    <th width="288" rowspan="2"><img src="creative-thinking.jpg" width="250" height="216" /></th>
    <td width="249" height="52" id="p01">Welcome</td>
  </tr>
  <tr>
    <td height="43" id="p02"> Problem shared is a Problem Solved!</td>
  </tr>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <form id="form1" name="form1" method="post" action="QuestionDetailsServlet">
    <table width="1125" height="217" border="4" cellpadding="4" cellspacing="0">
      <tr>
        <th height="69" scope="row"><div align="left">
          <input name="question" type="text" id="question" placeholder="Ask your question here!(Max 100 words)!!!" value="" size="200" />
        </div>          <label></label></th>
      </tr>
      <tr>
        <th scope="row"><label>
          <div align="left">
            <textarea name="details" cols="100" id="details"  placeholder="Provide question details here!(Max 700 words)!!!" size="1000"></textarea>
          </div>
        </label></th>
      </tr>
      <tr>
        <th scope="row"><label>
          
          <div align="right">
            <input name="submit" type="submit" id="submit" value="Ask!" />
            </label>
          </div></th>
      </tr>
    </table>
  </form>
  </div>
</body>
</html>
