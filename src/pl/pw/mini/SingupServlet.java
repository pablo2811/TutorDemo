package pl.pw.mini;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.pw.mini.PupilUser.Gender;

/**
 * Servlet implementation class SingupServlet
 */
@WebServlet("/SingupServlet")
public class SingupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingupServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age"); 
		String[] all_params = {username,password,password2,gender,age};
		SimpleDB db = (SimpleDB) request.getServletContext().getAttribute("Data base");
		boolean bad = false;
		for(String s:all_params) {
			if(s == null) {
				bad = true;
				break;
			}
		}
		if(!bad){
			int good_age = Integer.parseInt(age);
			Gender g = Gender.valueOf(gender);
			if(password.equals(password2) && !db.userExists(username) && good_age < 100) {
				db.addUser(username, password, g, good_age);
			}else {
				bad = true;
			}
		}
		if(bad) {
			PrintWriter pw = response.getWriter();
			pw.println("Something went terribly wrong.");
		}
		
		
		
	}

}
