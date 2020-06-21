package de.wbstraining.ocp.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsDuplicatesDemo {
	public static void main(String[] args) {
		A a1 = new A(2);
		A a2 = new A(4);
		Set<A> set1 = new HashSet<>();
		set1.add(a1);
		set1.add(a2);
		System.out.println(set1.size()); // 2
		Set<A> set2 = new TreeSet<>();
		set2.add(a1);
		set2.add(a2);
		System.out.println(set2.size()); // 1
		a1.setN(100);
		a2.setN(100);
		System.out.println(a1.equals(a2)); // true
		System.out.println(set1.size()); // 2
	}
}