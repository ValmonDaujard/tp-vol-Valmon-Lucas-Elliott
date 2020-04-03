package tp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="disc")
public class Client {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false)
	private String type;
	private String nom;
	@Column(nullable = false)
	private String mail;
	private String telephone;
	private int numeroAdresse;
	private String rue;
	private String complementAdresse;
	private int codePostal;
	private String ville;
	private String pays;
	@OneToOne
	@JoinColumn(name = "user_id")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "client")
	private List<Passager> passagers = new ArrayList<Passager>();
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations = new ArrayList<Reservation>();

	public Client() {
		super();
	}

	public Client(String type, String nom, String mail, String telephone, int numeroAdresse, String rue,
			String complementAdresse, int codePostal, String ville, String pays) {
		super();
		this.type = type;
		this.nom = nom;
		this.mail = mail;
		this.telephone = telephone;
		this.numeroAdresse = numeroAdresse;
		this.rue = rue;
		this.complementAdresse = complementAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public List<Passager> getPassagers() {
		return passagers;
	}

	public void setPassagers(ArrayList<Passager> passagers) {
		this.passagers = passagers;
	}
	
	public void addPassager(Passager passager) {
		this.passagers.add(passager);
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}

	public Client(String mail) {
		super();
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getNumeroAdresse() {
		return numeroAdresse;
	}

	public void setNumeroAdresse(int numeroAdresse) {
		this.numeroAdresse = numeroAdresse;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Client [type=" + type + ", nom=" + nom + ", mail=" + mail + ", telephone=" + telephone
				+ ", numeroAdresse=" + numeroAdresse + ", rue=" + rue + ", complementAdresse=" + complementAdresse
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + ", passagers=" + passagers
				+ ", reservations=" + reservations + "]";
	}

}
