package de.wbstraining.ocp.date_time;

import java.time.ZoneId;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class ZoneIdDemo {

	public static void main(String[] args) {
		
		// bitte geben sie alle verfügbaren ZoneIds aus.
		
		// können sie die ausgabe aufsteigend / absteigend sortieren?
		
		System.out.println(" --- unsortiert --- ");
		System.out.println();
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		for(String zoneId: zoneIds) {
			System.out.println(ZoneId.of(zoneId));
			// System.out.println(zoneId);
		}
		
		System.out.println(" --- aufsteigend sortiert --- ");
		NavigableSet<String> zoneIdsSortedAsc = new TreeSet<>(zoneIds);
		for(String zoneId: zoneIdsSortedAsc) {
			// System.out.println(ZoneId.of(zoneId);
			System.out.println(zoneId);
		}
		
		System.out.println(" --- absteigend sortiert --- ");
		// Comparator<String> cmp = (s1, s2) -> s2.compareTo(s1);
		NavigableSet<String> zoneIdsSortedDesc = new TreeSet<>(Comparator.reverseOrder());
		zoneIdsSortedDesc.addAll(zoneIds);
		for(String zoneId: zoneIdsSortedDesc) {
			// System.out.println(ZoneId.of(zoneId));
			System.out.println(zoneId);
		}
		
		System.out.println(" --- number of ZoneIds --- ");
		System.out.println(zoneIds.size());
	}

}
