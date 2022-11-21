package business.backend.app.entities;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkingTime {

	private String start;
	private String end;
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
