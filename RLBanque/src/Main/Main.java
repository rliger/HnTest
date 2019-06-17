package Main;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import composants.Client;
import composants.Compte;
import composants.CompteCourant;
import composants.CompteEpargne;


public class Main {
	
	private static int compteur=1;
	public static ArrayList<Client> cClients = new ArrayList<Client>();
	public static ArrayList<Compte> cComptes = new ArrayList<Compte>();
	
	public static Hashtable h= new Hashtable();
	
	
	public static void main(String[] args) {

		
		
		collecterClients(4);
		
		afficherClients(cClients);
		
		System.out.println("\n-------------------------------------------------------------\n");
		
		//collecterClients(3);
		
		//afficherClients(cClients);
		
		collecterComptes(cClients);
		
		afficherComptes(cComptes);
		
		creationH(cComptes);
		
		afficherH(h);
	
		/*for(int i = 0; i < cComptes.size(); i++) {
			if (cComptes.get(i).getClient().getNomClient().equals("nom2")) {
				System.out.println(cComptes.get(i));
			}
		}*/
		
		
		
		
		
	}

	
	
	
	
	
	//méthodes Collections et Afficher
	public static void collecterClients(int nombreDeClients) {
		int j = compteur+nombreDeClients;
		for (int i = compteur; i <j; i++) {
			Client c = new Client("nom"+i, "prenom"+i);
			cClients.add(c);
			compteur++;
		}
	}
	
	public static void afficherClients(ArrayList<Client> aL) {
		System.out.println("\n-------------------------------------------------------------\n");
		for(int i = 0; i < aL.size(); i++) {
		    System.out.println(aL.get(i));
		}
		System.out.println("\n-------------------------------------------------------------\n");
		 
	}
	
	public static void collecterComptes(ArrayList<Client> aL) {
		for (int i = 0; i < aL.size(); i++) {
			CompteCourant cC = new CompteCourant(null, (Client)aL.get(i));
			CompteEpargne cE = new CompteEpargne(null, (Client)aL.get(i));
			cComptes.add(cC);
			cComptes.add(cE);
		}
	}
	
	public static void afficherComptes(ArrayList<Compte> aL) {
		System.out.println("\n-------------------------------------------------------------\n");
		for(int i = 0; i < aL.size(); i++) {
		    System.out.println(aL.get(i));
		}
		System.out.println("\n-------------------------------------------------------------\n");
		 
	}
	
	
	
	//méthode création et afficher Hashtable
	public static Hashtable creationH(ArrayList<Compte> aL) {
		for(int i = 0; i < aL.size(); i++) {
			h.put(aL.get(i).getNumCompte(), aL.get(i));
		}
		return h;
	}
	
	public static void afficherH(Hashtable h) {
		Enumeration e = h.elements();
		Enumeration i = h.keys();
	    while(e.hasMoreElements())
	      System.out.println(i.nextElement()+" : "+e.nextElement());
	}
	
}
