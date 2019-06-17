package composants;

public class CompteEpargne extends Compte {

	
	public CompteEpargne(String libelle, Client client) {
		super(libelle, client);
	}

	@Override
	public String toString() {
		return "CompteEpargne [libelle=" + libelle + ", solde=" + solde + ", numCompte=" + numCompte + ", client="
				+ client + "]";
	}
	
	
	
}
