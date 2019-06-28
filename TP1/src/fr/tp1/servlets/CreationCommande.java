package fr.tp1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import fr.tp1.beans.Client;
import fr.tp1.beans.Commande;

public class CreationCommande extends HttpServlet {


	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		String nom = request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String adresse = request.getParameter("adresseClient");
		String telephone = request.getParameter("telephoneClient");
		String email = request.getParameter("emailClient");
		
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresseDeLivraison(adresse);
		client.setNumeroTel(telephone);
		client.setAdresseMail(email);
		
		DateTime dt = new DateTime();
		String dateCommande = dt.getDayOfMonth()+"/"+dt.getMonthOfYear()+"/"+dt.getYear();
		String montantCommande = request.getParameter("montantCommande");
		String modePaiementCommande = request.getParameter("modePaiementCommande");
		String statutPaiementCommande = request.getParameter("statutPaiementCommande");
		String modeLivraisonCommande = request.getParameter("modeLivraisonCommande");
		String statutLivraisonCommande = request.getParameter("statutLivraisonCommande");
		
		Commande commande = new Commande();
		commande.setClient(client);
		commande.setDateCommande(dateCommande);
		commande.setMontantCommande(montantCommande);
		commande.setModePaiement(modePaiementCommande);
		commande.setStatutPaiement(statutPaiementCommande);
		commande.setModeLivraison(modeLivraisonCommande);
		commande.setStatutLivraison(statutLivraisonCommande);
		
		String message = new String();
		
		if (nom.isEmpty() || adresse.isEmpty() || telephone.isEmpty() || montantCommande.isEmpty()
				|| modePaiementCommande.isEmpty() || modeLivraisonCommande.isEmpty()) {
			message = "<h1 class = \"erreur\">Allo Houston, nous avons un problème il manque des coordonnées!!!<h1/>";
		} else {
			message = "<h1 class = \"succes\">Tout est ok!!!</h1>";
		}
		
		request.setAttribute("commande", commande);
		request.setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher( "/afficherCommande.jsp" ).forward( request, response );

	}
}
