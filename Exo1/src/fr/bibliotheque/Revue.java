package fr.bibliotheque;
public class Revue extends Document {

	private int mois;

	
	public Revue(int numero, String titre, int mois, int annee) {
		super(numero, titre);
		this.mois = mois;
		this.annee = annee;
	}
	
	private int annee;

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public String toString() {
		return "Revue [numero=" + numero + ", titre=" + titre + ", mois=" + mois + ", année=" + annee + "]";
	}
	
	

}
