
public class Dictionnaire extends Document {
	
	private String langue;

	public Dictionnaire(int numero, String titre, String langue) {
		super(numero, titre);
		this.langue = langue;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	@Override
	public String toString() {
		return "Dictionnaire [langue=" + langue + ", numero=" + numero + ", titre=" + titre + "]";
	}
	
	

}
