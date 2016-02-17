<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Q&amp;A</title>
<style type="text/css">
.main1 #form1 em {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 100px;
	font-style: oblique;
	font-weight: 900;
	text-decoration: line-through;
	color: #FF0000;
	vertical-align: baseline;
}
.main1 .style1 {
	font-family: "Courier New", Courier, monospace;
	font-size: 24px;
	font-style: oblique;
	text-decoration: underline overline;
	font-weight: bolder;
	color: #0000FF;
}
.style1 {color: #FF0000}
</style>
</head>

<body>
<div class="main1">
<%
       if(request.getParameter("msg")!=null) 
       {
    	  String msg=request.getParameter("msg");
  	   out.println("<center><h2><font color='red'>"+msg+"</font></h2></center>");
      }
   %>
   
   
  <form id="form1" name="form1" method="post" action="UserValidationServlet">
    <p>&nbsp; </p>
    <table width="500" height="10" border="2" align="right" cellpadding="4" cellspacing="0" bordercolor="#000000">
      <tr>
        <th width="225" height="72" scope="col"><label>
          <div align="left" class="style4">Email
            <input name="email" type="text" placeholder="Email" id="email" maxlength="30" />
          </div>
        </label></th>
        <th width="221" height="72"scope="col"><label>
          <div align="left">
          
          Password
          <input name="password" type="password" placeholder="Password" id="password" maxlength="20" />
          </label>
        </div></th>
        <th width="68" height="72" scope="col"><label> <br />
            <input name="login" type="submit" class="style4" value="Submit" />
            
        </label></th>
      </tr>
    </table>
    <p align="center" class="style1"><em>Q&A</em></p>
  </form>

  <p align="center">&nbsp;</p>
  <p align="center" class="style1"> Create an account  </p>
  <form id="form2" name="form2" method="post" action="Registration">
    <table width="458" height="406" border="6" align="center" cellpadding="4" cellspacing="0">
      <tr>
        <th width="149" scope="row"><div align="left">Firstname:
        </div></th>
        <td width="285"><label>
          <input name="firstname" type="text" placeholder="First name" id="firstname" maxlength="30" />
        </label></td>
      </tr>
      <tr>
        <th scope="row"><div align="left">Lastname:
        </div></th>
        <td><label>
          <input name="lastname" type="text" placeholder="Last name" id="lastname" maxlength="30" />
        </label></td>
      </tr>
      <tr>
        <th scope="row"><div align="left">Email:</div></th>
        <td><label>
          <input name="email" type="text" placeholder="Email" id="email" maxlength="30" />
        </label></td>
      </tr>
      <tr>
        <th scope="row"><div align="left">Phone:</div></th>
        <td><label>
          <input name="phone" type="text" placeholder="Phone" id="phone" maxlength="15" />
        </label></td>
      </tr>
      <tr>
        <th scope="row"><div align="left">New Password:</div></th>
        <td><label>
          <input name="password" type="password" placeholder="New Password" id="password" maxlength="20" />
        </label></td>
      </tr>
      <tr>
        <th height="65" scope="row"><div align="left">Sex:</div></th>
        <td><p>
          <label>
            <input type="radio" name="sex" value="Male" />
            Male</label>
          <br />
          <label>
            <input type="radio" name="sex" value="Female" />
            Female</label>
          <br />
        </p></td>
      </tr>
      <tr>
        <th height="29" scope="row"><div align="left">
          <label>
          <input name="reset" type="reset" id="reset" value="Reset" />
          </label>
        </div></th>
        <td><label>
          <input name="submit" type="submit" id="submit" value="Submit" />
        </label></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>