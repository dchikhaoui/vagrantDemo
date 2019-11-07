package com.labenv.secureapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SuperSecretServlet extends HttpServlet {

    @Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/super-secret.html")
            .forward(request, response);
    }

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}