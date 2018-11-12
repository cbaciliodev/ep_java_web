package pe.mil.ejercito.ms.dao;

import java.util.List;
import java.util.Map;

import pe.mil.ejercito.ms.commons.ProcedureUtil;
import pe.mil.ejercito.ms.exception.DataBaseException;

public interface GenericDAO {
	
	public List<Map<String, Object>> ejecutarNativeQueryMapList(String sql, Map<String, Object> params) throws DataBaseException;
	
	public void ejecutarNativeQueryVoid(String sql, Map<String, Object> params) throws DataBaseException;
	
	public void ejecutarProcedimiento( ProcedureUtil procedureUtil ) throws DataBaseException;

}
