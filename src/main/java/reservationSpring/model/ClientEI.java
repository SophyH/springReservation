package reservationSpring.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("EI")
public class ClientEI extends Client{
	@Enumerated(EnumType.STRING)
	@Column(name= "titre", length = 4)
	private Titre titre;
	
	@Column(name="prenom_client", length=150)
	private String prenom;
	
	
	public ClientEI() {
		super();
	}


	public Titre getTitre() {
		return titre;
	}


	public void setTitre(Titre titre) {
		this.titre = titre;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
