package com.labenv.secureapp;

import java.util.Enumeration;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetAttributesServlet extends HttpServlet {

    @Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			switch(name) {
				case "GIVENNAME":
					request.setAttribute("givenName", request.getHeader(name));
					break;
				case "MAIL":
					request.setAttribute("mail", request.getHeader(name));
					break;
				case "TELEPHONENUMBER":
					request.setAttribute("telephoneNumber", request.getHeader(name));
					break;
			}
        }
        request.getRequestDispatcher("/get-attributes.jsp")
            .forward(request, response);
    }

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}