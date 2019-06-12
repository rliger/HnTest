
public class Bibliotheque {
	
	private int capacite;
	private Document[] bibliotheque;
	
	public Bibliotheque(int capacite) {
		this.capacite = capacite;
		this.bibliotheque = new Document[capacite];
		} 
	
	
	void afficherDocuments () {
		for (Document doc : bibliotheque) {
			System.out.println(doc);
		}
	}
	
	
	Document document (int i) {
		return bibliotheque[i];
	}
	
	
	boolean ajouter(Document doc) {
		for (int i = 0; i<capacite; i++) {
			if(bibliotheque[i]==null) {
				bibliotheque[i]=doc;
				return true;
			}
		}
		return false;
	}
	
	
	boolean supprimer(Document doc) {
		for (int i = 0; i<capacite; i++) {
			if(bibliotheque[i]==doc) {
				bibliotheque[i]=null;
				return true;
			}
		}
		return false;
	}
	
	
	void afficherAuteurs(Livre livre) {
		for (int i = 0; i<capacite; i++) {
			if(bibliotheque[i]==livre) {
				System.out.println(livre.getAuteur());
			}
		}
	}
	

}
