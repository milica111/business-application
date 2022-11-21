package business.backend.app.entities;

import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpeningHours {

	
	private Map<String, ArrayList<WorkingTime>> days;
}
