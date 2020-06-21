package de.wbstraining.ocp.collections;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {
	public static void main(String[] args) {
		NavigableSet<Integer> set = new TreeSet<>();
		set.add(3);
		set.add(5);
		set.add(10);
		set.add(20);
		System.out.println(set.ceiling(6)); // 10
		System.out.println(set.floor(6)); // 5
		System.out.println(set.headSet(8)); // [3, 5]
		System.out.println(set.tailSet(8)); // [10, 20]
		System.out.println(set.lower(8)); // 5
		System.out.println(set.higher(8)); // 10
		System.out.println(set.descendingSet()); // [20, 10, 5, 3]
		System.out.println(set.subSet(2, 18));
		System.out.println(set.pollFirst()); // 3
		System.out.println(set); // [5, 10, 20]
		System.out.println(set.pollLast()); // 20
		System.out.println(set); // [5, 10]
	}
}