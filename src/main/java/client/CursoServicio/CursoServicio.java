package client.CursoServicio;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import client.Curso.CursosPrincipal;
import client.cursoDominio.CursoDTO;
import client.cursoUtil.ResponseDTO;
import feign.Response;

@Service
public class CursoServicio {
	
	@Autowired
	
	CursosPrincipal cursobd;
	
	public Map<String, Object>listar(){
	
		 Map<String,Object>model = new HashMap<>();
		 
		 
		 try {
			 	ResponseDTO cursoList = cursobd.listar();
			 	model.put("cursoList", cursoList.getRespuesta());
			
		} catch (Exception e) {
			model.put("err", "error");
			model.put("msg", "error bla bla bla");
			e.printStackTrace();
		
		}
		 
		 return model;
	}
	
	public Map<String, Object>crear(CursoDTO curso){
		
		 Map<String,Object>model = new HashMap<>();
		 
		 try {
			 	ResponseDTO res =  cursobd.crear(curso);
			
		} catch (HttpStatusCodeException e) {
			model.put("msg",ResponseDTO.MSG_FATAL_ERROR);
			e.printStackTrace();
		}
		 return model;
	}
	

	public Map<String, Object>actualizar(CursoDTO curso){
		
		 Map<String,Object>model = new HashMap<>();
		 
		try {
			
			ResponseDTO res = cursobd.actualizar(curso);
			
		} catch (HttpStatusCodeException e) {
			model.put("msg", ResponseDTO.CODE_FATAL_ERROR);
			e.printStackTrace();
		}
		 return model;
	}
	
	public Map<String, Object>eliminar(Long Id_Curso){
		
		 Map<String,Object>model = new HashMap<>();
		 
		try {
			
		 cursobd.borrar(Id_Curso);
			
		} catch (HttpStatusCodeException e) {
			model.put("msg", ResponseDTO.CODE_FATAL_ERROR);
			e.printStackTrace();
		}
		 return model;
	}


	

}
