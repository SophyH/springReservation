package reservationSpring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
public class EscalePk implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "id_aeroport_escale", foreignKey = @ForeignKey(name = "escale_id_aeroport_fk"))
	private Aeroport aeroport;
	
	@ManyToOne
	@JoinColumn(name = "id_vol_escale", foreignKey = @ForeignKey(name = "escale_id_vol_fk"))
	private Vol vol;
	
	
	@Column(name = "heure_depart")
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	
	@Column(name = "heure_arrivee")
	@Temporal(TemporalType.TIME)
	private Date heureArrivee;

	public EscalePk(Aeroport aeroport, Vol vol, Date heureDepart, Date heureArrivee) {
		super();
		this.aeroport = aeroport;
		this.vol = vol;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}

	public EscalePk(Date heureDepart, Date heureArrivee) {
		super();
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}

	public EscalePk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroport == null) ? 0 : aeroport.hashCode());
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
		EscalePk other = (EscalePk) obj;
		if (aeroport == null) {
			if (other.aeroport != null)
				return false;
		} else if (!aeroport.equals(other.aeroport))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}
	
	

}
