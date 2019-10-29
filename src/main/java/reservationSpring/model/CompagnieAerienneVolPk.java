package reservationSpring.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompagnieAerienneVolPk implements Serializable {

	@ManyToOne
	@JoinColumn(name = "id_vol_compagnie_aerienne_vol", foreignKey = @ForeignKey(name = "compagnie_aerienne_vol_id_vol_fk"))
	private Vol vol;
	@ManyToOne
	@JoinColumn(name = "id_compagnie_compagnie_aerienne_vol", foreignKey = @ForeignKey(name = "compagnie_aerienne_vol_id_compagnie_fk"))
	private CompagnieAerienne compagnieAerienne;

	public CompagnieAerienneVolPk() {

	}

	public CompagnieAerienneVolPk(Vol vol, CompagnieAerienne compagnieAerienne) {
		super();
		this.vol = vol;
		this.compagnieAerienne = compagnieAerienne;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compagnieAerienne == null) ? 0 : compagnieAerienne.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
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
		CompagnieAerienneVolPk other = (CompagnieAerienneVolPk) obj;
		if (compagnieAerienne == null) {
			if (other.compagnieAerienne != null)
				return false;
		} else if (!compagnieAerienne.equals(other.compagnieAerienne))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}

}
