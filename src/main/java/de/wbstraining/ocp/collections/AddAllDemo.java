package de.wbstraining.ocp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAllDemo {

	// wir llustrieren, warum der parameter von addAll() in
	// Collection Collection<? extends E> ist und nicht Collection<E>

	public static void main(String[] args) {

		List<Number> numbers = new ArrayList<>();

		List<Integer> integers = Arrays.asList(1, 2, 3);
		List<Long> longs = Arrays.asList(4L, 5L, 6L);

		numbers.addAll(integers);
		numbers.addAll(longs);

		for (Number number : numbers) {
			System.out.println(number + " -> " + number.getClass().getSimpleName());
		}

	}

}
