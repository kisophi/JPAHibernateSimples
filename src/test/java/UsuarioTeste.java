import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.akira.sistema.dao.UsuarioDAO;
import br.com.akira.sistema.entidade.Usuario;

public class UsuarioTeste {

	public static void main(String[] args) {

//		salvar();
//		exclui();
//		buscaTodos();
//		buscaPorNome();
//		autentica();
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = dao.buscaPorID(1);
		
		System.out.println("\nID    : " + u.getId());
		System.out.println("Nome  : " + u.getNome());
		System.out.println("Login : " + u.getLogin());
		System.out.println("Senha : " + u.getSenha());
		
		String sdf = new SimpleDateFormat("dd/MM/yyyy").format(u.getNascimento().getTime());
		System.out.println("Nasci : "+sdf);
	}

	private static void autentica() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = dao.autetica("aki", "123");

		System.out.println("\nID    : " + u.getId());
		System.out.println("Nome  : " + u.getNome());
		System.out.println("Login : " + u.getLogin());
		System.out.println("Senha : " + u.getSenha());
		
		String sdf = new SimpleDateFormat("dd/MM/yyyy").format(u.getNascimento().getTime());
		System.out.println(sdf);
	}

	private static void buscaPorNome() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscaPorNome("aki");
		for (Usuario u : lista) {
			System.out.println("\nID    : " + u.getId());
			System.out.println("Nome  : " + u.getNome());
			System.out.println("Login : " + u.getLogin());
			System.out.println("Senha : " + u.getSenha());

			String sdf = new SimpleDateFormat("dd/MM/yyyy").format(u.getNascimento().getTime());
			System.out.println("Nasci : " + sdf);
		}
	}

	private static void buscaTodos() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscaTodos();

		for (Usuario u : lista) {
			System.out.println("\nID    : " + u.getId());
			System.out.println("Nome  : " + u.getNome());
			System.out.println("Login : " + u.getLogin());
			System.out.println("Senha : " + u.getSenha());

			String data = new SimpleDateFormat("dd/MM/yyyy").format(u.getNascimento().getTime());
			System.out.println("Nasci : " + data);
		}
	}

	private static void exclui() {
		UsuarioDAO dao = new UsuarioDAO();
		dao.exclui(3);
	}

	private static void salvar() {
		Usuario u = new Usuario();
		u.setId(0);
		u.setNome("Pedro");
		u.setLogin("ped");
		u.setSenha("444");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse("30/12/1988"));
			u.setNascimento(cal);
		} catch (ParseException e) {
			e.printStackTrace();
		} 

		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(u);
	}
}
