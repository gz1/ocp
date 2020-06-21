package de.wbstraining.ocp.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class AllMatchDemo {

	public static void main(String[] args) {
		String[] strings1 = { "anna", "otto", "rentner" };
		String[] strings2 = { "anna", "otto", "manna" };
		Set<String> set1 = new HashSet<>(Arrays.asList(strings1));
		Set<String> set2 = new HashSet<>(Arrays.asList(strings2));
		Predicate<String> predicate = s -> {
			String reversed = new StringBuilder(s).reverse().toString();
			return s.equals(reversed);
		};
		System.out.println(SetUtil.allMatch(set1, predicate));
		System.out.println(SetUtil.allMatch(set2, predicate));
	}
}
