package MVCexam.Controller;

import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class VoteController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		VoteModel vm = new VoteModel();
		String username = request.getParameter("username");
		pw.println("<style>");
		pw.println("body {font-family: verdana;}");
		pw.println("</style>");

		try {

			pw.println("<h1><center>Online Voting</center></h1>");
			pw.println("<form action=\"vote\" method=\"post\">");

			pw.println("<input type=\"radio\" id=\"C1\" name=\"candidate\" value=\"C1\">");
			pw.println("<label for=\"C1\">C1</label></br>");

			pw.println("<input type=\"radio\" id=\"C2\" name=\"candidate\" value=\"C2\">");
			pw.println("<label for=\"C2\">C2</label></br>");

			pw.println("<input type=\"radio\" id=\"C3\" name=\"candidate\" value=\"C3\">");
			pw.println("<label for=\"C3\">C3</label></br>");

			pw.println("<input type=\"hidden\" id=\"username\" name=\"username\" value=\"" + username + "\">");
			pw.println("<input type=\"submit\">");
			pw.println("</form>");

		} catch (Exception e) {
			System.out.println("Exception thrown : " + e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String username = request.getParameter("username");
		String candidate = request.getParameter("candidate");

		pw.println("<style>");
		pw.println("body {font-family: verdana;}");
		pw.println("</style>");

		try {

			VoteModel vm = new VoteModel();
			vm.updateVote(candidate, username);
			pw.println("<p><b>Voted succesfully!</b><p>");

		} catch (Exception e) {
			System.out.println("Exception thrown : " + e);
		}
	}
}
