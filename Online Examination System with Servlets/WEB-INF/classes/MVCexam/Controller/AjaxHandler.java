package MVCexam.Controller;

import MVCexam.Model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AjaxHandler extends HttpServlet {
    public AjaxHandler() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
        String username = request.getParameter("username");
        res.setContentType("application/text");
        PrintWriter pw = res.getWriter();
        LoginModel lm = new LoginModel();

        try {
            String a = request.getParameter("username");
            String exists = lm.checkUsername(username);
            pw.write(exists);
            System.out.println(username + " " + exists);
            // System.out.println("ready state from ajaxhandler : "+ a);

        } catch (Exception e) {
            System.out.println("Exception thrown : " + e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {

        String username = request.getParameter("username");
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        LoginModel lm = new LoginModel();

        try {
            String cd = request.getParameter("cd");
            String ml = request.getParameter("ml");
            String ooad = request.getParameter("ooad");
            String fds = request.getParameter("fds");
            String a = request.getParameter("username");
            String exists = lm.checkUsername(a);

            if (exists == "exists") {
                pw.println("<html><head><script>");
                pw.println("alert(\"Invalid Username or Password. Try Again..!\");");
                pw.println("</script></head></html>");
                res.sendRedirect("Register.html");
            } else {
                lm.appendUser(request.getParameter("username"), request.getParameter("password"),
                        request.getParameter("cd"), request.getParameter("ml"), request.getParameter("ooad"),
                        request.getParameter("fds"));
                pw.println("<html><head><script>");
                pw.println("alert(\"Registration Successfull!\");");
                pw.println("</script></head></html>");
                res.sendRedirect("Login.html");
            }

        } catch (Exception e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}