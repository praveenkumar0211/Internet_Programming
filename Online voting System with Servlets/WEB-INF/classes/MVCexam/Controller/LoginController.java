package MVCexam.Controller;

import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		LoginModel lm = new LoginModel();
		pw.println("<style>");
		pw.println("body {font-family: verdana;}");
		pw.println("</style>");

		try {

			String result = lm.getPassword(username, password);
			if (result.equals("admin")) {

				System.out.println("Admin logged in");
				res.sendRedirect("admin?username=" + username);
			} else if (result.equals("Already voted")) {
				pw.println("<h3>Already Voted</h3>");
			} else if (result.equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				System.out.println("\nLogin Successful!");
				res.sendRedirect("vote?username=" + username);
			} else {
				pw.println("<h3>Invalid Login</h3>");
			}

		} catch (

		Exception e) {
			System.out.println("Exception thrown : " + e);
		}
	}
}
