package fr.bibliotheque;

public class Roman extends Livre {
	
	private Double prixLit;

	public Roman(int numero, String titre, String auteur, int pages, Double prixLit) {
		super(numero, titre, auteur, pages);
		this.prixLit = prixLit;
	}

	public Double getPrixLit() {
		return prixLit;
	}

	public void setPrixLit(Double prixLit) {
		this.prixLit = prixLit;
	}

	@Override
	public String toString() {
		return super.toString()+", Roman [prixLit=" + prixLit + "]";
	}

	
}
