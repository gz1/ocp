package de.wbstraining.ocp.lotto;

public class KostenErmittelnDto {
	
	private final Laufzeit laufzeit;
	private final int anzahlTipps;
	private final boolean isSuper6;
	private final boolean isSpiel77;
	private final Teilnahme teilnahme;
		
	public KostenErmittelnDto(Laufzeit laufzeit, int anzahlTipps,
			boolean isSuper6, boolean isSpiel77, 
			Teilnahme teilnahme) {
		
		if(anzahlTipps < 1 || anzahlTipps > 12) {
			throw new IllegalArgumentException("illegal...");
		}
		this.laufzeit = laufzeit;
		this.anzahlTipps = anzahlTipps;
		this.isSuper6 = isSuper6;
		this.isSpiel77 = isSpiel77;
		this.teilnahme = teilnahme;
	}

	public Laufzeit getLaufzeit() {
		return laufzeit;
	}

	public int getAnzahlTipps() {
		return anzahlTipps;
	}

	public boolean isSuper6() {
		return isSuper6;
	}

	public boolean isSpiel77() {
		return isSpiel77;
	}

	public Teilnahme getTeilnahme() {
		return teilnahme;
	}
	
	
}
