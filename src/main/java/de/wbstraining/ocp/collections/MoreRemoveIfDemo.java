package de.wbstraining.ocp.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MoreRemoveIfDemo {

	// wir bestücken eine list mit einigen strings.
	// wir bestücken eine weitere list mit einigen stringbuildern.
	
	// dann entfernen wir aus jeder der beiden lists alle elemente,
	// deren länge > 4 ist.
	
	// wir verwenden die methode removeIf() und für beide fälle
	// dasselbe prädikat.
	
	public static void main(String[] args) {
		
		List<String> strings= new ArrayList<>();
		List<StringBuilder> stringBuilders = new ArrayList<>();
		
		Predicate<CharSequence> predicate = cs -> cs.length() > 4;
		
		strings.add("4444");
		strings.add("55555");
		
		stringBuilders.add(new StringBuilder("4444"));
		stringBuilders.add(new StringBuilder("55555"));
		
		strings.removeIf(predicate);
		stringBuilders.removeIf(predicate);
		
		System.out.println(strings);
		System.out.println(stringBuilders);

	}

}
