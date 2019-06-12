
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bibliotheque michel = new Bibliotheque(7);
		
		Dictionnaire robert = new Dictionnaire(1, "Robert", "français");
		
		Roman coco = new Roman(2, "CoCo", "Jacky", 250, 4.2);
		
		michel.afficherDocuments();
		
		System.out.println("-----------------------------");
		
		michel.ajouter(robert);
		
		coco.auteur= "Mike";
		
		michel.ajouter(coco);
		
		
		
		michel.afficherDocuments();
		
		
		System.out.println("-----------------------------");
		
		michel.supprimer(robert);
		
		michel.afficherDocuments();
		
		michel.afficherAuteurs(coco);

	}

}
