package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import composants.Client;
import composants.Compte;
import composants.CompteCourant;
import composants.CompteEpargne;
import composants.Flux;
import composants.Credit;
import composants.Debit;
import composants.Virement;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




public class Main {
	
	private static int compteur=1;
	static ArrayList<Client> cClients = new ArrayList<Client>();
	static ArrayList<Compte> cComptes = new ArrayList<Compte>();
	
	static Hashtable h= new Hashtable();
	
	static ArrayList<Flux> cFlux = new ArrayList<Flux>();
	
	static FileInputStream json = null;
	
	
	public static void main(String[] args) {

		
		
		collecterClients(4);
		
		afficherClients(cClients);
		
		
		
		
		//collecterComptes(cClients);
		
		chargerXml();
		
		afficherComptes(cComptes);
		
		creationH(cComptes);
		
		//afficherH(h);
		
		//collecterFlux();
		
		//chargerJson();
		
		//afficherFlux(cFlux);
		
		
		//appliquerFlux(h, cFlux);
		
		afficherComptes(cComptes);
		
		
		
		
		
		
		
		/*for(int i = 0; i < cComptes.size(); i++) {
			if (cComptes.get(i).getClient().getNomClient().equals("nom2")) {
				LOGGER.info(cComptes.get(i));
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
		LOGGER.info("\n-------------------------------------------------------------\n");
		for(int i = 0; i < aL.size(); i++) {
		    LOGGER.info(aL.get(i).toString());
		}
		LOGGER.info("\n-------------------------------------------------------------\n");
		 
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
		LOGGER.info("\n-------------------------------------------------------------\n");
		for(int i = 0; i < aL.size(); i++) {
		    LOGGER.info(aL.get(i).toString());
		}
		LOGGER.info("\n-------------------------------------------------------------\n");
		 
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
	      LOGGER.info(i.nextElement()+" : "+e.nextElement());
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
		LOGGER.info("\n-------------------------------------------------------------\n");
		for(int i = 0; i < aL.size(); i++) {
		    	LOGGER.info(aL.get(i).toString());
		}
		LOGGER.info("\n-------------------------------------------------------------\n");
		 
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
	
	//méthode pour Charger un JSON
	public static void chargerJson() {
		JSONParser jsonParser = new JSONParser();
		Path path = Paths.get("Flux.json");

        try {
            
        	BufferedReader json = Files.newBufferedReader(path);
        	Object obj = jsonParser.parse(json);
        	
        	JSONArray fluxTab = (JSONArray) obj;
            
            for (int i=0; i<fluxTab.size(); i++) {
                       
            	JSONObject fluxObj = (JSONObject) fluxTab.get(i);
                String com = (String) fluxObj.get("com");                      
                   
                if(com.indexOf("débit")>=0) {
                           
                	Debit d =new Debit((String) fluxObj.get("com"),Double.parseDouble((String)fluxObj.get("mont")),(int)(long) fluxObj.get("numCompte"),false);
                    cFlux.add(d);
                   
                } else if (com.indexOf("crédit")>=0){
                	
                	Credit c =new Credit((String) fluxObj.get("com"),Double.parseDouble((String)fluxObj.get("mont")),(int)(long) fluxObj.get("numCompte"),false);
                    cFlux.add(c);
              
                } else if (com.indexOf("virement")>=0) {
                	
                	Virement v =new Virement((String) fluxObj.get("com"),Double.parseDouble((String)fluxObj.get("mont")),(int)(long) fluxObj.get("numCompte"),false, (int)(long) fluxObj.get("numCompteEm"));
                    cFlux.add(v);
                }       
                   
            }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	
	
	//méthode pour Charger un XML
	public static void chargerXml() {
		 try {

				File fXmlFile = new File("Comptes.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
						
				
				doc.getDocumentElement().normalize();

				LOGGER.info("Root element :" + doc.getDocumentElement().getNodeName());
						
				NodeList listeCc = doc.getElementsByTagName("CompteCourant");
				NodeList listeCe = doc.getElementsByTagName("CompteEpargne");
				
				for (int i=0; i<listeCc.getLength();i++) {
					
					Node cC = listeCc.item(i);
					Element e = (Element) cC;
					LOGGER.info(e.getElementsByTagName("nomClient").item(0).getTextContent());
					Client client = new Client(e.getElementsByTagName("nomClient").item(0).getTextContent(), e.getElementsByTagName("prenomClient").item(0).getTextContent());
					CompteCourant c = new CompteCourant(e.getElementsByTagName("libelle").item(0).getTextContent(), client);
					if (e.getElementsByTagName("solde").item(0).getTextContent()!="") {
						Credit f = new Credit(null, Double.parseDouble((String)e.getElementsByTagName("solde").item(0).getTextContent()), c.getNumCompte(), false);
						c.setSolde(f);
					}
					cComptes.add(c);
					
					
				}

				for (int i=0; i<listeCe.getLength();i++) {
					
					Node cE = listeCe.item(i);
					Element e = (Element) cE;
					LOGGER.info(e.getElementsByTagName("nomClient").item(0).getTextContent());
					Client client = new Client(e.getElementsByTagName("nomClient").item(0).getTextContent(), e.getElementsByTagName("prenomClient").item(0).getTextContent());
					CompteEpargne c = new CompteEpargne(e.getElementsByTagName("libelle").item(0).getTextContent(), client);
					if (e.getElementsByTagName("solde").item(0).getTextContent()!=("")) {
						Credit f = new Credit(null, Double.parseDouble((String)e.getElementsByTagName("solde").item(0).getTextContent()), c.getNumCompte(), false);
						c.setSolde(f);
					}
					cComptes.add(c);
					
					
				}		
			
			    } catch (Exception e) {
				e.printStackTra)ce();
			    }
	}
	
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
}
