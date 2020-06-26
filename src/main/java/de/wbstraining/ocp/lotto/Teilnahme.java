package de.wbstraining.ocp.lotto;

public enum Teilnahme {
	
	MITTWOCH(1), SAMSTAG(1), MITTWOCH_UND_SAMSTAG(2);
	
	private int faktor;

	private Teilnahme(int faktor) {
		this.faktor = faktor;
	}

	public int getFaktor() {
		return faktor;
	}
}
