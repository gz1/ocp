package de.wbstraining.ocp.pattern.builder;

import java.io.IOException;

public class BuchExemplarDemo {

	public static void main(String[] args) throws IOException {

		String booksPath = "src/main/resources/io/buchexemplare.txt";

		BuchExemplarUtil.exemplareFromFile(booksPath, "\t+")
				.forEach(System.out::println);
	}
}
