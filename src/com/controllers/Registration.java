package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConnectionMake;
import com.models.RegistrationModel;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		String firstname=request.getParameter("firstname");//"(name of text field will come done in jsp page)"
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		
		
		RegistrationModel obj=new RegistrationModel();
		obj.setFirstname(firstname);
		obj.setLastname(lastname);
		obj.setEmail(email);
		obj.setPhone(phone);
		obj.setPassword(password);
		obj.setSex(sex);
		
		String sql="insert into REGISTRATION(firstname,lastname,email,phone,password,sex)values(?,?,?,?,?,?)";
		String msg=ConnectionMake.insertValues(sql, obj);
		if(msg.equals("success"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("UNAME",email);
			response.sendRedirect("ask.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}

}
