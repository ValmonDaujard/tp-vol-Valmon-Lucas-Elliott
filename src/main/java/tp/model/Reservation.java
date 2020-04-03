package tp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

	@Entity 
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private Boolean annulee;
	private Boolean confirmee;
	private Boolean ouverte;
	@Column(nullable = false)
	private String numeroDeReservation;
	
	@OneToOne
	@JoinColumn(name="paiement")
	private Paiement paiement;
	
	@ManyToOne
	@JoinColumn(name="client")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="passager")
	private Passager passager;
	
	@OneToOne
	@JoinColumn(name="trajet")
	private Trajet trajet;

	public Reservation() {
		super();
	}

	
	
	public Reservation(Boolean annulee, Boolean confirmee, Boolean ouverte, String numeroDeReservation) {
		super();
		this.annulee = annulee;
		this.confirmee = confirmee;
		this.ouverte = ouverte;
		this.numeroDeReservation = numeroDeReservation;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getAnnulee() {
		return annulee;
	}

	public void setAnnulee(Boolean annulee) {
		this.annulee = annulee;
	}

	public Boolean getConfirmee() {
		return confirmee;
	}

	public void setConfirmee(Boolean confirmee) {
		this.confirmee = confirmee;
	}

	public Boolean getOuverte() {
		return ouverte;
	}

	public void setOuverte(Boolean ouverte) {
		this.ouverte = ouverte;
	}

	public String getNumeroDeReservation() {
		return numeroDeReservation;
	}

	public void setNumeroDeReservation(String numeroDeReservation) {
		this.numeroDeReservation = numeroDeReservation;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	@Override
	public String toString() {
		return "Reservation [annulee=" + annulee + ", confirmee=" + confirmee + ", ouverte=" + ouverte
				+ ", numeroDeReservation=" + numeroDeReservation + ", paiement=" + paiement + ", passager=" + passager
				+ ", trajet=" + trajet + "]";
	}

}
