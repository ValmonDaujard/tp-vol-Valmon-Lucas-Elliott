package tp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Trajet {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@OneToOne(mappedBy = "trajet")
	private Reservation reservation;
	@ManyToMany(mappedBy = "trajets")
	private List<Vol> vols = new ArrayList<Vol>();

	public Trajet() {
		super();
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	public void addVol(Vol vols) {
		this.vols.add(vols);
	}

	@Override
	public String toString() {
		return "Trajet [vols=" + vols + "]";
	}

}
