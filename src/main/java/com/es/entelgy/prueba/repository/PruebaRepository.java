package com.es.entelgy.prueba.repository;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.es.entelgy.prueba.bean.rest.DataResponse;

@Repository
public class PruebaRepository {
	
	private Logger logger = LoggerFactory.getLogger(PruebaRepository.class);

	@Value("${service.data.host}")
	private String urlDatos;

	@Autowired
	RestTemplate restTemplate;

	public DataResponse getData() {
		
		logger.info("PruebaRepository getData");

		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //Sin agente no funciona
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<DataResponse> response =  restTemplate.exchange(urlDatos, HttpMethod.GET,entity,DataResponse.class);

		return response.getBody();
	}
}
