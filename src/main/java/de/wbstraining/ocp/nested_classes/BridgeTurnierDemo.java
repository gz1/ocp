package de.wbstraining.ocp.nested_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeTurnierDemo {

	/*
	 * wir organisieren ein bridge-turnier, an dem 7 herren und 12 damen
	 * teilnehmen. wir listen alle möglichen kombinationen von genau 4 spielern
	 * auf, in denen jeweils 2 damen und 2 herren beteiligt sind.
	 * wie viele kombinationen gibt es insgesamt?
	 */

	public static void main(String[] args) {
		
		String[] herren = { "anton", "bernd", "chris", "dieter", "emil",
				"friedrich", "gustav" };
		String[] damen = { "anna", "berta", "christa", "daniela", "emilia",
				"friederike", "gundula", "hanna", "isidora", "jennifer",
				"karin", "leonore" };
		
		MyList<String> herrenAsList = new MyList<>(Arrays.asList(herren));
		MyList<String> damenAsList = new MyList<>(Arrays.asList(damen));
		int anzahl = 0;
		
		List<String> quadrupel = new ArrayList<>();
		for (List<String> subListDamen : damenAsList) {
			for (List<String> subListHerren : herrenAsList) {
				if (subListHerren.size() == 2 && subListDamen.size() == 2) {
					quadrupel.addAll(subListDamen);
					quadrupel.addAll(subListHerren);
					System.out.println(quadrupel);
					anzahl++;
					quadrupel.clear();
				}
			}
		}
		System.out.println("es gibt insgesamt " + anzahl + " kombinationen");
		System.out.println("kontrolle: " + ((7 * 6) / 2) * ((12 * 11) / 2));
	}
}
