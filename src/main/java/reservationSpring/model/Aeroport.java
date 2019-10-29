package reservationSpring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "aeroport")
@SequenceGenerator(name = "seqAeroport", sequenceName = "seq_aeroport", initialValue = 100, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Aeroport.findByKeyWithVille", query = "select a from Aeroport a left join fetch a.liaisons l left join fetch l.key.ville "
			+ "where a.idAeroport=:key"),
	@NamedQuery(name = "Aeroport.findAllWithVille", query = "select a from Aeroport a left join fetch a.liaisons l left join fetch l.key.ville "),
	@NamedQuery(name = "Aeroport.findByKeyWithEscale", query = "select a from Aeroport a left join fetch a.escales e "
			+ "where a.idAeroport=:key"),
	@NamedQuery(name = "Aeroport.findAllWithEscale", query = "select a from Aeroport a left join fetch a.escales e")
})
public class Aeroport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	@Column(name = "id_aeroport")
	private Long idAeroport;
	
	@Column(name = "nom_aeroport", length = 150)
	private String nomAeroport;
	
	
	@OneToMany(mappedBy="aeroportArrivee")
	private Set<Vol> volArrivee;
	
	@OneToMany(mappedBy="aeroportDepart")
	private Set<Vol> volDepart;
	
	@OneToMany(mappedBy="key.aeroport")
	Set<Escale> escales;
	
	@OneToMany(mappedBy="key.aeroport")
	Set<Liaisons> liaisons;
	
	

	public Aeroport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(Long idAeroport) {
		this.idAeroport = idAeroport;
	}

	public String getNomAeroport() {
		return nomAeroport;
	}

	public void setNomAeroport(String nomAeroport) {
		this.nomAeroport = nomAeroport;
	}

	public Set<Vol> getVolArrivee() {
		return volArrivee;
	}

	public void setVolArrivee(Set<Vol> volArrivee) {
		this.volArrivee = volArrivee;
	}

	public Set<Vol> getVolDepart() {
		return volDepart;
	}

	public void setVolDepart(Set<Vol> volDepart) {
		this.volDepart = volDepart;
	}
	
	

	public Set<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
	}

	public Set<Liaisons> getLiaisons() {
		return liaisons;
	}

	public void setLiaisons(Set<Liaisons> liaisons) {
		this.liaisons = liaisons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAeroport == null) ? 0 : idAeroport.hashCode());
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
		Aeroport other = (Aeroport) obj;
		if (idAeroport == null) {
			if (other.idAeroport != null)
				return false;
		} else if (!idAeroport.equals(other.idAeroport))
			return false;
		return true;
	}
	
	
	

}
