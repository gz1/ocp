package de.wbstraining.ocp.lotto;

public class KostenErmittelnDto {
	
	int laufzeit;
	int anzahlTipps;
	boolean isSuper6;
	boolean isSpiel77;
	boolean isMittwoch;
	boolean isSamstag;
	
	public KostenErmittelnDto(int laufzeit, int anzahlTipps,
			boolean isSuper6, boolean isSpiel77, 
			boolean isMittwoch, boolean isSamstag) {
	
		this.laufzeit = laufzeit;
		this.anzahlTipps = anzahlTipps;
		this.isSuper6 = isSuper6;
		this.isSpiel77 = isSpiel77;
	}
	
	// setter und getter weggelassen

}
