package de.wbstraining.ocp.nested_classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyListDemo {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("a", "b", "c", "d");
		MyList<String> mylist = new MyList<>(list);
//		int n = 0;
//		for (List<String> sublist : mylist) {
//			System.out.printf("%15s   %5s %10s%n", sublist, n,
//					"0b" + Integer.toBinaryString(n));
//			n++;
//		}

		System.out.println("  ----------------   ");
		Iterator<List<String>> itr = mylist.iterator();
		int n = 0;
		List<String> sublist;
		while(itr.hasNext()) {
			sublist = itr.next();
			System.out.printf("%15s   %5s %10s%n", sublist, n,
					"0b" + Integer.toBinaryString(n));
			n++;
		}
	}
}
