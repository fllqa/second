package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.DBUtils;
import connectionBase.BaseUtils;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() 
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String nam=request.getParameter("name");
		 String pass=request.getParameter("passworld");
		 //回传给页面
		 PrintWriter out=response.getWriter();
		 out.println("nam:"+nam+" "+"pass:"+pass);
		 System.out.println("nam:"+nam+" "+"pass:"+pass);
		 DBUtils.createConnection();
		 BaseUtils.executeUpdate("insert into usertable(username,password) values(?,?)",nam,pass);
		 
		
		
	}

}
