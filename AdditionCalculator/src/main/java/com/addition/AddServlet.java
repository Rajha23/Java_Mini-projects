package com.addition;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Read values from HTML form
	        String n1 = request.getParameter("num1");
	        String n2 = request.getParameter("num2");
	        if (n1 == null || n2 == null || n1.isEmpty() || n2.isEmpty()) {
	        	PrintWriter out = response.getWriter();	            out.println("<html><body>");
	            out.println("<h3>Please enter both numbers using the form.</h3>");
	            out.println("</body></html>");
	            return;
	        }
	        int num1 = Integer.parseInt(n1);
	        int num2 = Integer.parseInt(n2);
	        // Addition logic
	        int sum = num1 + num2;

	        // Send response
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<html><body>");
	        out.println("<h2>Addition Calculator</h2>");
	        out.println("<p>Number 1: " + num1 + "</p>");
	        out.println("<p>Number 2: " + num2 + "</p>");
	        out.println("<h3>Sum = " + sum + "</h3>");
	        out.println("</body></html>");
	    }
	}
    
   