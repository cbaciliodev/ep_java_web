package pe.mil.ejercito.ms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.mil.ejercito.ms.dao.UsuarioDAO;
import pe.mil.ejercito.ms.model.Usuario;
import pe.mil.ejercito.ms.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Override
	public List<Usuario> findAll(){
		return usuarioDao.list();
	}
	
	public Usuario obtenerUsuarioByNickname( String nickname ) {
		return usuarioDao.obtenerUsuarioByNickname(nickname);
	}
	
	public boolean validarUsuario( String nickname, String password ) {
		return usuarioDao.validarUsuario(nickname, password);
	}
	
}
