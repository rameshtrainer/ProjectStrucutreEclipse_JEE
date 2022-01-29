package ServletsFiles;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import DatabaseFiles.AdminValidation;

/**
 * Servlet implementation class SAdminLog
 */
@WebServlet("/SAdminLog")
public class SAdminLog extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SAdminLog() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>AdminHome</title>");
		out.println("</head>");
		out.println("<body>");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Entered Username is: " +username + "Password is: " +password);
		
		if(AdminValidation.Validate(username, password)) {
			    out.println("Welcome: "+username);
	            HttpSession session=request.getSession(true);
	            session.setAttribute("username",username);
	            out.println("Login Successfully done");
	            
		}else {

			 out.println("Invalid Details");
		}
		
		out.close();
		out.println("</body>");
		out.println("</html>");
	}

}

