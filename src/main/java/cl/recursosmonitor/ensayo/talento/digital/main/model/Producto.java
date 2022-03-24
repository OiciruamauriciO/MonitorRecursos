package cl.recursosmonitor.ensayo.talento.digital.main.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto implements Serializable{	

	private static final long serialVersionUID = 1L;

	@JsonProperty("product_id")
	private int product_id;
	
	@JsonProperty("product_name")
	private String product_name;
	
	@JsonProperty("brand_id")
	private int brand_id;
	
	@JsonProperty("category_id")
	private int category_id;
	
	@JsonProperty("model_year")
	private int model_year;
	
	@JsonProperty("list_price")
	private int list_price;
	
	public Producto() {
		super();
	}
}
