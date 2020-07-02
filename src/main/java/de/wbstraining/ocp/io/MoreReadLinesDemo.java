package de.wbstraining.ocp.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MoreReadLinesDemo {

	// wir illustrieren die zeilenweise verarbeitung von character data
	// unter verwendung der folgenden methoden:

	// lines() von BufferedReader
	// lines() in Files
	// readAllLines() in Files
	// newBufferedReader() von Files

	// der code gibt in allen varianten sich selbst aus

	public static void main(String[] args) throws IOException {

		String file = "src/main/java/de/wbstraining/ocp/io/MoreReadLinesDemo.java";
		Path path = Paths.get(file);
		Consumer<String> linePrinter = s -> System.out.println(s);

		// variante 1
		try (BufferedReader br = Files.newBufferedReader(path)) {
			br.lines().forEach(linePrinter);
		}
		

		// variante 2
		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(linePrinter);
		}

		// variante 3
		Files.readAllLines(path).forEach(linePrinter);
	}

}
