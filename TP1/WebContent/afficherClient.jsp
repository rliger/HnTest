 <%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
 	<head>
        <meta charset="utf-8" />
        <title>Affiche client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
        	<p>
        		${ message }
        	</p>
        	<p>
        		nom : ${ client.nom }<br/>
        		prénom : ${ client.prenom }<br/>
        		adresse de livraison : ${ client.adresseDeLivraison }<br/>
        		Téléphone : ${ client.numeroTel }<br/>
        		Mail : ${ client.adresseMail }<br/>
        	</p>
        </div>
    </body>
</html>