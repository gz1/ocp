package de.wbstraining.ocp.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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

	
		

	public static double abstand(TestKandidat tk, TestZentrum tz) {
		double abstand = Math.sqrt((tk.x - tz.x) * (tk.x - tz.x)
				+ (tk.y - tz.y) * (tk.y - tz.y));
		return abstand;
	}

	public static void sortZentren(TestKandidat tk, List<TestZentrum> zentren) {
		Comparator<TestZentrum> cmp = 
				(tz1, tz2) -> Double.compare(abstand(tk, tz1), abstand(tk, tz2));
		Collections.sort(zentren, cmp);
	}

	public static void main(String[] args) {
			
		Random rnd = new Random();
		
		List<TestZentrum> zentren = new ArrayList<>();
		for (String zentrum : Arrays.asList("za", "zb", "zc", "zd", "ze", "zf", "zg")) {
			zentren.add(new TestZentrum(zentrum, rnd.nextInt(100), rnd.nextInt(100)));
		}
		
		List<TestKandidat> kandidaten = new ArrayList<>();
		for (String kandidat : Arrays.asList("ka", "kb", "kc", "kd")) {
			kandidaten.add(new TestKandidat(kandidat, rnd.nextInt(100),rnd.nextInt(100)));
		}
		
		for (TestKandidat kandidat : kandidaten) {
			sortZentren(kandidat, zentren);
			System.out.println(kandidat);
			for(TestZentrum zentrum : zentren) {
				System.out.println("  " + zentrum + " -> " + abstand(kandidat, zentrum));
			}
			System.out.println("----------");
		}
	}
}
