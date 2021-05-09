package MVCexam.Controller;

import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class QuestionController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pnt = response.getWriter();
        QuestionModel qum = new QuestionModel();
        response.setContentType("text/html");
        String username = request.getParameter("username");
        System.out.println(username);

        try {

            ResultSet rs = qum.getData(5);
            Integer i = 1, j = 1;
            pnt.println("<form action=\"answers\" method=\"post\">");
            do {
                String question = rs.getString("question");

                ArrayList<String> options = new ArrayList<String>();
                options.add(rs.getString("option1"));
                options.add(rs.getString("option2"));
                options.add(rs.getString("option3"));
                options.add(rs.getString("option4"));
                Collections.shuffle(options);
                String answer = rs.getString("answer");

                pnt.println("<p>" + i + ". " + question + "<p>");

                for (String op : options) {
                    pnt.println("<input type=\"radio\" id=\"" + i + "op" + j + "\" name=\"" + i + "\" value=\"" + op
                            + "\">");
                    pnt.println("<label for=\"" + i + "op" + j + "\">" + op + "</label></br>");
                    j++;
                }

                pnt.println("<input type=\"hidden\" id=\"" + i + "a\" name=\"" + i + "a\" value=\"" + answer + "\">");
                i++;
            } while (rs.next());
            pnt.print("<input type='hidden' name='username' value=" + username + ">");
            pnt.println("<input type=\"submit\">");
            pnt.println("</form>");

        } catch (Exception e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}