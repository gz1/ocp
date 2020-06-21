package de.wbstraining.ocp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SimpleWildcardsDemo {

	// wir illustrieren die wildcards ?, ? super und ? extends
	// am beispiel von methoden von Collection
	public static void main(String[] args) {
		
		List<CharSequence> charSequences = new ArrayList<>();
		List<String> strings = new ArrayList<>();
		List<StringBuilder> stringBuilders = new ArrayList<>();
		List<Object> objects = new ArrayList<>();
		
		strings.add("anna");
		strings.add("nanna");
		
		stringBuilders.add(new StringBuilder("klara"));
		stringBuilders.add(new StringBuilder("marianne"));
		
		objects.add("nanna");
		objects.add(Integer.valueOf(12345));
		
		// boolean addAll(Collection<? extends E> c)
		charSequences.addAll(strings);
		charSequences.addAll(stringBuilders);
		System.out.println(charSequences); // [anna, nanna, klara, marianne]
		
		// boolean removeAll(Collection<?> c)
		charSequences.removeAll(objects);
		System.out.println(charSequences);  // [anna, klara, marianne]
		
		// default boolean removeIf(Predicate<? super E> filter)
		Predicate<CharSequence> predicate = cs -> cs.length() == 8;
		stringBuilders.removeIf(predicate);
		System.out.println(stringBuilders);  // [klara]
		


	}

}
