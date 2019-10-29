package reservationSpring.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "passager")
@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passager", initialValue = 100, allocationSize = 1)
@NamedQueries({
		@NamedQuery(name = "Passager.findByKeyWithReservation", query = "select p from Passager p left join fetch p.reservation r left join fetch r.vols left join fetch r.client where p.idPassager = :key"),
		@NamedQuery(name = "Passager.findAllWithReservation", query = "select p from Passager p left join fetch p.reservation r left join fetch r.vols left join fetch r.client") })
public class Passager {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@Column(name = "id_passager")
	private Long idPassager;
	@Column(name = "nom_passager", length = 150)
	private String nomPassager;
	@Column(name = "prenom_passager", length = 150)
	private String prenomPassager;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "adresse", column = @Column(name = "adresse_passager", length = 250)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal_passager", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_passager", length = 150)),
			@AttributeOverride(name = "pays", column = @Column(name = "pays_passager", length = 150)) })
	private Adresse adressePassager;
	@Version
	private int version;
	@OneToMany(mappedBy = "passager")
	private Set<Reservation> reservation;

	public Passager() {

	}

	public Long getIdPassager() {
		return idPassager;
	}

	public void setIdPassager(Long idPassager) {
		this.idPassager = idPassager;
	}

	public String getNomPassager() {
		return nomPassager;
	}

	public void setNomPassager(String nomPassager) {
		this.nomPassager = nomPassager;
	}

	public String getPrenomPassager() {
		return prenomPassager;
	}

	public void setPrenomPassager(String prenomPassager) {
		this.prenomPassager = prenomPassager;
	}

	public Adresse getAdressePassager() {
		return adressePassager;
	}

	public void setAdressePassager(Adresse adressePassager) {
		this.adressePassager = adressePassager;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPassager == null) ? 0 : idPassager.hashCode());
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
		Passager other = (Passager) obj;
		if (idPassager == null) {
			if (other.idPassager != null)
				return false;
		} else if (!idPassager.equals(other.idPassager))
			return false;
		return true;
	}

}
