package de.wbstraining.ocp.generics;

import java.util.HashSet;
import java.util.Set;

public class CountDemo {

	public static void main(String[] args) {
		// wir bestücken ein set mit den zahlen von 1 bis 1000.
		// dann ermitteln wir, wie viele dieser zahlen genau 3 einserbits
		// haben (s. Integer.bitCount()).

		// wir verwenden die methode count() von SetUtil.
		final int min = 1;
		final int max = 1000;
		final int bits = 3;
		final Set<Integer> set = new HashSet<>();

		for (int i = min; i <= max; i++) {
			set.add(i);
		}

		System.out.printf("zwischen %4d und %4d gibt es %4d zahlen mit %2d einserbits", min, max,
				SetUtil.count(set, n -> Integer.bitCount(n) == bits), bits);

	}

}
