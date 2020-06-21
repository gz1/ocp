package de.wbstraining.ocp.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitioningByDemo {

	public static void main(String[] args) {
		// wir bestücken ein set mit einigen zahlen.
		// dann bilden wir zwei gruppen: die geraden und die ungeraden zahlen.
		// dann geben wir die gruppen aus.
		List<Integer> zahlen = Arrays.asList(1, 3, 4, 5, 7, 9, 12);
		Set<Integer> set = new HashSet<>(zahlen);
		SetUtil.partitioningBy(set, n -> n % 2 == 0).
			entrySet().forEach(entry -> System.out.println(entry));
	}
}
