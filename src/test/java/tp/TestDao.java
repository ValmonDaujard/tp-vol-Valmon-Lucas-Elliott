package tp;

import tp.model.Particulier;
import tp.model.Societe;
import tp.model.Utilisateur;

public class TestDao {
	public static void main(String[] args) {
		Societe sopraSteria = new Societe("Societe", "SOPRA",  "Numero de siret", "Numero de TVA", "SopraMail", "Tel Sopra", 20, "Avenue Pythagore", null, 33700,
				"MERIGNAC", "FRANCE");

		Particulier eric = new Particulier("Particulier", "SULTAN", "Eric", "e.sultan@ajc-ingenierie.fr", "0645104506", 86, "Avenue JFK", null, 33700,
				"MERIGNAC", "FRANCE");
		
		sopraSteria = Application.getInstance().getSocieteDao().save(sopraSteria);
		eric = Application.getInstance().getParticulierDao().save(eric);

		System.out.println(sopraSteria);
		System.out.println(eric);

		Utilisateur userSopra = new Utilisateur("id SOPRA", "mdp");
		Utilisateur userEric = new Utilisateur("id Eric", "MDP");

		userSopra = Application.getInstance().getUtilisateurDao().save(userSopra);
		userEric = Application.getInstance().getUtilisateurDao().save(userEric);
		
		sopraSteria.setUtilisateur(userSopra);
		userSopra.setClient(sopraSteria);
		eric.setUtilisateur(userEric);
		userEric.setClient(eric);
		
		sopraSteria = Application.getInstance().getSocieteDao().save(sopraSteria);
		userSopra = Application.getInstance().getUtilisateurDao().save(userSopra);
		eric = Application.getInstance().getParticulierDao().save(eric);
		userEric = Application.getInstance().getUtilisateurDao().save(userEric);

	}
}