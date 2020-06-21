package de.wbstraining.ocp.comparator;

import static java.util.Comparator.comparing;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import de.wbstraining.ocp.pattern.builder.BuchExemplar;
import de.wbstraining.ocp.pattern.builder.BuchExemplarUtil;

public class NullsFirstNullsLastDemo {

	public static void main(String[] args) throws IOException {
		
		String booksPath = "src/main/resources/io/buchexemplare.txt";
		List<BuchExemplar> exemplare = BuchExemplarUtil.exemplareFromFile(booksPath, "\t+");
		
		exemplare.add(0, null);
		exemplare.add(null);
		
		Comparator<BuchExemplar> cmp = comparing(e -> e.getIsbn());
		
		Comparator<BuchExemplar> cmpNullsFirst = Comparator.nullsFirst(cmp);
		Comparator<BuchExemplar> cmpNullsLast = Comparator.nullsLast(cmp);
		
		exemplare.sort(cmpNullsFirst);
		exemplare.forEach(System.out::println);
		
		System.out.println(" ------ ");
		exemplare.sort(cmpNullsLast);
		exemplare.forEach(System.out::println);
		
	}

}
