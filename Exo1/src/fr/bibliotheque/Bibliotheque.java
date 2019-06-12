package fr.bibliotheque;

public class Bibliotheque {
	
	private int capacite;
	private Document[] biblio;
	
	public Bibliotheque(int capacite) {
		this.capacite = capacite;
		this.biblio = new Document[capacite];
		} 
	
	
	public void afficherDocuments () {
		for (Document doc : biblio) {
			System.out.println(doc);
		}
	}
	
	
	public Document document (int i) {
		return biblio[i];
	}
	
	
	public boolean ajouter(Document doc) {
		for (int i = 0; i<capacite; i++) {
			if(biblio[i]==null) {
				biblio[i]=doc;
				return true;
			}
		}
		return false;
	}
	
	
	public boolean supprimer(Document doc) {
		for (int i = 0; i<capacite; i++) {
			if(biblio[i]==doc) {
				biblio[i]=null;
				return true;
			}
		}
		return false;
	}
	
	
	public void afficherAuteurs(Livre livre) {
		for (int i = 0; i<capacite; i++) {
			if(biblio[i]==livre) {
				System.out.println(livre.getAuteur());
			}
		}
	}
	

}
