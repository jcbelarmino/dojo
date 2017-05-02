package org.jcb.dojo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.jcb.dojo.ejb.ImovelEJB;

@WebServlet("/imovel")
public class ListarImoveis extends HttpServlet {
	
	@EJB
	ImovelEJB ejb;
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
		
		PrintWriter out = res.getWriter();
		out.println("<html><body><p>");
		out.println(ejb.recuperarTodos());
		out.println("</p></body></html>");
	}

}
