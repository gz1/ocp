package de.wbstraining.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Consumer;

public class CountJavaKeywords {
	
	// wir lesen java-keywords aus der datei src/main/resources/java_keywords.txt ein.
	
	// wir ermitteln für jedes dieser keywords, wie oft es in allen java-sourcen in src/main/java
	// vorkommt.
	
	// dann geben wir die keywords mit ihrer häufigkeit aus
	// - variante 1: aphabetisch aufsteigend
	// - variante 2: absteigend nach häufigkeit. bei gleicher häufigkeit aufsteigend nach keyword.

	public static void main(String[] args) throws IOException {
		String pathToSrc = "src/main/java";
		Consumer<Path> consumer = p -> {
			try {
				Files.lines(p).flatMap(s -> Arrays.stream(s.split("\\W+")))
						.filter(s -> s.length() > 1).forEach(System.out::println);
			} catch (IOException e) {
					throw new RuntimeException(e);
			}
		};
		Files.find(Paths.get(pathToSrc), Integer.MAX_VALUE,
					(p, f) -> p.toString().endsWith(".java")).forEach(consumer);
		}

	

}
