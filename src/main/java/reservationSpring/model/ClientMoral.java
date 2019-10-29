package reservationSpring.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("M")
public class ClientMoral extends Client{
	@Enumerated(EnumType.STRING)
	@Column(name= "titre", length = 4)
	private Titre titre;
	@Column(name="siret_client", length=150)
	private String siret;
	
	public ClientMoral() {
		super();
	}
	
	public ClientMoral(String siret) {
		super();
		this.siret = siret;
	}

	
	public ClientMoral(Titre titre, String siret) {
		super();
		this.titre = titre;
		this.siret = siret;
	}

	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	
	
	
}
