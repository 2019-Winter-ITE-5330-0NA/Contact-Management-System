package controller;
import model.M_11_Friends;
import util.FormValidator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.InsertQuery;


/**
 * Servlet implementation class C_11_insert
 */
@WebServlet("/C_11_insert")
public class C_11_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_11_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String friendName= request.getParameter("Name");
		String emailAddress= request.getParameter("Email");
		String favouriteColor= request.getParameter("favColor");
		int age= Integer.parseInt(request.getParameter("Age"));
		M_11_Friends friend = new M_11_Friends(0,friendName,emailAddress,age,favouriteColor);
		FormValidator validator= new FormValidator();
		boolean statusAge=false;
		boolean statusEmail=false;
		boolean statusName=false;
		if(validator.validateAge(friend)) 
		{
			statusAge=true;
		}
		else
		{
			response.getWriter().append("Age Cannot Be 0");
		}
		
		if(validator.validateEmail(friend)) 
		{
			statusEmail=true;
		}
		else
		{
			response.getWriter().println("Email Format Is Wrong");
		}
		
		if(validator.validateName(friend)) 
		{
			statusName=true;
		}
		else
		{
			response.getWriter().append("Name Cannot Contain Any Numbers");
		}
		
		if(statusAge==true && statusEmail==true && statusName==true) 
		{
			try {
				
				InsertQuery rq= new InsertQuery();
				rq.doInsert(friend);			
				response.sendRedirect("C_11_read");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
