package reservationSpring.model;

public enum Titre {
	M("monsieur"), MME("madame"), MLLE("madememoiselle"), SA("Soci�t� Anonyme"), SARL("Soci�t� � responsabilite limit�e"), ;
	
	private String label;
	
	private Titre(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
