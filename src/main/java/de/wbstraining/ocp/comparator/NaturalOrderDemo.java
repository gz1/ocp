package de.wbstraining.ocp.comparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import de.wbstraining.ocp.pattern.builder.BuchExemplar;
import de.wbstraining.ocp.pattern.builder.BuchExemplarUtil;

public class NaturalOrderDemo {

	public static void main(String[] args) throws IOException {

		String booksPath = "src/main/resources/io/buchexemplare.txt";
		List<String> isbNummern = new ArrayList<>();
		List<BuchExemplar> exemplare = BuchExemplarUtil.exemplareFromFile(booksPath, "\t+");

		exemplare.forEach(e -> isbNummern.add(e.getIsbn()));
		
		isbNummern.sort(Comparator.naturalOrder());
		
		isbNummern.forEach(System.out::println);
	}

}
