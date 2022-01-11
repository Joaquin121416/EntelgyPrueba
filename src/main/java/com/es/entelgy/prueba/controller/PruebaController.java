package com.es.entelgy.prueba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.entelgy.prueba.bean.Data;
import com.es.entelgy.prueba.service.PruebaService;

@RestController
@RequestMapping("/api/v1/user")
public class PruebaController {
	
	private Logger logger = LoggerFactory.getLogger(PruebaController.class);
	
	@Autowired
	private PruebaService pruebaService;

	@PostMapping()
	public Data getUser() {
		
		logger.info("PruebaController getUser");
	
		Data oData = new Data();
		
		oData = pruebaService.getData();
		
		return oData;
	}

}
