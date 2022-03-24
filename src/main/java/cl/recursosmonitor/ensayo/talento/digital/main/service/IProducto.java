package cl.recursosmonitor.ensayo.talento.digital.main.service;

import org.springframework.http.ResponseEntity;

import cl.recursosmonitor.ensayo.talento.digital.main.model.NotKnowObject;
import cl.recursosmonitor.ensayo.talento.digital.main.model.CustomObject;

public interface IProducto {
	
	ResponseEntity<CustomObject> getProductosService();
	ResponseEntity<NotKnowObject> getProductosAbstractService();

}
