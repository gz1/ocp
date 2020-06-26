package de.wbstraining.ocp.lotto;

// 

public enum Laufzeit {
	
	EINE_WOCHE(1), ZWEI_WOCHEN(2), DREI_WOCHEN(3), VIER_WOCHEN(4), FUENF_WOCHEN(5),
	ACHT_WOCHEN(8);
	
	private int anzahl;
	
	Laufzeit(int anzahl) {
		this.anzahl = anzahl;
	}

	public int getAnzahl() {
		return anzahl;
	}
}
