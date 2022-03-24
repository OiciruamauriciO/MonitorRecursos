package cl.recursosmonitor.ensayo.talento.digital.main.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomObject {
	
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("listProducts")
	private List<Producto> listaProductos;

}
