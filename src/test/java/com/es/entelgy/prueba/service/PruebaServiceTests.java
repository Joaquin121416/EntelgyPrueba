package com.es.entelgy.prueba.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.es.entelgy.prueba.bean.Data;
import com.es.entelgy.prueba.bean.rest.DataResponse;
import com.es.entelgy.prueba.bean.rest.DataRest;
import com.es.entelgy.prueba.repository.PruebaRepository;


@ExtendWith(MockitoExtension.class)
public class PruebaServiceTests {

	@Mock
	private PruebaRepository pruebaRepository;
	
	
	PruebaService pruebaService;

	@BeforeEach
    void initUseCase() {
		pruebaService = new PruebaService(pruebaRepository);
    }
	
	
	//Mockeandod la respuesta del Servicio
	
	DataResponse getData() {
		List<DataRest> listDataRest = new ArrayList<DataRest>();
		
		DataRest oDataRest = new DataRest();
		oDataRest.setAvatar("Avatar.jpg");
		oDataRest.setEmail("joaquin121416@gmail.com");
		oDataRest.setFirst_name("joaquin");
		oDataRest.setId(1);
		oDataRest.setLast_name("Cunorana");
		listDataRest.add(oDataRest);

		DataResponse odata = new DataResponse();
		odata.setPage(1);
		odata.setPer_page(1);
		odata.setTotal(1);
		odata.setTotal_pages(1);
		odata.setData(listDataRest);
		
		return odata;	
	}
	
	//Test del servicio
	
	@Test
	public void PruebaService() {
		
	
		when(pruebaRepository.getData()).thenReturn(getData());
		
		Data odata = pruebaService.getData();
		
		verify(pruebaRepository, times(1)).getData();
		
		assertEquals(getData().getData().get(0).getId(), odata.getData().get(0).getId());
	}

}
