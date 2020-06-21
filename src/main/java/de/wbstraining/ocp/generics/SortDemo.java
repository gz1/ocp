package de.wbstraining.ocp.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Medium implements Comparable<Medium> {
	String inventarNummer;
	String titel;

	public Medium(String inventarNummer, String titel) {
		this.inventarNummer = inventarNummer;
		this.titel = titel;
	}

	@Override
	public int compareTo(Medium medium) {
		return inventarNummer.compareTo(medium.inventarNummer);
	}

	@Override
	public String toString() {
		return "Medium [inventarNummer=" + inventarNummer + ", titel=" + titel + "]";
	}
}

class Buch extends Medium {
	String isbn;

	public Buch(String inventarNummer, String titel, String isbn) {
		super(inventarNummer, titel);
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Buch [isbn=" + isbn + ", inventarNummer=" + inventarNummer + ", titel=" + titel + "]";
	}
}

public class SortDemo {

	public static void main(String[] args) {

		// wir bestücken eine List von Integer mit einigen Integer-objekten
		// dann definieren wir einen Comparator für den typ Number.
		// dieser comparator vergleicht die string-repräsentationen der objekte.

		// dann sortieren wir die list mit einer geeigneten sort() - methode
		// der klasse Collections unter verwendung dieses comparators.

		// die hier verwendete sort()- methode ist in Collections so definiert:
		// static <T> void sort(List<T> list, Comparator<? super T> c)

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 10, 20, 30, 40, 100, 200, 300, 400);
		System.out.println("originale list");
		System.out.println(list);
		Comparator<Number> cmp = (n1, n2) -> n1.toString().compareTo(n2.toString());
		Collections.sort(list, cmp);
		System.out.println("list, sortiert nach der string-repräsentation ihrer elemente");
		System.out.println(list);

		// wir bestücken nun eine list mit einigen büchern.
		// dann sortieren wir die list ohne verwendung eines comparators
		// mit einer geeigneten sort()- methode von Collections.
		
		// die hier verwendete sort()- methode ist in Collections so definiert:
		// public static <T extends Comparable<? super T>> void sort(List<T> list)
		Buch b1 = new Buch("2000", "moby dick", "1-11-333");
		Buch b2 = new Buch("100", "java concurrency in practice", "2-22-333");
		Buch b3 = new Buch("30", "bartleby", "4-44-333");

		System.out.println("------------");

		List<Buch> buecher = Arrays.asList(b1, b2, b3);
		System.out.println("originale list");
		buecher.forEach(System.out::println);
		Collections.sort(buecher);
		System.out.println("list, sortiert nach der inventarnummer");
		buecher.forEach(System.out::println);
	}

}
