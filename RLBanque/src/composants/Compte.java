package composants;

public abstract class Compte {
	
	protected String libelle;
	protected double solde;
	protected int numCompte;
	protected Client client;
	protected static int compteur=1;
	
	
	public Compte(String libelle, Client client) {
		this.libelle = libelle;
		this.client = client;
		this.numCompte = this.compteur;	
		compteur ++;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [libelle=" + libelle + ", solde=" + solde + ", numCompte=" + numCompte + ", client=" + client
				+ "]";
	}
	
	

}
