package reservationSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="login")
@SequenceGenerator(name= "seqLogin", sequenceName="seq_login", initialValue =100, allocationSize =1)  
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqLogin")
	@Column(name="id_login")
	private Long id;
	@Column(name="nom_login", length=150)
	private String login;
	@Column(name="mot_de_passe", length=150)
	private String motdepasse;
	@Column(name="administrateur")
	private Boolean admin;
	
	@OneToOne(mappedBy = "login")
	private Client client;
	
	@Version 
	private int version; 
	
	public Login() {
		
	}


	public Login(Long id) {
		super();
		this.id = id;
	}


	public Login(Long id, String login) {
		super();
		this.id = id;
		this.login = login;
	}


	public Login(Long id, String login, String motdepasse) {
		super();
		this.id = id;
		this.login = login;
		this.motdepasse = motdepasse;
	}


	public Login(Long id, String login, String motdepasse, Boolean admin) {
		super();
		this.id = id;
		this.login = login;
		this.motdepasse = motdepasse;
		this.admin = admin;
	}


	public Login(Long id, String login, String motdepasse, Boolean admin, Client client, int version) {
		super();
		this.id = id;
		this.login = login;
		this.motdepasse = motdepasse;
		this.admin = admin;
		this.client = client;
		this.version = version;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMotdepasse() {
		return motdepasse;
	}


	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}


	public Boolean getAdmin() {
		return admin;
	}


	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	
	
	
}
