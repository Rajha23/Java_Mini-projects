package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UsernameServlet
 */
@WebServlet("/UsernameServlet")
public class UsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read username
        String username = request.getParameter("username");

        // Validation
        if (username == null || username.trim().isEmpty()) {
            out.println("<h3>Please enter a valid username.</h3>");
            return;
        }

        // Output
        out.println("<html><body>");
        out.println("<h2>Welcome, " + username + "!</h2>");
        out.println("</body></html>");
    }
}
   