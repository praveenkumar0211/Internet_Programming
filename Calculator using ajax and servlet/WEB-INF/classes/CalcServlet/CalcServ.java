package CalcServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.lang.Math;

public class CalcServ extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {    
        PrintWriter pw = res.getWriter();
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String op = req.getParameter("op");
	   float n1 = Float.parseFloat(num1);
	   float n2 = Float.parseFloat(num2);

        switch (op) 
        {
            case "Add":
                pw.println("Sum = "+(n1+n2));
                break;

            case "Subtract":
                pw.println("Difference = "+(n1-n2));
                break;

            case "Multiply":
                pw.println("Product = "+(n1*n2));
                break;

            case "Divide":
                pw.println("Quotient = "+(n1/n2));
                break;

            case "Modulus":
                pw.println("Remainder = "+(n1%n2));                			break;

            case "Power":
                pw.println("Answer = "+(Math.pow(n1,n2)));
                break;
        } 
        
    }
}