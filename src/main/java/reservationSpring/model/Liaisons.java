package reservationSpring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "liaisons")
public class Liaisons {
	
	@EmbeddedId
	LiaisonsPk key;

	public Liaisons() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Liaisons(LiaisonsPk key) {
		super();
		this.key = key;
	}

	public LiaisonsPk getKey() {
		return key;
	}

	public void setKey(LiaisonsPk key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Liaisons other = (Liaisons) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
	
	
	

}
