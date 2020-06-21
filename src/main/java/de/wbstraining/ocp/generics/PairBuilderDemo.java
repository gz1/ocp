package de.wbstraining.ocp.generics;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.ToDoubleFunction;

class Stellenangebot {
	int gebotenesGehalt;

	public Stellenangebot(int gebotenesGehalt) {
		this.gebotenesGehalt = gebotenesGehalt;
	}

	@Override
	public String toString() {
		return "Stellenangebot [gebotenesGehalt=" + gebotenesGehalt + "]";
	}

}

class Stellensuchender {
	int wunschGehalt;

	public Stellensuchender(int wunschGehalt) {
		this.wunschGehalt = wunschGehalt;
	}

	@Override
	public String toString() {
		return "StellenSuchender [wunschGehalt=" + wunschGehalt + "]";
	}
}

// wir erzeugen einige stellenangebote und stellensuchende.
// dann ermitteln wir, welche angebote zu welchenden suchenden passen.
// wir nehmen an, das 2 zueinander passen, wenn die differenz zwischen
// gebotenesGehalt und wunschGehalt < 5000.

public class PairBuilderDemo {

	public static void main(String[] args) {
		// wir erzeugen sets für die angebote und die suchenden
		Set<Stellenangebot> angebote = new HashSet<>();
		Set<Stellensuchender> suchende = new HashSet<>();
		Random random = new Random();
		int randomGehalt;
		Stellenangebot angebot;
		Stellensuchender suchender;
		BiPredicate<Stellenangebot, Stellensuchender> biPredicate;
		Set<Pair<Stellenangebot,Stellensuchender>> pairs;
		// wir erzeugen 10 angebote mit einem gebotenen gehalt zwischen
		// 30000 und 70000, am besten mit einer schleife und geeignet
		// generierten zufallszahlen (s. java.util.Random). diese angebote
		// fügen wir in das set angebote ein.
		for (int i = 0; i < 10; i++) {
			randomGehalt = 30000 + random.nextInt(40000);
			angebot = new Stellenangebot(randomGehalt);
			angebote.add(angebot);
		}
		// wir prüfen, ob das set angebote richtig bestückt wurde.
		System.out.println(angebote);

		// wir erzeugen 10 suchende mit einem wunschgehalt zwischen
		// 30000 und 70000, am besten mit einer schleife und geeignet
		// generierten zufallszahlen (s. java.util.Random). diese suchenden
		// fügen wir in das set suchende ein.
		for (int i = 0; i < 10; i++) {
			randomGehalt = 30000 + random.nextInt(40000);
			suchender = new Stellensuchender(randomGehalt);
			suchende.add(suchender);
		}
		// wir prüfen, ob das set suchende richtig bestückt wurde.
		System.out.println(suchende);
		
		biPredicate = (Stellenangebot a, Stellensuchender s) -> {
			int diff = Math.abs(a.gebotenesGehalt - s.wunschGehalt);
			return diff < 5000;
		};
		
		
		pairs = SetUtil.pairBuilder(angebote, suchende, biPredicate);
		System.out.println("anzahl gefundener matches: " + pairs.size());
		pairs.forEach(p -> System.out.println(p));
		
		System.out.println("--------------");
		ToDoubleFunction<Stellenangebot> geboten = a -> a.gebotenesGehalt;
		ToDoubleFunction<Stellensuchender> gewuenscht = s -> s.wunschGehalt;
		System.out.println("durchschnitt aller angebotenen gehälter: " +
				SetUtil.average(angebote, geboten));
		System.out.println("durchschnitt aller wunschgehälter: " +
				SetUtil.average(suchende, gewuenscht));
				
	}

}
