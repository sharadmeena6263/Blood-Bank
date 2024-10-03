package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbcUtil.JdbcUtil;

/**
 * Servlet implementation class ShowUserServlet
 */
@WebServlet("/show.do")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String blood=request.getParameter("blood");
		 String state=request.getParameter("state");
		 String city=request.getParameter("city");
		Connection con = JdbcUtil.getMySqlConnection();
		String sql=null;
		
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			
			if(city.equalsIgnoreCase("All")) {
				
			if(blood.equals("All") && state.equals("All")){
				 sql="select name,email,phoneNo,bloodgroup,State,gender,city from register_users where availability='available'";
					
				    ps = con.prepareStatement(sql);
			}
		   else if(blood.equals("All") && state.equals(state)) {
				   sql="select name,email,phoneNo,bloodgroup,State,gender,city from register_users where state=? and availability='available'";
				
		    ps = con.prepareStatement(sql);
	
			ps.setString(1, state);
		   // rs = ps.executeQuery();
		     }
			else if(blood.equals(blood) && state.equals("All")) {
			      sql="select name,email,phoneNo,bloodgroup,State,gender,city from register_users where bloodgroup=? and availability='available'";				
		   
			ps = con.prepareStatement(sql);
		    ps.setString(1,blood);
		     }
			else {
		          sql="select name,email,phoneNo,bloodgroup,State,gender,city from register_users where state=? and bloodgroup=? and availability='available'";	
		    ps = con.prepareStatement(sql);
		    ps.setString(1,state);
		    ps.setString(2,blood);
		     }
			}
			else {
				if(blood.equals("All") && state.equals("All")){
					 sql="select name,email,phoneNo,bloodgroup,State,gender,city from register_users where city=? and availability='available'";
						
					    ps = con.prepareStatement(sql);
					    ps.setString(1,city);
				}
			   else if(blood.equals("All") && state.equals(state)) {
					   sql="select name,email,phoneNo,bloodgroup,State,gender,city from register_users where state=? and city=? and availability='available'";
					
			    ps = con.prepareStatement(sql);
		
				ps.setString(1, state);
				ps.setString(2,city);
			     }
				else if(blood.equals(blood) && state.equals("All")) {
				      sql="select name,email,phoneNo,bloodgroup,State,gender,city from register_users where bloodgroup=? and city=? and availability='available'";				
			   
				ps = con.prepareStatement(sql);
			    ps.setString(1,blood);
			    ps.setString(2,city);
			     }
				else {
			          sql="select name,email,phoneNo,bloodgroup,State,gender,city from register_users where state=? and bloodgroup=? and city=? and availability='available'";	
			    ps = con.prepareStatement(sql);
			    ps.setString(1,state);
			    ps.setString(2,blood);
			    ps.setString(3,city);
			     }
				}
			
			 rs = ps.executeQuery();
			 
			 out.println("<html>");
			 out.println("<head>");
			 out.println("<meta charset=\"UTF-8\">");
			 out.println("<title>User Profile</title>");
			 out.println("<style>");
			 out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0;}");
			 out.println("table { width: 100%; border-collapse: collapse;}");
			 out.println("th, td { border: 1px solid #dddddd; padding: 8px; text-align: left;}");
			 out.println("th { background-color: #f2f2f2;}");
			 out.println("</style>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<table>");
			 out.println("<tr>");
			 out.println("<th>Name</th>");
			 out.println("<th>Email Id</th>");
			 out.println("<th>Blood Group</th>");
			 out.println("<th>Gender</th>");
			 out.println("<th>State</th>");
			 out.println("<th>Contact No</th>");
			 out.println("<th>City</th>");
			 out.println("</tr>");
			 while (rs.next()) {
			     out.println("<tr>");
			     out.println("<td>" + rs.getString("name") + "</td>");
			     out.println("<td>" + rs.getString("email") + "</td>");
			     out.println("<td>" + rs.getString("bloodGroup") + "</td>");
			     out.println("<td>" + rs.getString("gender") + "</td>");
			     out.println("<td>" + rs.getString("State") + "</td>");
			     out.println("<td>" + rs.getLong("phoneNo") + "</td>");
			     out.println("<td>" + rs.getString("city") + "</td>");
			     out.println("</tr>");
			 }
			 out.println("</table>");
			 out.println("</body>");
			 out.println("</html>");

		   System.out.println("Data fatched successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("something went wrong while fetching data");
		}finally {
			JdbcUtil.cleanResources(ps, con, rs);
		}
		
	}
	}


