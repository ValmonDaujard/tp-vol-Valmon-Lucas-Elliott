package tp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Societe")
public class Societe extends Client {
	private String siret;
	private String numeroDeTva;

	public Societe() {
		super();
	}
	public Societe(String type, String nom, String siret, String numeroDeTva, String mail, String telephone, int numeroAdresse, String rue,
			String complementAdresse, int codePostal, String ville, String pays) {
		super(type, nom, mail, telephone, numeroAdresse, rue, complementAdresse, codePostal, ville, pays);
		this.siret = siret;
		this.numeroDeTva = numeroDeTva;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getNumeroDeTva() {
		return numeroDeTva;
	}

	public void setNumeroDeTva(String numeroDeTva) {
		this.numeroDeTva = numeroDeTva;
	}

	@Override
	public String toString() {
		return "Societe [siret=" + siret + ", numeroDeTva=" + numeroDeTva + super.toString() + "]";
	}

}
