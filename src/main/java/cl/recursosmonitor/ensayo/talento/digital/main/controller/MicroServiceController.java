package cl.recursosmonitor.ensayo.talento.digital.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.recursosmonitor.ensayo.talento.digital.main.model.NotKnowObject;
import cl.recursosmonitor.ensayo.talento.digital.main.model.CustomObject;
import cl.recursosmonitor.ensayo.talento.digital.main.model.Producto;
import cl.recursosmonitor.ensayo.talento.digital.main.service.impl.ProductoImpl;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MicroServiceController {
	
	@Autowired
	private ProductoImpl productosService;

	@GetMapping(path = "/lista", produces = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE })	
	public String viewProductsListTable(Model modelo) {
		
		log.info("Controller::viewProductsListTable");
		
		ResponseEntity<CustomObject> listaRetornada = productosService.getProductosService();
		
		List<Producto> listaProductos = new ArrayList<Producto>();
		
		if(listaRetornada!=null) {
			
			log.info("listaRetornada!=null");
			log.info(listaRetornada.getBody().getMessage());
			log.info(String.valueOf(listaRetornada.getBody().getStatus()));
			
			listaProductos = listaRetornada.getBody().getListaProductos();

			
		}
		
		modelo.addAttribute("productos", listaProductos);
		
		return "productos";
	}
		
	@GetMapping(path = "/notknow", produces = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE })	
	public String viewProductsAbstractListTable(Model modelo) {
		
		log.info("Controller::viewProductsAbstractListTable");
		
		ResponseEntity<NotKnowObject> listaRetornada = productosService.getProductosAbstractService();
		
		NotKnowObject localNotKnowObject = listaRetornada.getBody();	
		
		if(localNotKnowObject!=null) {
			
			log.info("localNotKnowObject!=null");
			log.info(localNotKnowObject.getElementOne().getClass().getName());
			log.info(localNotKnowObject.getElementTwo().getClass().getName());
			log.info(localNotKnowObject.getElementThree().getClass().getName());	
			
		}
		
        @SuppressWarnings("unchecked")
		List<Object> objectList = (List<Object>) localNotKnowObject.getElementThree();

        Iterable<Object> iterableobjectList = objectList;

        for (Object i: iterableobjectList) {
            System.out.println(i);
        }		
        
        modelo.addAttribute("notknowthirdelement", iterableobjectList);
        
		
		return "notknow";
	}


}
