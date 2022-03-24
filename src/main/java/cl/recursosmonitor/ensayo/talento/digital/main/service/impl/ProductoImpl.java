package cl.recursosmonitor.ensayo.talento.digital.main.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.recursosmonitor.ensayo.talento.digital.main.model.NotKnowObject;
import cl.recursosmonitor.ensayo.talento.digital.main.model.CustomObject;
import cl.recursosmonitor.ensayo.talento.digital.main.service.IProducto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductoImpl implements IProducto{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<CustomObject> getProductosService() {

		log.info("Service:Impl::getProductosService");

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			
		ResponseEntity<CustomObject> response = restTemplate.exchange("http://localhost:8081/methodGetProducts/all/", HttpMethod.GET, new HttpEntity<>(headers), new ParameterizedTypeReference<CustomObject>() {});

		log.info("Response: {}", response.getBody());
		log.info(response.getBody().getListaProductos().get(0).getProduct_name());

		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<NotKnowObject> getProductosAbstractService() {
		log.info("Service:Impl::getProductosAbstractServicegetProductosAbstractService");
		
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		ResponseEntity<NotKnowObject> response = restTemplate.exchange("http://localhost:8081/methodGetProducts/all/", HttpMethod.GET, new HttpEntity<>(headers), new ParameterizedTypeReference<NotKnowObject>() {});
		
		log.info("[DATA]");
		log.info("Response: {}", response.getBody());

		return new ResponseEntity<NotKnowObject>(response.getBody(), HttpStatus.OK);
	}	

}
