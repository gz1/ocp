package de.wbstraining.ocp.comparator;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import de.wbstraining.ocp.pattern.builder.BuchExemplar;
import de.wbstraining.ocp.pattern.builder.BuchExemplarUtil;

public class CompareDemo {

	public static void main(String[] args) throws IOException {
		String booksPath = "src/main/resources/io/buchexemplare.txt";
		List<BuchExemplar> exemplare = BuchExemplarUtil.exemplareFromFile(booksPath, "\t+");
		Comparator<BuchExemplar> cmp = (e1, e2) -> Double.compare(e1.getPreis(), e2.getPreis());
		exemplare.sort(cmp);
		exemplare.forEach(System.out::println);
	}

}
