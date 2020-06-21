package de.wbstraining.ocp.map;

import java.util.Map;
import java.util.TreeMap;

public class SimpleMapDemo {

	// wir bestücken ein map, in der wir den deutschen zahlwörtern
	// von eins bis fünf die englischen entsprechungen zuordnen.
	public static void main(String[] args) {
		
		Map<String, String> dict = new TreeMap<String, String>();
		
		dict.put("eins", "one");
		dict.put("zwei", "two");
		dict.put("drei", "three");
		dict.put("vier", "four");
		dict.put("fünf", "five");

		// wir geben alle key-value-paare aus
		
		// 1. variante mit toString()
		System.out.println("--- toString() ---");
		System.out.println(dict);
		
		// 2. variante mit forEach()
		System.out.println("--- forEach() mit BiConsumer ---");
		dict.forEach((k, v) -> System.out.println(k + " -> " + v));
		
		// 3. variante mit iteration über alle entries (Map.Entry)
		// unter verwendung der methode entrySet()
		
		System.out.println("--- entrySet() mit forEach() ---");
		dict.entrySet().forEach(entry -> System.out.println(entry));
		
		// 4. variante mit iteration über alle keys
		// unter verwendung der methoden keySet() und get()
		
		System.out.println("--- keySet() und get() ---");
		dict.keySet().forEach(k -> {
			System.out.println(k + " -> " + dict.get(k));
		});
	}
}
