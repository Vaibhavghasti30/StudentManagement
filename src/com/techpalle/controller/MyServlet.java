package com.techpalle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Users;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		switch(path)
		{
		default :
			getStartupPage(request, response);
			break;
			
		case "/show":
			displayPage(request, response);
			break;
		
		case "/del":
		DeletingData(request, response);
		break;
		
		case "/delete" :
			deletePage(request,response);
			break;
			
		case "/update" :
			getupdatePage(request, response);
			break;
			
		case "/insert":
			getRegistertationPage(request, response);
			break;
			
		case "/reg":
			insertusers(request, response);
			break;
			
		case "/up":
		    updateusers(request, response);
		     break;
		}	
	}


	private void displayPage(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body style=background-color:#7FFFD4; color:#000000><div align='center'>");
			out.println("<title>Displaying Users</title>");
			out.println("<h1>USERS TABLE</h1>");
			out.println("<table border = '1' cellspacin='2' style='background-color:#FFC0CB; color:#000000'><th>Name</th><th>Email</th><th>Password</th><th>State</th>");
			ArrayList<Users> u = DataAccess.reading();
			for(Users item : u)
			{
				out.println("<tr><td>"+item.getName()+"</td><td>"+item.getEmail()+"</td><td>"+item.getPassword()+"</td><td>"+item.getState()+"</td></tr>");
			}
			out.println("</table></div></body></html>");	
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void DeletingData(HttpServletRequest request, HttpServletResponse response)
	{
		String em = request.getParameter("tbemail");
		
		DataAccess.deleteData(em);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		try {
			rd.forward(request, response);
		}
		catch (ServletException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	private void deletePage(HttpServletRequest request, HttpServletResponse response)
	{
		RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
		try {
			rd.forward(request, response);
		}
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	private void getupdatePage(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void getRegistertationPage(HttpServletRequest request, HttpServletResponse response)
	{
		RequestDispatcher rd = request.getRequestDispatcher("frontpage.jsp");
		try {
			rd.forward(request, response);
		}
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void getStartupPage(HttpServletRequest request, HttpServletResponse response)
	{

		try {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}

	private void updateusers(HttpServletRequest request, HttpServletResponse response)
	{
        String name = request.getParameter("tbname");
        String email = request.getParameter("tbemail");
        String state = request.getParameter("ddlstates");
        String password = request.getParameter("tbpassword");

        Users user = new Users(name, email, password, state);
        DataAccess.updatedata(user);
        try {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} 
        catch (ServletException e)
        {
			e.printStackTrace();
		}
        catch (IOException e)
        {
			e.printStackTrace();
		}
	}

	private void insertusers(HttpServletRequest request, HttpServletResponse response) 
	{
		String n = request.getParameter("tbname");
		String e = request.getParameter("tbemail");
		String p = request.getParameter("tbpassword");
		String st = request.getParameter("ddlstates");

		Users user = new Users(n, e, p, st);
		DataAccess.insertvalue(user);	
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		try {
			rd.forward(request, response);
		}
		catch (ServletException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
