package de.wbstraining.ocp.comparator;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import de.wbstraining.ocp.pattern.builder.BuchExemplar;
import de.wbstraining.ocp.pattern.builder.BuchExemplarUtil;

public class ThenComparingDemo {

public static void main(String[] args) throws IOException {
		
		String booksPath = "src/main/resources/io/buchexemplare.txt";
		List<BuchExemplar> exemplare = BuchExemplarUtil.exemplareFromFile(booksPath, "\t+");

		Comparator<BuchExemplar> cmpByAutor = Comparator.comparing(e -> e.getAutor());
		Comparator<BuchExemplar> cmpByPreis = Comparator.comparing(e -> e.getPreis());
		
		exemplare.sort(cmpByAutor.thenComparing(cmpByPreis));
		
		exemplare.forEach(System.out::println);
	}
}
