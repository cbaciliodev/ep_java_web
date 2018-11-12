package pe.mil.ejercito.ms.dao;

import pe.mil.ejercito.ms.dto.ManifiestoDTO;
import pe.mil.ejercito.ms.exception.DataBaseException;

public interface ManifiestoDAO {

	public ManifiestoDTO crearManifiesto(ManifiestoDTO dto) throws DataBaseException;
	
}
