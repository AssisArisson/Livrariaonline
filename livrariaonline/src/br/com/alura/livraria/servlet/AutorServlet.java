package br.com.alura.livraria.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.alura.livraria.dao.AutorDao;
import br.com.alura.livraria.factory.ConnectionFactory;
import br.com.alura.livraria.modelo.Autor;


@WebServlet("/autores")
public class AutorServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private AutorDao dao;
	
	public AutorServlet() {
		
		this.dao = new AutorDao(new ConnectionFactory().getConnection());
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("autores", dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/autores.jsp")
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			LocalDate data = LocalDate.parse(
					req.getParameter("data"),
					DateTimeFormatter.ofPattern("dd/MM/yyy")); 
			String curriculo = req.getParameter("curriculo");	
			
			
		Autor autor = new Autor(
				nome,
				email,
				data,
				curriculo);
		
		dao.cadastrar(autor);
		
		resp.sendRedirect("autores");
			
		} catch(NumberFormatException e) {
			resp.sendRedirect("autores?erro=campo invalido!");
		}
	}

}