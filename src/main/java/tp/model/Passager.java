package tp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Passager {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false)
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String nationalite;
	private String sexe;
	@Column(nullable = false)
	private String numeroPasseport;
	@Column(nullable = false)
	private Date dateValiditePasseport;
	private String typePieceIdentite;
	private Boolean handicap;
	@OneToMany(mappedBy="passager")
	private List<Reservation> reservations = new ArrayList<Reservation>();
//	@ManyToOne
//	@JoinColumn(name="client")
	@Transient
	private Client client;

	
	
	
	public Passager() {
	super();
}


	public Passager(String nom, String numeroPasseport, Date dateValiditePasseport) {
		super();
		this.nom = nom;
		this.numeroPasseport = numeroPasseport;
		this.dateValiditePasseport = dateValiditePasseport;
	}


	public Passager(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	
	public Long getId() {
		return id;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNumeroPasseport() {
		return numeroPasseport;
	}

	public void setNumeroPasseport(String numeroPasseport) {
		this.numeroPasseport = numeroPasseport;
	}

	public Date getDateValiditePasseport() {
		return dateValiditePasseport;
	}

	public void setDateValiditePasseport(Date dateValiditePasseport) {
		this.dateValiditePasseport = dateValiditePasseport;
	}

	public String getTypePieceIdentite() {
		return typePieceIdentite;
	}

	public void setTypePieceIdentite(String typePieceIdentite) {
		this.typePieceIdentite = typePieceIdentite;
	}

	public Boolean getHandicap() {
		return handicap;
	}

	public void setHandicap(Boolean handicap) {
		this.handicap = handicap;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}

	@Override
	public String toString() {
		return "Passager [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + ", nationalite="
				+ nationalite + ", sexe=" + sexe + ", numeroPasseport=" + numeroPasseport + ", dateValiditePasseport="
				+ dateValiditePasseport + ", typePieceIdentite=" + typePieceIdentite + ", handicap=" + handicap + "]";
	}

}
