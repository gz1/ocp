package de.wbstraining.ocp.comparator;

class TestZentrum {
	String ort;
	double x;
	double y;

	public TestZentrum(String ort, double x, double y) {
		this.ort = ort;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return ort + "(" + x + "," + y + ")";
	}

}

class TestKandidat {
	String name;
	double x;
	double y;

	public TestKandidat(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return name + "(" + x + "," + y + ")";
	}

}

public class OCAAnmeldungDemo {

	// wir erzeugen einige testzentren (zufallswerte für x- koordinate und y-
	// koordinate).
	// wir erzeugen einige testkandidaten (zufallswerte für x- koordinate und y-
	// koordinate).

	// dann listen wir für jeden testkandidaten alle testzentren auf,
	// und zwar aufsteigend sortiert nach dem abstand vom testkandidaten.

	public static void main(String[] args) {

		
	}
}
