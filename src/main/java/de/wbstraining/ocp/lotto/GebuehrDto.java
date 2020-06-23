package de.wbstraining.ocp.lotto;

public class GebuehrDto {
	
	int grundGebuehr;
	int einsatzProTipp;
	int einsatzSpiel77;
	int einsatzSuper6;
	
	public GebuehrDto(int grundGebuehr, int einsatzProTipp,
			int einsatzSpiel77,	int einsatzSuper6) {
		super();
		this.grundGebuehr = grundGebuehr;
		this.einsatzProTipp = einsatzProTipp;
		this.einsatzSpiel77 = einsatzSpiel77;
		this.einsatzSuper6 = einsatzSuper6;
	}
	
	// setter und getter weggelassen

}
