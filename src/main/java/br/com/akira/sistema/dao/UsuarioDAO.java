package br.com.akira.sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.akira.sistema.entidade.Usuario;

public class UsuarioDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHibernatePersistence");
	EntityManager em = emf.createEntityManager();
	private Usuario usuario;

	/**
	 * Metodo salvar Insere se o ID for igual a Zero Atualiza se houver o ID
	 * 
	 * @param Usuario
	 */
	public void salvar(Usuario u) {
		try {

			em.getTransaction().begin();
			// Insere se for igual a Zero
			if (u.getId() == 0) {
				em.persist(u);
			} else {
				// Atualiza
				em.merge(u);
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		} finally {
			em.close();
			emf.close();
		}
	}

	/**
	 * Metodo Excluir Exclui o Usuario pelo ID
	 * 
	 * @param id
	 */
	public void exclui(int id) {
		try {
			em.getTransaction().begin();
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		} finally {
			em.close();
			emf.close();
		}
	}

	/**
	 * Metodo Busca Todos Tras uma lista de Usuarios
	 * 
	 * @return lista
	 */
	public List<Usuario> buscaTodos() {
		try {
			List lista = em.createQuery("from Usuario").getResultList();
			return lista;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		} finally {
			em.close();
			emf.close();
		}
		return null;
	}
	
	
	/**
	 * Metodo busca por nome
	 * tras todos os usuarios com o nome passado
	 * @param nome
	 * @return lista
	 */
	public List<Usuario> buscaPorNome(String nome) {
		try {
			List lista = em.createQuery("from Usuario where nome like :pnome")
					.setParameter("pnome", "%" + nome + "%")
					.getResultList();
			return lista;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		} finally {
			em.close();
			emf.close();
		}
		return null;
	}

	
	/**
	 * Metodo autetica
	 * tras apenas o usuario com o login e a senha passado
	 * @param login
	 * @param senha
	 * @return Usuario
	 */
	public Usuario autetica(String login,String senha) {
		try {
			Object usuario = em.createQuery("from Usuario where login= :plogin and senha= :psenha")
					.setParameter("plogin", login)
					.setParameter("psenha", senha)
					.getSingleResult();
			return (Usuario) usuario;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Metodo busca por ID
	 * tras o Usuario pelo ID passado
	 * @param id
	 * @return Usuario
	 */
	public Usuario buscaPorID(int id) {
		try {
			Object usuario = em.createQuery("from Usuario where id= :pid")
					.setParameter("pid", id)
					.getSingleResult();
			return (Usuario) usuario;
		}catch (Exception e) {
			System.out.println("ID inexistente "+e);
		}
		return null;
	}
}
