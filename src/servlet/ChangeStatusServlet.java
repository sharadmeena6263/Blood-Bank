package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class ChangeStatusServlet
 */
@WebServlet("/change.do")
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String status=request.getParameter("status");
		String phoneNo=(String) session.getAttribute("phone"); 
		System.out.println(phoneNo);
		System.out.println(status);
		System.out.println(session.getId());
		Connection con= JdbcUtil.getMySqlConnection();
		String sql="update register_users set availability=? where phoneNo=?";
		int count=0;
		PreparedStatement ps=null;
		
		try {
			 ps= con.prepareStatement(sql);
			ps.setString(1,status);
			ps.setString(2,phoneNo);
		    count = ps.executeUpdate();
		    if(count>0) {
		    	session.setAttribute("status", status);
		    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/success.jsp");
		    	rd.forward(request, response);
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.cleanResources(ps, con);	
		}
}
}
