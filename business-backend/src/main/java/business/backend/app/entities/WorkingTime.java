package business.backend.app.entities;

import java.time.LocalTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkingTime {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime start;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
	private LocalTime end;
	
	private String type;
	
	@Override
	public int hashCode() {
		return Objects.hash(end, start, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkingTime other = (WorkingTime) obj;
		return Objects.equals(end, other.end) && Objects.equals(start, other.start) && Objects.equals(type, other.type);
	}
	
}

