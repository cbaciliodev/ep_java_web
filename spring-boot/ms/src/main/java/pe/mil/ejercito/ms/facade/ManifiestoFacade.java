package pe.mil.ejercito.ms.facade;

import pe.mil.ejercito.ms.commons.ProcedureParams;
import pe.mil.ejercito.ms.commons.ProcedureUtil;
import pe.mil.ejercito.ms.dto.ManifiestoDTO;

import static pe.mil.ejercito.ms.commons.FunctionsUtil.*;

import pe.mil.ejercito.ms.commons.ReflectionUtil;
import pe.mil.ejercito.ms.commons.exception.CommonsException;

public class ManifiestoFacade {

	public ManifiestoDTO populateManifiestoDTO( ManifiestoDTO manifiestoDTO, ProcedureUtil procedureUtil ) throws CommonsException {
		
		if( isEmpty(procedureUtil) ) { return null; }
		if( isEmpty(manifiestoDTO) ) { manifiestoDTO = new ManifiestoDTO(); }
		
		if( procedureUtil.hasParamsOut() ) {
			ReflectionUtil ru = new ReflectionUtil();
			
			for( ProcedureParams pp : procedureUtil.getProcedureParamsOut() ) {
				ru.setValueInField(manifiestoDTO, pp.getVarNameOut(), pp.getValue());
			}
		}
		
		return manifiestoDTO;
	}
	
}
