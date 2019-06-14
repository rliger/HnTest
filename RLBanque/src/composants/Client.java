// 1.1.1 Création de la classe client

package composants;

public class Client {
	
	private String nomClient;
	private String prenomClient;
	public int numClient;
	private static int compteur=1;
	
	
	public Client(String nomClient, String prenomClient) {
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.numClient = compteur;
		compteur ++;
	}

	
	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}


	@Override
	public String toString() {
		return "Client ["+ nomClient + "," + prenomClient + ", numClient=" + numClient + "]";
	}
	
	
	

}
