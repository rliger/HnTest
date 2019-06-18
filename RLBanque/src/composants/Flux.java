package composants;

import java.util.Date;

public abstract class Flux {
	
	protected String com;
	protected int id;
	protected double mont;
	protected int numCompte;
	protected boolean effectue;
	protected Date date;
	protected static int compteur=1;
	
	
	public Flux(String com, double mont, int numCompte, boolean effectue) {
		this.com = com;
		this.id = compteur;
		this.mont = mont;
		this.numCompte = numCompte;
		this.effectue = effectue;
		this.date = new Date();
		compteur++;
	}

	
	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMont() {
		return mont;
	}

	public void setMont(double mont) {
		this.mont = mont;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public boolean isEffectue() {
		return effectue;
	}

	public void setEffectue(boolean effectue) {
		this.effectue = effectue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Flux [com=" + com + ", id=" + id + ", mont=" + mont + ", numCompte=" + numCompte + ", effectue="
				+ effectue + ", date=" + date + "]";
	}
	
	
	
}
