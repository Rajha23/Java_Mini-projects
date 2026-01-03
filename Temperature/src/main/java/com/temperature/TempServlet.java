package com.temperature;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TempServlet
 */
@WebServlet("/TempServlet")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        // Read Celsius value
	        String cVal = request.getParameter("celsius");

	        // Validation
	        if (cVal == null || cVal.isEmpty()) {
	            out.println("<h3>Please enter temperature in Celsius.</h3>");
	            return;
	        }

	        double celsius = Double.parseDouble(cVal);

	        // Conversion formula
	        double fahrenheit = (celsius * 9 / 5) + 32;

	        // Output
	        out.println("<html><body>");
	        out.println("<h2>Temperature Conversion Result</h2>");
	        out.println("<p>Celsius: " + celsius + " °C</p>");
	        out.println("<h3>Fahrenheit: " + fahrenheit + " °F</h3>");
	        out.println("</body></html>");
	    }
}