package org.jcb.dojo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jcb.dojo.ejb.HelloWorld;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	@EJB
	private HelloWorld helloEjb;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String nome = req.getParameter("nome");
		String resultado = this.helloEjb.hello(nome);
		PrintWriter out = res.getWriter();
		out.println("<html><body><p>");
		out.println(resultado);
		out.println("</p></body></html>");
	}
}