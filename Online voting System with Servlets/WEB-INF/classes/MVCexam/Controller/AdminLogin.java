package MVCexam.Controller;

import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class AdminLogin extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse res) {

        String name = request.getParameter("username");

        System.out.println(name);

        try {
            AdminModel mm = new AdminModel();
            ResultSet rs = mm.getVotes();
            PrintWriter pw = res.getWriter();

            String[] candidate = new String[5];
            Integer[] votes = new Integer[5];

            pw.println("<html>");
            pw.println("<head><title>Result</title>");
            pw.println("<style>");
            pw.println("table, th, td, tr {padding: 10px; border: 1px solid black; border-collapse: collapse;}");
            pw.println("body {font-family: verdana;}");
            pw.println("</style>");
            pw.println("</head>");

            pw.println("<body>");
            pw.println("<p>Number of People Voting at Present is : " + SessionCounter.getSessionCount() + "</p>");

            pw.println("<table style=\"border: 1px solid black; border-collapse: collapse;\">");
            pw.println("<tr>");
            pw.println("<th>Subject</th>");
            pw.println("<th>Mark</th>");
            pw.println("</tr>");

            do {
                pw.println("<tr>");
                pw.println("<td>" + rs.getString("name") + "</td>");
                pw.println("<td>" + rs.getString("count") + "</td>");

                pw.println("</tr>");
            } while (rs.next());
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}