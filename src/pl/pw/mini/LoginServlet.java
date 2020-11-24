package pl.pw.mini;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getServletContext().getAttribute("Data base") == null) {
			SimpleDB db = new SimpleDB();
			System.out.println(db);
			request.getServletContext().setAttribute("Data base", db);
		}
		String username = request.getParameter("username");
		String password = request.getParameter("username");
		if(username == null && password == null){
			RequestDispatcher rd = request.getRequestDispatcher("logger.jsp");
			rd.forward(request, response);
		}else if(username != null && password != null){
			System.out.println("tekst");
		}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
