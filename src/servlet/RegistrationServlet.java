package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcUtil.JdbcUtil;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register.do")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String bloodGroup=request.getParameter("blood");
		String phoneNo=request.getParameter("phoneNo");
		String password=request.getParameter("password");
		String state=request.getParameter("state");
		String gender=request.getParameter("gender");
		String city= request.getParameter("city");
		String availability=request.getParameter("availability");
		

		 Connection con= JdbcUtil.getMySqlConnection();
			String sql="insert into register_users values(?,?,?,?,?,?,?,?,?)";
			int count=0;
			PreparedStatement ps=null;
			
			try {
				 ps= con.prepareStatement(sql);
				ps.setString(1,name);
				ps.setString(2,email);
				ps.setString(3,phoneNo);
				ps.setString(4,gender);
				ps.setString(5,bloodGroup);
				ps.setString(6,state);
				ps.setString(7,password);
				ps.setString(8,city);
				ps.setString(9,availability);
				
				 count = ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.cleanResources(ps, con);
			}
			if(count>0) {
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");
			rd.forward(request, response);
				System.out.println("Registration successfull");
				System.out.println(count);
			}
			else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<center><h3 style='color:red'>User has already registerd from this Phone no.</h3></center><br>");
				RequestDispatcher rd = request.getRequestDispatcher("/registration.html");
				rd.include(request, response);
				System.out.println("Registration unsuccessfull");
			}
		
	}

}
