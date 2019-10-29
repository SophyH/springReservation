package reservationSpring.model;

public enum Titre {
	M("monsieur"), MME("madame"), MLLE("madememoiselle"), SA("Société Anonyme"), SARL("Société à responsabilite limitée"), ;
	
	private String label;
	
	private Titre(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
