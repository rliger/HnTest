package Main;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import composants.Client;
import composants.Compte;
import composants.CompteCourant;
import composants.CompteEpargne;
import composants.Flux;
import composants.Credit;
import composants.Debit;
import composants.Virement;


public class Main {
	
	private static int compteur=1;
	public static ArrayList<Client> cClients = new ArrayList<Client>();
	public static ArrayList<Compte> cComptes = new ArrayList<Compte>();
	
	public static Hashtable h= new Hashtable();
	
	public static ArrayList<Flux> cFlux = new ArrayList<Flux>();
	
	
	public static void main(String[] args) {

		
		
		collecterClients(4);
		
		//afficherClients(cClients);
		
		System.out.println("\n-------------------------------------------------------------\n");
		
		//collecterClients(3);
		
		//afficherClients(cClients);
		
		collecterComptes(cClients);
		
		afficherComptes(cComptes);
		
		creationH(cComptes);
		
		//afficherH(h);
		
		collecterFlux();
		
		afficherFlux(cFlux);
		
		//cComptes.get(2).setSolde((Virement)cFlux.get(9));
		
		appliquerFlux(h, cFlux);
		
		afficherComptes(cComptes);
		
		
		
		
		
		
		
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
	
	
	
	//méthodes création et afficher Hashtable
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
	
	
	
	//méthode charger Flux
	public static void collecterFlux() {
		
		Debit d = new Debit("Débit", 50, 1, false);
		cFlux.add(d);
		
		for(int i = 0; i < cComptes.size(); i++) { 
			if(cComptes.get(i).getClass() == CompteCourant.class) {
				Credit c = new Credit("Crédit", 100.50, cComptes.get(i).getNumCompte(), false);
				cFlux.add(c);
			}
		}
			
		for(int i = 0; i < cComptes.size(); i++) { 
				if(cComptes.get(i).getClass() == CompteEpargne.class) {
					Credit c = new Credit("Crédit", 1500, cComptes.get(i).getNumCompte(), false);
					cFlux.add(c);
				}
		}
		
		Virement v = new Virement("Virement", 50, 2, false, 1);
		cFlux.add(v);	
	}
	
	
	
	public static void afficherFlux(ArrayList<Flux> aL) {
		System.out.println("\n-------------------------------------------------------------\n");
		for(int i = 0; i < aL.size(); i++) {
		    System.out.println(aL.get(i));
		}
		System.out.println("\n-------------------------------------------------------------\n");
		 
	}
	
	public static void appliquerFlux(Hashtable h, ArrayList<Flux> aL) {
		for(int i = 0; i < aL.size(); i++) {
			for(int j = 0; j < cComptes.size(); j++) {
				if (h.contains(cComptes.get(j))) {
					if(aL.get(i).getClass()==Virement.class) {
						cComptes.get(j).setSolde((Virement)aL.get(i));
					} else {
						cComptes.get(j).setSolde(aL.get(i));
					}
				}
		    }
		}
	}
}
