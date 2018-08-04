package br.com.akira.sistema.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.sistema.dao.UsuarioDAO;
import br.com.akira.sistema.entidade.Usuario;

public class UsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		
		//invalida a sessao
		if (sessao != null) {
			sessao.invalidate();
		}
		
		//retorna para tela de login
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuAutenticado = dao.autetica(login, senha);

		if (usuAutenticado == null) {
			//Usuario nulo envia para tela de erro
			request.getRequestDispatcher("loginErro.jsp").forward(request, response);
		} else {
			//Cria a Sessao
			HttpSession sessao = request.getSession();
			
			//Tempo de vida da sessao sem MEXER eh de 5min, passando disso a sessao expira
			sessao.setMaxInactiveInterval(60*5);
			
			//Seta o usuario na sessao
			sessao.setAttribute("usuAutenticado", usuAutenticado);
			
			//Seta o nome do usuario
			sessao.setAttribute("usuarioSessaoNome", usuAutenticado.getNome());
			
			//Seta o Valor do nivel ID do usuario
			sessao.setAttribute("usuarioNivelID", usuAutenticado.getNivel().getId());
			
			//redireciona para usuController/lista
			response.sendRedirect("usuController");
		}

	}

}
