package de.wbstraining.ocp.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ComputeDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("anna", "hanna", "hannelore");
		Map<String, Integer> map = new HashMap<>();
		stream.forEach(s -> map.put(s, s.length()));
		// key existiert, neuer wert ungleich null: update
		map.compute("anna", (k, v) -> v + 10);
		System.out.println(map);
		// key existiert nicht, neuer wert ungleich null: put
		map.compute("anton", (k, v) -> k.length());
		System.out.println(map);
		// key existiert, neuer wert null: remove
		map.compute("anna", (k, v) -> null);
		System.out.println(map);
		// key existiert nicht , neuer wert null: keine aktion
		map.compute("blabla", (k, v) -> null);
		System.out.println(map);
	}
}