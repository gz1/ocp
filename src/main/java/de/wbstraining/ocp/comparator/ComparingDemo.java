package de.wbstraining.ocp.comparator;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import de.wbstraining.ocp.pattern.builder.BuchExemplar;
import de.wbstraining.ocp.pattern.builder.BuchExemplarUtil;

import static java.util.Comparator.*;

public class ComparingDemo {

	public static void main(String[] args) throws IOException {
		
		String booksPath = "src/main/resources/io/buchexemplare.txt";
		List<BuchExemplar> exemplare = BuchExemplarUtil.exemplareFromFile(booksPath, "\t+");

		Comparator<BuchExemplar> cmp = comparing(e -> e.getIsbn());
		exemplare.sort(cmp);
		exemplare.forEach(System.out::println);

		System.out.println(" ------ ");
		
		cmp = comparingDouble(e -> e.getPreis());
		exemplare.sort(cmp);
		exemplare.forEach(System.out::println);
		
		System.out.println(" ------ ");
		
		cmp = comparing(e -> e.getIsbn(), (s1, s2) -> s2.compareTo(s1));
		exemplare.sort(cmp);
		exemplare.forEach(System.out::println);
		
		
	}

}
