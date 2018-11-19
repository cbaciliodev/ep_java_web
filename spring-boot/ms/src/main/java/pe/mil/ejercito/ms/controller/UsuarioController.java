package pe.mil.ejercito.ms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.mil.ejercito.ms.commons.SwaggerApiMessages;
import pe.mil.ejercito.ms.model.Usuario;
import pe.mil.ejercito.ms.services.UsuarioService;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.http.MediaType;

@RestController( value = "usuario" )
@Api(value = "usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation(value = "Retorna solo un usuario de una lista completa", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Información obtenida con éxito"),
			@ApiResponse(code = 400, message = SwaggerApiMessages.MESSAGE_400),
			@ApiResponse(code = 401, message = SwaggerApiMessages.MESSAGE_401),
			@ApiResponse(code = 404, message = SwaggerApiMessages.MESSAGE_404) })
	@RequestMapping(value = "/list/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Usuario getUsuario( HttpServletResponse response, HttpServletRequest request) {
		return usuarioService.findAll().get(0);
	}
	
	@ApiOperation(value = "Retorna un usuariopor su nickname", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Información obtenida con éxito"),
			@ApiResponse(code = 400, message = SwaggerApiMessages.MESSAGE_400),
			@ApiResponse(code = 401, message = SwaggerApiMessages.MESSAGE_401),
			@ApiResponse(code = 404, message = SwaggerApiMessages.MESSAGE_404) })
	@RequestMapping(value = "/byNickname/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Usuario getUsuarioByNickname( @RequestBody String nickname,  HttpServletResponse response, HttpServletRequest request) {
		return usuarioService.obtenerUsuarioByNickname(nickname);
	}
	
	@ApiOperation(value = "Valida si un usuario esta registrado en el sistema", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Información obtenida con éxito"),
			@ApiResponse(code = 400, message = SwaggerApiMessages.MESSAGE_400),
			@ApiResponse(code = 401, message = SwaggerApiMessages.MESSAGE_401),
			@ApiResponse(code = 404, message = SwaggerApiMessages.MESSAGE_404) })
	@RequestMapping(value = "/isUsuario/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Boolean isUsuario( @RequestBody Usuario usuario,  HttpServletResponse response, HttpServletRequest request) {
		try {
			return usuarioService.validarUsuario(usuario.getNickname(), usuario.getPassword());	
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
//	@ApiOperation(value = "Retorna solo un usuario de una lista completa", response = Usuario.class)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Información obtenida con éxito"),
//			@ApiResponse(code = 400, message = SwaggerApiMessages.MESSAGE_400),
//			@ApiResponse(code = 401, message = SwaggerApiMessages.MESSAGE_401),
//			@ApiResponse(code = 404, message = SwaggerApiMessages.MESSAGE_404) })
//	@RequestMapping(value = "/list/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Usuario getUsuario(@RequestBody Usuario usuario, 
//			HttpServletResponse response,
//			HttpServletRequest request) {
//		
//		return usuarioService.findAll().get(0);
//		
//	}
	
}
