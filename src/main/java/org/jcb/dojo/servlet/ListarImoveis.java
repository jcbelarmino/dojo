package org.jcb.dojo.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.ejb.ImovelEJB;
import org.jcb.dojo.ejb.Monitor;

@WebServlet("/imovel")
public class ListarImoveis extends HttpServlet {

	@EJB
	ImovelEJB ejb;
	
	@EJB
	Monitor monitor;
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		StringBuilder errorMessage = new StringBuilder();

		try {	

			System.out.println("Latitude='" + request.getParameter("latitude") + "'");
			Imovel imovel = new Imovel();

			String value ;
			String descricao ;

			if ("".equals(value = request.getParameter("latitude")) || value == null ) {
				errorMessage.append("Latitude não pode ser nula\n");
			} else {
				imovel.setLat(Double.valueOf(value));

				if ((value = request.getParameter("longitude")).length() < 1) {
					errorMessage.append("Longitude não pode ser nula\n\n");
				} else {
					imovel.setLongi(Double.valueOf(value));

					if ((value = request.getParameter("preco")).length() < 1) {
						errorMessage.append("Preço não pode ser nulo \n");
					} else // all parameters are filled, register
					{
						
						if ("".equals(descricao = request.getParameter("descricao")) || descricao == null ) {
							errorMessage.append("Descrição não pode ser nula\n");
						}else{
							imovel.setDescricao(descricao);
						}
						
						imovel.setValor(new BigDecimal(Double.valueOf(value)));

						log("\n*****************Tentando gravar o imóvel=" + imovel);
						ejb.criar(imovel);
						request.setAttribute("infoMessage", imovel + " gravado!");
					}
				}
			}
			
			
			
		//Inclui a lista de todos os imoveis
		request.setAttribute("listaImoveis", ejb.recuperarTodos());
		request.setAttribute("qtdImoveis", monitor.getQtdImoveis());
		} catch (Exception e) {

			Throwable t = e;
			while ((t.getCause()) != null) {
				t = t.getCause();
			}

			errorMessage.append("Erro========>" + t.getMessage());
			request.setAttribute("infoMessage", "");
			e.printStackTrace();
		} finally {
			request.setAttribute("errorMessage", errorMessage.toString());
			RequestDispatcher resultView = request.getRequestDispatcher("index.jsp");
			resultView.forward(request, response);
		}
	}

}
