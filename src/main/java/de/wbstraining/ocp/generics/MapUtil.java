package de.wbstraining.ocp.generics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// beispiel für das invertieren einer map:

// wörterbuch deutsch -> englisch 
// jedem wort der deutschen sprache soll genau ein wort der englischen sprache
// entsprechen

// die invertierte map liefert dann ein wörterbuch englisch -> deutsch

public class MapUtil {
	
	public static <K, V> Map<V, Set<K>> invertMap(Map<K, V> map) {
		Map<V, Set<K>> inverted = new HashMap<V, Set<K>>();
		Set<K> keyCollection;
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (!inverted.containsKey(entry.getValue())) {
				keyCollection = new HashSet<>();
				inverted.put(entry.getValue(), keyCollection);
			} else {
				keyCollection = inverted.get(entry.getValue());
			}
			keyCollection.add(entry.getKey());
		}
		return inverted;
	}
	
	// wir überladen die methode invertMap().
	// die überladene version stellt sicher, dass sowohl die keys als auch die
	// values der invertierten map sortiert werden.
	
	// wir ändern den return-type: NavigableMap<V, NavigableSet<K>>
	// wir ändern die implementierenden klassen
	// HashSet -> TreeSet
	// HashMap -> TreeMap
	// die methode bekommt zwei weitere parameter: einen comparator für K,
	// und einen comparator für V
	
	public static <K, V> NavigableMap<V, NavigableSet<K>> invertMap(
			Map<K, V> map, Comparator<? super K> cmpK, Comparator<? super V> cmpV) {
		NavigableMap<V, NavigableSet<K>> inverted = new TreeMap<>(cmpV);
		NavigableSet<K> keyCollection;
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (!inverted.containsKey(entry.getValue())) {
				keyCollection = new TreeSet<>(cmpK);
				inverted.put(entry.getValue(), keyCollection);
			} else {
				keyCollection = inverted.get(entry.getValue());
			}
			keyCollection.add(entry.getKey());
		}
		return inverted;
	}
}