package fr.tp1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp1.beans.Client;

public class CreationClient extends HttpServlet {


	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

		String nom = request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String adresse = request.getParameter("adresseClient");
		String telephone = request.getParameter("telephoneClient");
		String email = request.getParameter("emailClient");
		String message = new String();
		
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresseDeLivraison(adresse);
		client.setNumeroTel(telephone);
		client.setAdresseMail(email);
		
		if (nom.isEmpty() || adresse.isEmpty() || telephone.isEmpty()) {
			message = "<h1 class = \"erreur\">Allo Houston, nous avons un problème il manque des coordonnées!!!<h1/>";
		} else {
			message = "<h1 class = \"succes\">Tout est ok!!!</h1>";
		}
		
		request.setAttribute("client", client);
		request.setAttribute("message", message);
		
		
		

		this.getServletContext().getRequestDispatcher( "/afficherClient.jsp" ).forward( request, response );
		

	}
}