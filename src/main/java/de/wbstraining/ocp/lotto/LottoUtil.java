package de.wbstraining.ocp.lotto;

/**
 * 
 * @author Günter <br>
 * 
 *         die klasse bietet statische methoden zum erzeugen von tipps im spiel
 *         6 aus 49 und zur gewinnklassenermittlung in den spielen 6 aus 49,
 *         spiel77 und spiel super6.
 *
 */

public class LottoUtil {

	// wir schreiben die methode randomTipp().
	// sie liefert einen long, in dem genau 6 bits an bitpositionen
	// zwischen 1 und 49 auf 1 gesetzt sind. die einserbits
	// sollen nach dem zufallsprinzip verteilt sein.

	/**
	 * liefert ein zufällig erzeugtes bitmuster
	 * 
	 * @return bitmuster in dem gelieferten long sind genau 6 bits auf 1 gesetzt an
	 *         zufälligen positionen zwischen 1 und 49. die position 0 ist niemals
	 *         besetzt.
	 * 
	 */
	public static long randomTipp() {
		long tippAsBits = 0;
		int zahl;
		while (Long.bitCount(tippAsBits) != 6) {
			// oder ThreadLocalRandom...
			zahl = (int) (Math.random() * 49 + 1);
			tippAsBits |= (1L << zahl);
		}
		return tippAsBits;
	}

	/**
	 * 
	 * @param tipp1 der erste tipp
	 * @param tipp2 der zweite tipp
	 * @return die anzahl der übereinstimmenden einserbits
	 */

	// wir schreiben die methode countMatches(). sie zählt die
	// anzahl der übereinstimmenden einsers-bits der beiden long-parameter.

	/**
	 * ermittelt die anzahl übereinstimmender einserbits
	 * 
	 * @param tipp1 der erste tipp
	 * @param tipp2 der zweite tipp
	 * @return die anzahl der übereinstimmenden einserbits
	 */
	public static int countMatches(long tipp1, long tipp2) {
		return Long.bitCount(tipp1 & tipp2);
	}

	// wir schreiben die methode createTipp(). sie erzeugt einen long-wert
	// mit 6 einserbits. der aufrufer kann bis zu 6 zahlen vorgeben. die
	// fehlenden zahlen werden per randomizer erzeugt.

	// einige korrekte aufrufe von createTipp():
	// bsp.: createTipp(1,2,3)
	// bsp.: createTipp(1,2,3,4,5)

	// einige inkorrekte aufrufe von createTipp():
	// createTipp(1,3,50)
	// createTipp(1,2,3,4,5,6,7);
	// createTipp(1,2,3,1);

	/**
	 * liefert einen tipp, bei dem der aufrufer bis zu sechs zahlen mitgeben kann.
	 * die fehlenden zahlen werden per randomizer erzeugt.
	 * 
	 * @param zahlen 0 bis 6 zahlen zwischen 1 und 49
	 * @return bitmuster
	 * @throws IllegalArgumentException duplikate, mehr als 6 argumente, zahlen
	 *                                  ausserhalb von 1 - 49
	 */
	public static long createTipp(int... zahlen) throws IllegalArgumentException {
		if (zahlen.length > 6) {
			throw new IllegalArgumentException("es sind höchstens 6 zahlen erlaubt...");
		}
		long tipp = 0;
		for (int zahl : zahlen) {
			if (zahl < 1 || zahl > 49) {
				throw new IllegalArgumentException("alle zahlen müssen zwischen 1 und 49 liegen...");
			}
			if ((tipp & (1L << zahl)) != 0) {
				throw new IllegalArgumentException("duplikate sind nicht erlaubt...");
			}
			tipp |= (1L << zahl);
		}
		while (Long.bitCount(tipp) != 6) {
			tipp |= (1L << (int) (Math.random() * 49 + 1));
		}
		return tipp;
	}

	// wir schreiben die methode gkl6Aus49(). sie ermittelt, zu welcher gewinnklasse
	// ein tipp im spiel 6 aus 49 gehört.

