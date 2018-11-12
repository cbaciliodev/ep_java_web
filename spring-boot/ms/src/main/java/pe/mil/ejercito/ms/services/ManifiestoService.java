package pe.mil.ejercito.ms.services;

import pe.mil.ejercito.ms.dto.ManifiestoDTO;
import pe.mil.ejercito.ms.exception.DataBaseException;

public interface ManifiestoService {

	public ManifiestoDTO crearManifiesto(ManifiestoDTO dto) throws DataBaseException;
}
