package reservationSpring.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import reservationSpring.model.Adresse;

@Entity
@Table(name="client")
@SequenceGenerator(name= "seqClient", sequenceName="seq_client", initialValue =100, allocationSize =1)  
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_client", discriminatorType = DiscriminatorType.STRING, length=2)
@NamedQueries({
	@NamedQuery(name="Client.findByKeyWithReservations", query = "select c from Client c left join fetch c.reservations where c.id = :key"),
	@NamedQuery(name="Client.findAllWithReservations", query = "select c from Client c left join fetch c.reservations")
})
public abstract class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqClient")
	private Long id;
	@Column(name="nom_client", length=150)
	private String nom;
	@Column(name="numero_tel_client", length=10)
	private String numeroTel;
	@Column(name="numero_fax_client")
	private String numeroFax;
	@Column(name="email_client", length=150)
	private String email;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="adresse", column = @Column(name="adresse_client")),
		@AttributeOverride(name="codePostal", column = @Column(name="code_postal_client", length=5)),
		@AttributeOverride(name="ville", column= @Column(name="ville_client", length = 200)),
		@AttributeOverride(name="pays", column = @Column(name="pays_client", length=255)),

	})  
	private Adresse adresse;
	
	@OneToMany(mappedBy ="client")
	private Set<Reservation> reservations;
	
	@Version 
	private int version; 
	
	@OneToOne
	@JoinColumn(name = "login_id_client", foreignKey = @ForeignKey(name="login_id_client_fk"))
	private Login login;
	
	
	
	public Client() {
		
	}



	public Client(Long id, String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Set<Reservation> reservations, int version, Login login) {
		super();
		this.id = id;
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
		this.adresse = adresse;
		this.reservations = reservations;
		this.version = version;
		this.login = login;
	}



	public Client(Long id) {
		super();
		this.id = id;
	}



	public Client(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}



	public Client(Long id, String nom, String email) {
		super();
		id = id;
		this.nom = nom;
		this.email = email;
	}



	public Client(Long id, String nom, String numeroTel, String numeroFax, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
	}



	public Long getId() {
		return this.id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getNumeroTel() {
		return numeroTel;
	}



	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}



	public String getNumeroFax() {
		return numeroFax;
	}



	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	
	public Set<Reservation> getReservations() {
		return reservations;
	}



	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}



	public Login getLogin() {
		return login;
	}



	public void setLogin(Login login) {
		this.login = login;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}