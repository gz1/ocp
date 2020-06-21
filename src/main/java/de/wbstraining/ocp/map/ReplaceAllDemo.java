package de.wbstraining.ocp.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ReplaceAllDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("anna", "hanna", "hannelore");
		Map<String, Integer> map = new HashMap<>();
		stream.forEach(s -> map.put(s, s.length()));
		map.replaceAll((k, v) -> v + 10);
		System.out.println(map);
	}
}