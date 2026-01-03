package com.interest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SimpleInterestServlet
 */
@WebServlet("/SimpleInterestServlet")
public class SimpleInterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read input values
        String pVal = request.getParameter("p");
        String rVal = request.getParameter("r");
        String tVal = request.getParameter("t");

        // Validation
        if (pVal == null || rVal == null || tVal == null ||
            pVal.isEmpty() || rVal.isEmpty() || tVal.isEmpty()) {

            out.println("<h3>Please enter all values using the form.</h3>");
            return;
        }

        double p = Double.parseDouble(pVal);
        double r = Double.parseDouble(rVal);
        double t = Double.parseDouble(tVal);

        // Simple Interest calculation
        double si = (p * r * t) / 100;

        // Output
        out.println("<html><body>");
        out.println("<h2>Simple Interest Result</h2>");
        out.println("<p>Principal (P): " + p + "</p>");
        out.println("<p>Rate (R): " + r + "%</p>");
        out.println("<p>Time (T): " + t + " years</p>");
        out.println("<h3>Simple Interest = " + si + "</h3>");
        out.println("</body></html>");
    }
}
