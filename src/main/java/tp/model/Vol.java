package tp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Vol {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	
	@Column
	private String numeroDeVol;
	
	@Column
	private Boolean ouvert;
	
	@OneToOne
	private Depart depart;
	@OneToOne
	private Arrivee arrivee;
	
	@ManyToOne
	private Avion avion;
	
	@ManyToOne
	private Compagnie compagnie;
	
	@Transient
	private List<Trajet> trajets = new ArrayList<Trajet>();
	
	

	public Vol() {
		super();
	}

	public Vol(String numeroDeVol) {
		super();
		this.numeroDeVol = numeroDeVol;
	}

	public String getNumeroDeVol() {
		return numeroDeVol;
	}

	public void setNumeroDeVol(String numeroDeVol) {
		this.numeroDeVol = numeroDeVol;
	}

	public Boolean getOuvert() {
		return ouvert;
	}

	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	public Arrivee getArrivee() {
		return arrivee;
	}

	public void setArrivee(Arrivee arrivee) {
		this.arrivee = arrivee;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	@Override
	public String toString() {
		return "Vol [numeroDeVol=" + numeroDeVol + ", ouvert=" + ouvert + ", depart=" + depart + ", arrivee=" + arrivee
				+ ", avion=" + avion + ", compagnie=" + compagnie + "]";
	}

}
