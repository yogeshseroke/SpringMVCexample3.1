package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Insertpojo;

/**
 * Servlet implementation class InsertSer
 */
@WebServlet("/InsertSer")
public class InsertSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("view.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Insertpojo obj=new Insertpojo();
		obj.setId(Integer.parseInt(request.getParameter("txtid")));
		obj.setName(request.getParameter("txtname"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcexample","root","");
	        Statement st=con.createStatement();
	        
			int x=st.executeUpdate("insert into student(id,name) values('"+obj.getId()+"','"+obj.getName()+"')");
			if(x!=0)
			{
				response.sendRedirect("view.jsp?q="+"inserted successfully");
			}
			else
			{
				response.sendRedirect("view.jsp?q="+"unsuccessfull");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
