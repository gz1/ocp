package de.wbstraining.ocp.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PutIfAbsentDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("anna", "hanna", "hannelore");
		Map<String, Integer> map = new HashMap<>();
		stream.forEach(s -> map.put(s, s.length()));
		System.out.println(map.putIfAbsent("paul", 4)); // null
		System.out.println(map.putIfAbsent("anna", 4)); // 4
		System.out.println(map);
	}
}