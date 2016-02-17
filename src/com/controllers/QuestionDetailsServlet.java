package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConnectionMake;
import com.misc.DateTimeStamp;
import com.models.Ask;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
 
/**
 * Servlet implementation class QuestionDetailsServlet
 */
public class QuestionDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question=request.getParameter("question");
		String details=request.getParameter("details");
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("UNAME");
		DateTimeStamp dts=new DateTimeStamp();
		String datetime=dts.dateTime();
	// coun=Integer.toString(count);
		Ask obj=new Ask();
		obj.setQuestion(question);
		obj.setDetails(details);
		obj.setEmail(email);
		obj.setDatetime(datetime);
		String sql="insert into QUESTIONDETAILs(email,question,details,datetime)values(?,?,?,?)";
		String sql2="create TABLESPACE default1";
		String msg2=ConnectionMake.makeTableSpace(sql2);
		System.out.println("created");
		//String sql1="create table E"+coun+"(Answer varchar(3000)) in default1";
		String msg=ConnectionMake.askQuestion(sql, obj);
		String sql1="select * from questiondetails where email=? and question=?";
		String count=ConnectionMake.fetchCount(sql1,obj);
		String msg1=ConnectionMake.makeTable(count);
		if(msg.equals("success"))
		{
			response.sendRedirect("ask.jsp?msg=Successfull!!!");
		}
		else
		{
			response.sendRedirect("ask.jsp?msg=Not Succeessfull!!!");
		}
		

	}

}
