// 1.1.1 Création de la classe client

package composants;

public class Client {
	
	private String nomClient;
	private String prenomClient;
	private int numClient;
	
	
	public Client(String nomClient, String prenomClient, int numClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.numClient = numClient;
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
		return "Client [nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", numClient=" + numClient + "]";
	}
	
	
	

}
