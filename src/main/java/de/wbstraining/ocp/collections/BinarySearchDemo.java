package de.wbstraining.ocp.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchDemo {

	public static void main(String[] args) {

		String[] strings = { "one", "two", "three", "four", "five", "six", "seven" };
		
		Arrays.sort(strings);
		
		System.out.println(Arrays.toString(strings));  // [five, four, one, seven, six, three, two]

		System.out.println(Arrays.binarySearch(strings, "one"));  // 2
		System.out.println(Arrays.binarySearch(strings, "eight"));  // -1
		System.out.println(Arrays.binarySearch(strings, "nine"));  // -3
		
		Comparator<String> cmp = (s1, s2) -> s2.compareTo(s1);
		Arrays.sort(strings, cmp);
		System.out.println(Arrays.toString(strings)); // [two, three, six, seven, one, four, five]
		
		System.out.println(Arrays.binarySearch(strings, "one", cmp));  // 4
		System.out.println(Arrays.binarySearch(strings, "eight", cmp));  // -8
		System.out.println(Arrays.binarySearch(strings, "nine", cmp));  // -6
		
		System.out.println("   --- dasselbe mit einer list ---  ");
		
		List<String> list = Arrays.asList(strings);
		
		Collections.sort(list);
		
		System.out.println(list);  // [five, four, one, seven, six, three, two]
		
		System.out.println(Collections.binarySearch(list, "one"));  // 2
		System.out.println(Collections.binarySearch(list, "eight"));  // -1
		System.out.println(Collections.binarySearch(list, "nine"));  // -3
		
		Collections.sort(list, cmp);
		
		System.out.println(list);  // [two, three, six, seven, one, four, five]
		
		System.out.println(Collections.binarySearch(list, "one", cmp));  // 4
		System.out.println(Collections.binarySearch(list, "eight", cmp));  // -8
		System.out.println(Collections.binarySearch(list, "nine", cmp));  // -6

	}

}
