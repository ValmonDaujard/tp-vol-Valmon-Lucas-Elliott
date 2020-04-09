package tp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Depart {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "aeroport_id")
	private Aeroport aeroport;
	
	@Column
	private Date dateDepart;
	
	@OneToOne(mappedBy = "depart")
	private Vol vol;

	public Depart() {
		super();
	}


	public Depart( Date dateDepart) {
		super();
		this.dateDepart = dateDepart;
	}


	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	@Override
	public String toString() {
		return "Depart [aeroport=" + aeroport + ", dateDepart=" + dateDepart + "]";
	}

}
