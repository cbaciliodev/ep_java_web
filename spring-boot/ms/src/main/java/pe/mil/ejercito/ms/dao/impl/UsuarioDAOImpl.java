package pe.mil.ejercito.ms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pe.mil.ejercito.ms.dao.UsuarioDAO;
import pe.mil.ejercito.ms.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	@PersistenceContext
	private EntityManager em;
	
	public List<Usuario> list(){
		List<Usuario> usuarioLst = new ArrayList<>();
		
		Query q = em.createQuery("select u from Usuario u");
		usuarioLst = q.getResultList();
		
		System.out.println("Lista de usuarios: " + usuarioLst.size());
		
		return usuarioLst;
	}
	
}
