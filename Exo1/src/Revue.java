
public class Revue extends Document {

	private int mois;
	private int année;
	
	public Revue(int numero, String titre, int mois, int année) {
		super(numero, titre);
		this.mois = mois;
		this.année = année;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnée() {
		return année;
	}

	public void setAnnée(int année) {
		this.année = année;
	}

	@Override
	public String toString() {
		return "Revue [numero=" + numero + ", titre=" + titre + ", mois=" + mois + ", année=" + année + "]";
	}
	
	

}
