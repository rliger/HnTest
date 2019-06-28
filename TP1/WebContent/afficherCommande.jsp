 <%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
 	<head>
        <meta charset="utf-8" />
        <title>Affiche commande</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
        	<p>
        		${ message }
        	</p>
        	<p>
        		Nom Client : ${ commande.client.nom }<br/>
        		Prénom Client : ${ commande.client.prenom }<br/>
        		Adresse Client : ${ commande.client.adresseDeLivraison }<br/>
        		Numéro de téléphone Client : ${ commande.client.numeroTel }<br/>
       			Email Client : ${ commande.client.adresseMail }
       		</p>
       		<h2>
        		Commande : 
        	</h2>
        	<p>
        		Date  : ${ commande.dateCommande }<br/>
        		Montant  : ${ commande.montantCommande }<br/>
      			Mode de paiement  : ${ commande.modePaiement }<br/>
        		Statut du paiement  : ${ commande.statutPaiement }<br/>
        		Mode de livraison  : ${ commande.modeLivraison }<br/>
        		Statut de la livraison  : ${ commande.statutLivraison }<br/>
        	</p>
        </div>
    </body>
</html>