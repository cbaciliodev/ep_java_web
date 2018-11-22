package pe.mil.ejercito.ms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.mil.ejercito.ms.dao.UsuarioDAO;
import pe.mil.ejercito.ms.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	@PersistenceContext
	private EntityManager em;
	
	public boolean validarUsuario( String nickname, String password ) {
		
		Usuario usuario = null;
		
		Query q = em.createQuery("select u from Usuario u where "
				+ "u.nickname=:nickname and u.password=:password");
		q.setParameter("nickname", nickname);
		q.setParameter("password", password);
		
		usuario = (Usuario)q.getSingleResult();
		
		return usuario!=null;
		
	}
	
	public List<Usuario> list(){
		List<Usuario> usuarioLst = new ArrayList<>();
		
		Query q = em.createQuery("select u from Usuario u");
		/**
		 * Retorna una lista
		 */
		usuarioLst = q.getResultList(); 
		
		return usuarioLst;
	}
	
	public Usuario obtenerUsuarioByNickname( String nickname ) {
		
		Usuario usuario = null;
		
		Query q = em.createQuery("select u from Usuario u where u.nickname=:nickname");
		q.setParameter("nickname", nickname);
		
		/**
		 * Retorna un único objeto, libera una excepción si la consulta 
		 * retorna mas de un objeto
		 */
		usuario = (Usuario) q.getSingleResult(); 
		
		return usuario;
		
	}
	
	@Transactional
	public Usuario guardarUsuario(Usuario usuario) {
		
		em.persist(usuario);
		return usuario;
	}
	
	
}
