package composants;

import java.util.Date;

public class Virement extends Flux {
	
	protected int numCompteEm;

	public Virement(String com, double mont, int numCompte, boolean effectue, int numCompteEm) {
		super(com, mont, numCompte, effectue);
		this.numCompteEm = numCompteEm;
	}

	public int getNumCompteEm() {
		return numCompteEm;
	}

	public void setNumCompteEm(int numCompteEm) {
		this.numCompteEm = numCompteEm;
	}

	@Override
	public String toString() {
		return "Flux [com=" + com + ", id=" + id + ", mont=" + mont
				+ ", numCompte=" + numCompte + ", effectue=" + effectue + ", date=" + date + ", numCompteEm=" + numCompteEm + "]";
	}
	
	
	
}
