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
 * Servlet implementation class UserValidationServlet
 */
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidationServlet() {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		RegistrationModel obj=new RegistrationModel();
		obj.setEmail(email);
		obj.setPassword(password);
		String sql="select * from REGISTRATION where EMAIL=? AND PASSWORD=?";
		String msg=ConnectionMake.userValidation(sql, obj);
		if(msg.equals("success"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("UNAME",email);
			response.sendRedirect("ask.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp?msg=Invalid email or password");
		}
	}

}
