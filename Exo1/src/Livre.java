
public abstract class Livre extends Document {
	
	protected String auteur;
	protected int pages;
	
	public Livre(int numero, String titre, String auteur, int pages) {
		super(numero, titre);
		this.auteur = auteur;
		this.pages = pages;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return super.toString()+", Livre [auteur=" + auteur + ", pages=" + pages + "]";
	}

	

	
	
	
	
}
