package reservationSpring.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("P")
public class ClientPhysique extends Client {
	@Enumerated(EnumType.STRING)
	@Column(name= "titre", length = 4)
	private Titre titre;
	
	@Column(name="prenom_client", length=150)
	private String prenom;

	
	public ClientPhysique() {
		super();
	}


	public ClientPhysique(String prenom) {
		super();
		this.prenom = prenom;
	}


	public ClientPhysique(Titre titre, String prenom) {
		super();
		this.titre = titre;
		this.prenom = prenom;
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
