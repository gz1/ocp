package de.wbstraining.ocp.pattern.builder;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MoreBuchExemplarDemo {

	public static void main(String[] args) throws IOException {
		
		// wir zählen, wie viele bücher mit verschiedener isbn
		// in buchexemplare.txt enthalten sind.
		
		String booksPath = "resources/io/buchexemplare.txt";

		List<BuchExemplar> exemplare = BuchExemplarUtil.exemplareFromFile(booksPath, "\t+");
		
		Set<String> isbNummern = new HashSet<>();
		
		long anzahl;
		
		for(BuchExemplar exemplar : exemplare) {
			isbNummern.add(exemplar.getIsbn());
		}
		
		anzahl = isbNummern.size();
		
		System.out.println("anzahl verschiedener isb-nummern: " + anzahl);
		
		// oder so (mit mitteln von Stream):
		
		anzahl = exemplare.stream().map(e -> e.getIsbn()).distinct().count();
		
		System.out.println("anzahl verschiedener isb-nummern: " + anzahl);
	}
}
