package composants;

public class CompteCourant extends Compte {

	
	public CompteCourant(String libelle, Client client) {
		super(libelle, client);
	}

	@Override
	public String toString() {
		return "CompteCourant [libelle=" + libelle + ", solde=" + solde + ", numCompte=" + numCompte + ", client="
				+ client + "]";
	}
	
	

}
