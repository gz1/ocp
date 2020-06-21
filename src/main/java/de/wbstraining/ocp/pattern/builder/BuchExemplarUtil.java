package de.wbstraining.ocp.pattern.builder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuchExemplarUtil {

	// liest zeilen aus einer datei ein (path).
	// zerlegt jede zeile in einzelne tokens (delimiter).
	// erzeugt für jede zeile eine instanz von BuchExemplar unter verwendung von
	// BuchExemplar.Builder
	// liefert eine list aller erzeugten buchexemplar-objekte

	public static List<BuchExemplar> exemplareFromFile(String path, String delimiter) throws IOException {

		Function<String, BuchExemplar> line2Exemplar = line -> {
			
			String[] tokens = line.split(delimiter);
			
			return new BuchExemplar.Builder().
					setNr(Integer.parseInt(tokens[0])).
					setIsbn(tokens[1]).
					setAutor(tokens[2]).
					setTitel(tokens[3]).
					setKategorie(tokens[4]).
					setPreis(Double.parseDouble(tokens[5])).
					build();
		};

		List<BuchExemplar> list = null;

		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			list = stream.map(line2Exemplar).collect(Collectors.toList());
		}

		return list;
	}

}
