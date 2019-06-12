
public class Manuel extends Livre {
	
	private int niveau;

	public Manuel(int numero, String titre, String auteur, int pages, int niveau) {
		super(numero, titre, auteur, pages);
		this.niveau = niveau;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return super.toString()+", Manuel [niveau=" + niveau + "]";
	}
	
}