	/**
	 * ermittelt die gewinnklasse im spiel 6 aus 49
	 * 
	 * @param ziehungszahlenAlsBits die bei der ziehung gezogenen zahlen als
	 *                              bitmuster
	 * @param tippAlsBits           der tipp als bitmuster
	 * @param hasMatchingSuperzahl  zeigt an, ob die letzte ziffer der losnummer mit
	 *                              der superzahl übereinstimmt
	 * @return
	 */
	public static int gkl6Aus49(long ziehungszahlenAlsBits, long tippAlsBits, boolean hasMatchingSuperzahl) {
		int gewinnKlasse = 0;
		int treffer = Long.bitCount(ziehungszahlenAlsBits & tippAlsBits);

		if ((treffer == 2 && hasMatchingSuperzahl) || treffer > 2) {
			if (hasMatchingSuperzahl) {
				gewinnKlasse = 13 - (treffer * 2);
			} else {
				gewinnKlasse = 12 - ((treffer - 1) * 2);
			}
		}
		return gewinnKlasse;

	}

	// wir schreiben die methode gklSpiel77(). sie ermittelt, zu welcher
	// gewinnklasse ein lottoschein im spiel 77 gehört.

	/**
	 * ermittelt die gewinnklasse im spiel 77
	 * 
	 * @param ziehungSpiel77 die in der ziehung für das spiel 77 gezogene zahl
	 * @param losNummer      die losnummer des lottoscheins
	 * @return die gewinnklasse im spiel 77<br>
	 *         liefert 0, wenn der lottoschein nicht in einer gewinnklasse im
	 *         spiel77 ist
	 */
	public static int gklSpiel77(int ziehungSpiel77, int losNummer) {
		int teiler = 10;
		int gewinnKlasse = 0;
		for (; teiler <= 10_000_000 && ziehungSpiel77 % teiler == losNummer % teiler; teiler *= 10) {
		}
		if (teiler > 10) {
			gewinnKlasse = 10 - Integer.toString(teiler).length();

		}
		return gewinnKlasse;
	}

	// wir schreiben die methode gklSuper6(). sie ermittelt, zu welcher gewinnklasse
	// ein lottoschein im spiel super 6 gehört.
	/**
	 * ermittelt die gewinnklasse im spiel super6
	 * 
	 * @param ziehungSuper6 die in der ziehung für das spiel super6 gezogene zahl
	 * @param losNummer     die losnummer des lottoscheins
	 * @return die gewinnklasse im spiel super 6<br>
	 *         liefert 0, wenn der lottoschein nicht in einer gewinnklasse im spiel
	 *         super6 ist
	 * 
	 */
	public static int gklSuper6(int ziehungSuper6, int losNummer) {
		int teiler = 10;
		int gewinnKlasse = 0;
		for (; teiler <= 1_000_000 && ziehungSuper6 % teiler == losNummer % teiler; teiler *= 10) {
		}
		if (teiler > 10) {
			gewinnKlasse = 9 - Integer.toString(teiler).length();
		}
		return gewinnKlasse;
	}

	// wir schreiben die methode tippAsString(). sie liefert zu einem als long-wert
	// gegebenen tipp (mit einserbits, die zahlen repräsentieren) eine brauchbare
	// string-repräsentation

	/**
	 * liefert zu einem tipp als bitmuster die string-repräsentation
	 * 
	 * @param tippAsBits bitmuster
	 * @return die dem bitmuster entsprechenden zahlen<br>
	 *         separator ist genau ein blank
	 */
	public static String tippAsString(long tippAsBits) {
		StringBuilder sb = new StringBuilder();
		for (int n = 1, counter = 0; counter <= 6 && n < 64; n++) {
			if ((tippAsBits & (1L << n)) != 0) {
				sb.append(n).append(" ");
				counter++;
			}
		}
		return sb.toString().trim();

	}
}