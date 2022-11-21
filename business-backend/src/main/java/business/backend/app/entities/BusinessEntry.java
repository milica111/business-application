package business.backend.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessEntry {

	@JsonProperty("displayed_what")
	private String name;
	
	@JsonProperty("displayed_where")
	private String address;
	
	@JsonProperty("opening_hours")
	private OpeningHours openingHours;
	
}
