package de.wbstraining.ocp.generics;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetComparatorDemo {

	// wir untersuchen, was passiert, wenn wir in einem treeset elemente ablegen,
	// deren typ kein natural ordering hat, und als comparator null übergeben.
	
	public static void main(String[] args) {
		Comparator<StringBuilder> cmp = null;
		NavigableSet<StringBuilder> set = new TreeSet<>(cmp);
		set.add(new StringBuilder());
	}
}
