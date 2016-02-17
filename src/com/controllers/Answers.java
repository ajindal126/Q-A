package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConnectionMake;

/**
 * Servlet implementation class Answers
 */
public class Answers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answers() {
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
		String answer=request.getParameter("answer");
		HttpSession session=request.getSession();
		String coun=(String)session.getAttribute("COUNT");
		int count=Integer.parseInt(coun);
		String msg=ConnectionMake.enterAnswer(count,answer);
		if(msg.equals("success"))
		{
			response.sendRedirect("answerpage.jsp");
		}
		else
		{
			response.sendRedirect("answerpage.jsp");
		}

	}

}
