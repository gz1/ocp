package de.wbstraining.ocp.enumeration;

// wie PlatonischerKoerper, aber:
// - der enum bekommt 3 felder (ecken, kanten, flaechen)
// - der enum bekommt einen passenden constructor
// - die konstanten bekommen keinen eigenen class body mehr

// in der demo-klasse (PlatonischerKoerper2Demo) geben wir alle platonischen koerper mit ihren
// charakteristischen kenndaten aus

public enum PlatonischerKoerper2 {
	TETRAEDER(4, 4, 6), OKTAEDER(6, 8, 12), HEXAEDER(8, 6, 12),
		IKOSAEDER(12, 20, 30), DODEKAEDER(20, 12, 30);

	private int flaechen;
	private int ecken;
	private int kanten;

	private PlatonischerKoerper2(int flaechen, int ecken, int kanten) {
		this.flaechen = flaechen;
		this.ecken = ecken;
		this.kanten = kanten;
	}

	public int getFlaechen() {
		return flaechen;
	}

	public int getEcken() {
		return ecken;
	}

	public int getKanten() {
		return kanten;
	}

	@Override
	public String toString() {
		return this.name() + " [flaechen=" + flaechen + ", ecken=" + ecken + ", kanten=" + kanten + "]";
	}
}
