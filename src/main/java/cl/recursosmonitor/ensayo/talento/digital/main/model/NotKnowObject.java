package cl.recursosmonitor.ensayo.talento.digital.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotKnowObject {
	
	@JsonProperty("status")
	private Object elementOne;
	
	@JsonProperty("message")
	private Object elementTwo;
	
	@JsonProperty("listProducts")
	private Object elementThree;

}
