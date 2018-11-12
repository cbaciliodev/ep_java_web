package pe.mil.ejercito.ms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.mil.ejercito.ms.commons.SwaggerApiMessages;
import pe.mil.ejercito.ms.dto.ManifiestoDTO;
import pe.mil.ejercito.ms.exception.DataBaseException;
import pe.mil.ejercito.ms.services.ManifiestoService;

import org.springframework.http.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@Api(value = "manifiesto")
public class ManifiestoController extends BaseController  {

	@Autowired
	private ManifiestoService manifiestoService;
	
	@ApiOperation(value = "Servicio que obtiene la lista de estrategias de abordaje del diagnóstico de indicadores.", response = ManifiestoDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Información obtenida con éxito"),
			@ApiResponse(code = 400, message = SwaggerApiMessages.MESSAGE_400),
			@ApiResponse(code = 401, message = SwaggerApiMessages.MESSAGE_401),
			@ApiResponse(code = 404, message = SwaggerApiMessages.MESSAGE_404) })
	@RequestMapping(value = "/crear_manifiesto/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ManifiestoDTO listaPlanAccion(@RequestBody ManifiestoDTO dto, HttpServletResponse response,
			HttpServletRequest request){
		
		try {
			return manifiestoService.crearManifiesto(dto);
		} catch ( DataBaseException e ) {
			dto.errorException(e.getCod(), e.getMessage());
		}
		
		return dto;
	}
        
        @ApiOperation(value = "Servicio responde con un mensaje desde el servidor.", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Información obtenida con éxito"),
			@ApiResponse(code = 400, message = SwaggerApiMessages.MESSAGE_400),
			@ApiResponse(code = 401, message = SwaggerApiMessages.MESSAGE_401),
			@ApiResponse(code = 404, message = SwaggerApiMessages.MESSAGE_404) })
	@RequestMapping(value = "/decir_hola/", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public String listaDecirHola(@RequestBody String mensaje, HttpServletResponse response,
			HttpServletRequest request){
		return mensaje + " desde el servidor";
	}
}
