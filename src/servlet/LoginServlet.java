package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbcUtil.JdbcUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		PrintWriter out = response.getWriter();

			Connection con = JdbcUtil.getMySqlConnection();
			String sql="select * from register_users where email=? and password=? or phoneNo=? and password=?";
			PreparedStatement ps =null;
			ResultSet rs =null;
			try {
			    ps = con.prepareStatement(sql);
				ps.setString(1,username);
				ps.setString(2, password);
				ps.setString(3, username);
				ps.setString(4, password);
			    rs = ps.executeQuery();
			    if(rs.next() && password.equals(rs.getString("password"))) {
			    	HttpSession session = request.getSession();
			        session.setAttribute("name",rs.getString("name"));
			        session.setAttribute("email",rs.getString("email"));
			        session.setAttribute("blood",rs.getString("bloodGroup"));
			        session.setAttribute("gender",rs.getString("gender"));
			        session.setAttribute("state",rs.getString("State"));
			        session.setAttribute("phone",rs.getString("phoneNo"));
			        session.setAttribute("city",rs.getString("city"));
			        session.setAttribute("status",rs.getString("availability"));
			    	//out.println("welcome "+rs.getString(1));
			       System.out.println(session.getId());
			    	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/success.jsp");
			    	rd.forward(request, response);
			    }else {
			    	response.setContentType("text/html");
			    	out.println("<center><h2 style='color:red'>invalid username or password</h2></ceenter>");
			    	RequestDispatcher rd = request.getRequestDispatcher("login.html");
			    	rd.include(request, response);
			    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("something went wrong while fetching data");
			}finally {
				JdbcUtil.cleanResources(ps, con, rs);
			}
			
		}
			
	}
