package MVCexam.Controller;

import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ReportController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse res) {

        String name = request.getParameter("username");
        String score = request.getParameter("score");
        System.out.println(name);
        MarksheetModel m = new MarksheetModel();
        try {
            Map<String, String> marks = m.getData(name, score);
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.print(
                    "<head><style>table, th, td {border: 1px solid black;border-collapse: collapse;margin-left: 40rem;}th, td {padding: 5px;text-align: left;}h3 {margin-left:40rem;} button{margin-left:50rem;}</style></head>");

            out.print("<center><h1>Exam Results<h1></center>");
            out.print("<h3>Name: " + name + "</h3>");
            out.print("<table style:'width:80%'>");
            out.print("<tr><th>Subject</th><th>Marks</th></tr>");
            for (String key : marks.keySet()) {
                out.print("<tr><td>" + key + "</td><td>" + marks.get(key) + "</td></tr>");
            }
            out.print("</table>");
            out.print("<form action='Login.html'>");
            out.print("</br><input type='submit' value='Return Home'>");
            out.print("</form>");
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}