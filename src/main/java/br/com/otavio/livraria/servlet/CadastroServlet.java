package br.com.otavio.livraria.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otavio.livraria.dao.CadastroDao;
import br.com.otavio.livraria.factory.ConnectionFactory;
import br.com.otavio.livraria.model.Cadastro;

@WebServlet("/registros")
public class CadastroServlet extends HttpServlet {

	private CadastroDao dao;

	public CadastroServlet() {
		this.dao = new CadastroDao(new ConnectionFactory().getConnection());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("registros", dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/registros.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String dataDeNascimento = req.getParameter("dataDeNascimento");
			String curriculo = req.getParameter("curriculo");

			Cadastro registro = new Cadastro(nome, email, dataDeNascimento, curriculo);

			dao.cadastrar(registro);

			res.sendRedirect("registros");
		} catch (NumberFormatException e) {
			res.sendRedirect("registros?erro=campo inválido!");
		}
	}
}
