package MVCexam.Controller;

import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class AnswerController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pnt = response.getWriter();
        try {
            QuestionModel qum = new QuestionModel();
            ResultSet rs = qum.getData(5);
            Integer score = 0;
            String username = request.getParameter("username");
            String[] choice = new String[5];
            String[] answer = new String[5];
            System.out.println(username);

            for (int i = 1; i <= 5; i++) {

                choice[i - 1] = request.getParameter("" + i + "");
                answer[i - 1] = request.getParameter("" + i + "a");
            }

            pnt.println("<p><b>Results: </b></p>");

            for (int i = 1; i <= 5; i++) {
                String question = rs.getString("question");
                pnt.println("<p>" + i + ". " + question + "<p>");// remove i later
                rs.next();

                pnt.println("<p>" + i + ". " + choice[i - 1] + "<br>");
                if (answer[i - 1].equals(choice[i - 1])) {
                    pnt.println("<b>Correct answer!</b></p>");
                    score += 2;
                } else
                    pnt.println("<b>Incorrect answer</b><br>Correct answer: " + answer[i - 1] + "</p>");
            }
            pnt.println("<p><b>Score: " + score + "/10</b></p>");
            pnt.print("<form action='getreport' method='post'>");
            pnt.print("<input type='hidden' name='username' value=" + username + ">");
            pnt.print("<input type='hidden' name='score' value=" + score + ">");
            pnt.print("</br><center><input type='submit' value='Mark Sheet'></center>");
            pnt.print("</form>");

        } catch (Exception e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}