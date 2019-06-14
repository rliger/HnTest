package Main;

import java.util.ArrayList;
import composants.Client;


public class Main {
	
	private static int compteur=1;
	public static ArrayList<Client> cClients = new ArrayList<Client>();

	
	public static void main(String[] args) {

		
		
		collecter(4);
		
		afficherClients(cClients);
		
		System.out.println("\n-------------------------------------------------------------\n");
		
		collecter(3);
		
		afficherClients(cClients);
		
		
		
		
		
	}

	public static void collecter(int nombreDeClients) {
		int j = compteur+nombreDeClients;
		for (int i = compteur; i <j; i++) {
			Client c = new Client("nom"+i, "prenom"+i);
			cClients.add(c);
			compteur++;
		}
	}
	
	public static void afficherClients(ArrayList aL) {
		System.out.println("\n-------------------------------------------------------------\n");
		for(int i = 0; i < aL.size(); i++) {
		    System.out.println(aL.get(i));
		}
		System.out.println("\n-------------------------------------------------------------\n");
		 
	}
}
