package de.wbstraining.ocp.util;

public class LottoUtil {

	/*
	 * wir schreiben die methode randomTipp(). diese methode liefert einen long,
	 * in dem genau 6 bits auf 1 gesetzt sind, und zwar auf positionen zwischen
	 * 1 und 49. die auswahl der positionen erfolgt zufällig.
	 * 
	 * wir testen in der klasse LottoUtilDemo, indem wir einige random-tipps
	 * erzeugen und als dualzahlen darstellen.
	 */
	public static long randomTipp() {
		long tippAsBits = 0;
		while (Long.bitCount(tippAsBits) != 6) {
			tippAsBits |= (1L << (int) (Math.random() * 49 + 1));
		}
		return tippAsBits;
	}

	public static int anzahlTreffer(long tippZahlen, long ziehungsZahlen) {
		return Long.bitCount(tippZahlen & ziehungsZahlen);
	}

	/*
	 * wir schreiben die methode isValidTipp(). sie prüft, ob ein long-wert
	 * einem gültigen tipp entspricht.
	 */
	public static boolean isValidTipp(long zahl) {
		return zahl > 1 && Long.bitCount(zahl) == 6
				&& Long.highestOneBit(zahl) < (1L << 50);
	}

	// wir schreiben die methode tippAsString(). sie liefert zu einem als
	// long-wert gegebenen tipp eine brauchbare string-repräsentation.
	// bsp.:
	// 0000000000000000000000000000000000000000000000010000000101110010
	// sollte folgenden string liefern: "1 4 5 6 8 16"

	// die methode wirft eine IllegalArgumentException, falls die
	// übergebene zahl keinen gültigen tipp darstellt.

	public static String tippAsString(long tippAsBits)
			throws IllegalArgumentException {
		if (!isValidTipp(tippAsBits)) {
			throw new IllegalArgumentException("invalid tipp...");
		}
		StringBuilder sb = new StringBuilder("[");
		for (int n = 1, counter = 0; counter < 6 && n < 50; n++) {
			if ((tippAsBits & (1L << n)) != 0) {
				sb.append(n).append(counter < 5 ? " " : "]");
				counter++;
			}
		}
		return sb.toString();
	}

	// wir schreiben die methode createTipp(). sie erzeugt einen long-wert
	// mit 6 einserbits. der aufrufer kann bis zu 6 zahlen vorgeben. die
	// fehlenden zahlen werden per randomizer erzeugt.

	// einige korrekte aufrufe von createTipp():
	// bsp.: createTipp()
	// bsp.: createTipp(1,2,3)
	// bsp.: createTipp(1,2,3,4,5)
	// bsp.: createTipp(10,20,30,34,35,36)

	// einige inkorrekte aufrufe von createTipp():
	// createTipp(1,3,50)
	// createTipp(1,2,3,4,5,6,7);
	// createTipp(1,2,3,1);
	// createTipp(1,2,3,0,45);
	// createTipp(1,2,3,-6,45);

	// wir testen in CreateTippDemo

	public static long createTipp(int... zahlen)
			throws IllegalArgumentException {
		if (zahlen.length > 6) {
			throw new IllegalArgumentException(
					"es sind höchstens 6 zahlen erlaubt...");
		}
		long tipp = 0;
		for (int zahl : zahlen) {
			if (zahl < 1 || zahl > 49) {
				throw new IllegalArgumentException(
						"alle zahlen müssen zwischen 1 und 49 liegen...");
			}
			if ((tipp & (1L << zahl)) != 0) {
				throw new IllegalArgumentException(
						"duplikate sind nicht erlaubt...");
			}
			tipp |= (1L << zahl);
		}
		while (Long.bitCount(tipp) != 6) {
			tipp |= (1L << (int) (Math.random() * 49 + 1));
		}
		return tipp;
	}

	/*
	 * wir schreiben die methode countMatchingEndDigits(). sie zählt, in wie
	 * vielen end-ziffern zahl und losnummer übereinstimmen. es werden maximal
	 * numberOfDigits ziffern verglichen.
	 * 
	 * bsp.: countMatchingEndDigits(1234567,8888567, 7) => 3 bsp.:
	 * countMatchingEndDigits(123456789,123456789, 5) => 5
	 */
	public static int countMatchingEndDigits(int zahl, int losnummer,
			int maxNumberOfDigits) {
		if (zahl < 0 || losnummer < 0 || maxNumberOfDigits > 7) {
			throw new IllegalArgumentException("illegal arguments...");
		}
		int teiler = 10;
		int matchCounter = 0;
		int n = 0;
		for (; teiler <= 10_000_000 && zahl % teiler == losnummer % teiler
				&& n < maxNumberOfDigits; n++, teiler *= 10) {
			matchCounter++;
		}
		return matchCounter;
	}

	
	public static int gkl6Aus49(long ziehungsZahlen, long tippZahlen,
			int superzahl, int losnummer) {
		boolean hasMatchingSuperzahl = (superzahl == losnummer % 10);
		int gewinnKlasse = 0;
		int trefferzahl = anzahlTreffer(ziehungsZahlen, tippZahlen);
		if ((trefferzahl == 2 && hasMatchingSuperzahl) || trefferzahl > 2) {
			if (hasMatchingSuperzahl) {
				gewinnKlasse = 13 - (trefferzahl * 2);
			} else {
				gewinnKlasse = 12 - ((trefferzahl - 1) * 2);
			}
		}
		return gewinnKlasse;
	}
}
