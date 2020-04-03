package tp.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("Particulier")
public class Particulier extends Client {
	private String prenom;

	public Particulier() {
		super();
	}

	public Particulier(String mail) {
		super(mail);
	}
	
	public Particulier(String type, String nom, String prenom , String mail, String telephone, int numeroAdresse, String rue,
			String complementAdresse, int codePostal, String ville, String pays) {
		super(type, nom, mail, telephone, numeroAdresse, rue, complementAdresse, codePostal, ville, pays);
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Particulier [prenom=" + prenom + super.toString() + "]";
	}

}
