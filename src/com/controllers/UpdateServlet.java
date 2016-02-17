package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionMake;
import com.models.UpdateModel;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pwd");
		UpdateModel obj=new UpdateModel();
		obj.setFname(fname);
		obj.setLname(lname);
		obj.setEmail(email);
		obj.setPhone(phone);
		obj.setPwd(pwd);
		String sql="update REGISTRATION SET(firstname,lastname,email,phone,password)=(?,?,?,?,?) where email=?";
		String msg=ConnectionMake.updateValues(sql, obj);
		if(msg.equals("success"))
		{
			response.sendRedirect("updateinfo.jsp?msg=Update done!!");
		}
		else
		{
			response.sendRedirect("updateinfo.jsp?msg=Update failed!!");
		}
	}

}
