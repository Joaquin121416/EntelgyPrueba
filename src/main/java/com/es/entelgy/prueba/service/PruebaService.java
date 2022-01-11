package com.es.entelgy.prueba.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.es.entelgy.prueba.bean.Data;
import com.es.entelgy.prueba.bean.Usuario;
import com.es.entelgy.prueba.bean.rest.DataResponse;
import com.es.entelgy.prueba.bean.rest.DataRest;
import com.es.entelgy.prueba.repository.PruebaRepository;

@Service
@Validated
public class PruebaService {
	
	private Logger logger = LoggerFactory.getLogger(PruebaService.class);

	@Autowired
	private PruebaRepository pruebaRepository;

	public PruebaService(PruebaRepository pruebaRepository) {
		this.pruebaRepository = pruebaRepository;
	}
	
	public PruebaService() {
		// TODO Auto-generated constructor stub
	}

	public Data getData() {
		
		logger.info("PruebaService getData");

		Data oData = new Data();
		List<Usuario> lUsuario = new ArrayList<>();
		Usuario oUsuario = null;

		DataResponse oDataResponse = pruebaRepository.getData();

		for (DataRest oDataAux : oDataResponse.getData()) {
			oUsuario = new Usuario();
			oUsuario.setId(oDataAux.getId());
			oUsuario.setEmail(oDataAux.getEmail());			
			oUsuario.setLast_name(oDataAux.getLast_name());			
			lUsuario.add(oUsuario);			
		}
		
		oData.setData(lUsuario);

		return oData;

	}

}
