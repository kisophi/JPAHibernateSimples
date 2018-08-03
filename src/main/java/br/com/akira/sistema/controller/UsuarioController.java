package br.com.akira.sistema.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.sistema.dao.UsuarioDAO;
import br.com.akira.sistema.entidade.Nivel;
import br.com.akira.sistema.entidade.Usuario;

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		//lista todos se a acao for nula
		if (acao == null) {
			acao = "listar";
			//Apenas mostra o nome do usuario logado
			HttpSession sessao = request.getSession();
			System.out.println("Usuario Logado : "+sessao.getAttribute("usuarioSessaoNome"));
		}

		// Acao listar
		if (acao.equals("listar"))
			listar(request, response);
		//acao inserir
		else if (acao.equals("inserir")) {
			inserir(request, response);
		}
		//acao Atualizar
		else if (acao.equals("atualizar")) {
			atualizar(request, response);
		}
		//acao excluir
		else if (acao.equals("excluir")) {
			excluir(request, response);
		}
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.exclui(Integer.parseInt(id));
		
		response.sendRedirect("usuController");
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		UsuarioDAO dao = new UsuarioDAO();
		Usuario objBuscado = dao.buscaPorID(Integer.parseInt(id));
		
		request.setAttribute("objBuscado", objBuscado);
		request.getRequestDispatcher("WEB-INF/usuarioAtualiza.jsp").forward(request, response);
	}

	private void inserir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/usuarioInsere.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscaTodos();

		request.setAttribute("lista", lista);
		request.getRequestDispatcher("WEB-INF/usuarioLista.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pegando os dados da tela
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nascimento = request.getParameter("nascimento");
		String nivel = request.getParameter("nivel");

		// Preenchendo o Usuario
		Usuario u = new Usuario();
		u.setId(Integer.parseInt(id));
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);

		// formatando a data e convertendo para caledar
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(nascimento));
			u.setNascimento(cal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// inserindo o nivel
		Nivel n = new Nivel();
		n.setId(Integer.parseInt(nivel));

		u.setNivel(n);

		//Salvar
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(u);

		response.sendRedirect("usuController");

	}

}
