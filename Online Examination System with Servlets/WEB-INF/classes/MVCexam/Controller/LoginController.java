package MVCexam.Controller;

import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter pw = response.getWriter();
        LoginModel lom = new LoginModel();
        response.setContentType("text/html");

        try {

            String pwd = lom.getData(username);
            if (pwd.equals(password)) {
                if (username.equals("admin")) {
                    System.out.println("Admin logged in");
                    response.sendRedirect("admin?username=" + username);
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    System.out.println("\nLogin Successful!");
                    pw.print("<form action='questions' method='get'>");
                    pw.print("<input type='hidden' name='username' value=" + username + ">");
                    pw.print("<input type='submit' value='Take Test'>");
                    pw.print("</form>");
                }

            } else {
                System.out.println("\nIncorrect username or password");
                pw.println("<h1>Incorrect username or password</h1><br><br>");
                pw.println("<h2>Please type the correct username or password</h2><br><br>");
                pw.println("<button onclick=\"location.href = 'Login.html';\">Try again</button>");
            }

        } catch (Exception e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}