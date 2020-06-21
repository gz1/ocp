package de.wbstraining.ocp.generics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

public class MapUtilDemo {

	// wir bestücken eine map.
	// keys sind die englischen zahlwörter von one bis fifteen
	// values sind die längen der keys
	// wir geben die map aus.

	// dann invertieren wir die map und geben die invertierte map ebenfalls aus.
	public static void main(String[] args) {
		
		String[] strings = { "one", "two", "three", "four", "five", "six", "seven", "eight",
				"nine", "ten", "eleven", "twelve", " thirteen", "fourteen", "fifteen" };
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, Set<String>> invertedMap;
		
		for(String s : strings) {
			map.put(s,  s.length());
		}
		System.out.println(map);
		
		invertedMap = MapUtil.invertMap(map);
		System.out.println(invertedMap);
		
		// wir invertieren erneut die map, garantieren jetzt aber, dass sowohl die keys
		// als auch die values absteigend sortiert sind.
		
		// wir definieren zwei comparatoren. einen für den typ String, einen für den typ
		// Integer. für die definition der comparatoren können wir geeignete lambdas
		// verwenden. diese beiden comparatoren übergeben wir an die überladene version
		// von invertMap().
		
		// Comparator<String> cmpK = Comparator.reverseOrder();
		// Comparator<Integer> cmpV = Comparator.reverseOrder();
		
		Comparator<String> cmpK = (s1, s2) -> s2.compareTo(s1);
		Comparator<Integer> cmpV = (i1, i2) -> Integer.compare(i2, i1);
		
		NavigableMap<Integer, NavigableSet<String>> invertedMapSorted;
		
		invertedMapSorted = MapUtil.invertMap(map, cmpK, cmpV);
		
		System.out.println(invertedMapSorted);
	}
	
	

}
