package pe.mil.ejercito.ms.dao.impl;

import org.springframework.stereotype.Repository;

import pe.mil.ejercito.ms.commons.exception.CommonsException;
import pe.mil.ejercito.ms.commons.MsConfig;
import pe.mil.ejercito.ms.commons.ProcedureUtil;
import pe.mil.ejercito.ms.dao.ManifiestoDAO;
import pe.mil.ejercito.ms.dto.ManifiestoDTO;
import pe.mil.ejercito.ms.exception.DataBaseException;
import pe.mil.ejercito.ms.facade.ManifiestoFacade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static pe.mil.ejercito.ms.commons.ProcedureParams.*;

@Repository
public class ManifiestoDAOImpl extends GenericDAOImpl implements ManifiestoDAO{

	final Logger logger = LogManager.getLogger(ManifiestoDAOImpl.class);
	
	@Override
	public ManifiestoDTO crearManifiesto(ManifiestoDTO dto) throws DataBaseException{
		
		ManifiestoFacade manifiestoFacade = new ManifiestoFacade();
		
		try {
			
			ProcedureUtil pu = new ProcedureUtil( MsConfig.PRC_ES_MANIFIESTO.getValue() );
			pu.addParamProcedureInt(dto.getpSucOrigId(), IN , Double.class, 1);
			pu.addParamProcedureInt(dto.getpSucDestId(), IN, Double.class, 2);
			pu.addParamProcedureInt(dto.getpTranspId(), IN, Double.class, 3);
			pu.addParamProcedureInt(dto.getpUserDespacho(), IN, String.class, 4);
			pu.addParamProcedureInt(dto.getpTipoDestino(), IN, String.class, 5);
			pu.addParamProcedureInt(dto.getpRutDestino(), IN, String.class, 6);
			pu.addParamProcedureOut(dto.getpManifiestoId(), OUT, Double.class, 7, "pManifiestoId");
			pu.addParamProcedureOut(dto.getpErrCode(), OUT, Integer.class, 8, "pErrCode");
			pu.addParamProcedureOut(dto.getpErrMsg(), OUT, String.class, 9, "pErrMsg");
			
			ejecutarProcedimiento(pu);
			manifiestoFacade.populateManifiestoDTO(dto, pu);
			
		} catch (CommonsException e) {
			throw new DataBaseException(e.getCod(), e.getMessage());
		}
		
		return dto;
	}
	
}
