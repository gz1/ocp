package de.wbstraining.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CountJavaKeywordsDemo {

	// wir lesen java-keywords aus der datei src/main/resources/java_keywords.txt
	// ein.

	// wir ermitteln für jedes dieser keywords, wie oft es in allen java-sourcen in
	// src/main/java
	// vorkommt.

	// dann geben wir die keywords mit ihrer häufigkeit aus
	// - variante 1: aphabetisch aufsteigend
	// - variante 2: absteigend nach häufigkeit. bei gleicher häufigkeit aufsteigend
	// nach keyword.

	public static void main(String[] args) throws IOException {

		String pathToKeywords = "src/main/resources/io/java_keywords.txt";
		String pathToSrc = "src/main/java";

		Map<String, AtomicInteger> countingMap = new TreeMap<>();

		// map aufbauen
		try (Stream<String> lines = Files.lines(Paths.get(pathToKeywords))) {
			lines.flatMap(s -> Arrays.stream(s.split(",")))
					.forEach(s -> countingMap.put(s, new AtomicInteger(0)));
		}
		
		// map updater
		Consumer<Path> mapUpdater = p -> {
			try {
				Files.lines(p).flatMap(s -> Arrays.stream(s.split("\\W+")))
						.forEach(word -> countingMap.computeIfPresent(word, (s, a) -> {
							a.getAndIncrement();
							return a;
						}));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};
		
		// map updaten
		Files.find(Paths.get(pathToSrc), Integer.MAX_VALUE, (p, f) -> p.toString().endsWith(".java"))
				.forEach(mapUpdater);

		// comparatoren
		Comparator<Map.Entry<String, AtomicInteger>> cmpHaufigkeit = (e1, e2) -> Integer
				.compare(e2.getValue().intValue(), e1.getValue().intValue());

		Comparator<Map.Entry<String, AtomicInteger>> cmpKeyword = 
				(e1, e2) -> e1.getKey().compareTo(e2.getKey());

		Comparator<Map.Entry<String, AtomicInteger>> cmp = cmpHaufigkeit.thenComparing(cmpKeyword);

		
		// map ausgeben
		System.out.println("  --- aphabetisch aufsteigend ---");
		countingMap.forEach((k, v) -> System.out.println(k + " -> " + v));

		System.out.println("  --- absteigend nach häufigkeit / alphabetisch aufsteigend ---");
		countingMap.entrySet().stream().sorted(cmp)
				.forEach((e -> System.out.println(e.getKey() + " -> " + e.getValue())));
	}

}
