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
		this.solde = 0;
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

	public void setSolde(Flux f) {
		if (f.getClass() == Credit.class && this.getNumCompte()==f.getNumCompte()) {
			this.solde = this.getSolde() + f.getMont();
		} else if (f.getClass() == Debit.class && this.getNumCompte()==f.getNumCompte()) {
			this.solde = this.getSolde() - f.getMont();
		} 
	}
	
	public void setSolde(Virement v) {
			if (this.getNumCompte() == v.getNumCompte()) {
				this.solde = this.getSolde() + v.getMont();
			} else if (this.getNumCompte() == v.getNumCompteEm()) {
				this.solde = this.getSolde() - v.getMont();
			}
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
