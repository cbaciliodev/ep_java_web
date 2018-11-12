package pe.mil.ejercito.ms.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.mil.ejercito.ms.dao.ManifiestoDAO;
import pe.mil.ejercito.ms.dto.ManifiestoDTO;
import pe.mil.ejercito.ms.exception.DataBaseException;
import pe.mil.ejercito.ms.services.ManifiestoService;

@Service
@Transactional
public class ManifiestoServiceImpl implements ManifiestoService{
	
	@Autowired
	private ManifiestoDAO manifiestoDao;
	
	public ManifiestoDTO crearManifiesto(ManifiestoDTO dto) throws DataBaseException{
		return manifiestoDao.crearManifiesto(dto);
	} 
}
