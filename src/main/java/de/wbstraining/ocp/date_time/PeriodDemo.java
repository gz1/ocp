package de.wbstraining.ocp.date_time;

import java.time.Period;

public class PeriodDemo {
	public static void main(String[] args) {
		Period p1 = Period.of(0, 0, 1);
		Period p2 = Period.of(0, 1, 0);
		Period p3 = Period.of(0, 1, 1);
		Period p4 = Period.of(1, 0, 1);
		Period p5 = Period.of(1, 2, 0);
		System.out.println(p1); // P1D
		System.out.println(p2); // P1M
		System.out.println(p3); // P1M1D
		System.out.println(p4); // P1Y1D
		System.out.println(p5); // P1Y1M1D
		// exception
		// Unit must be Years, Months or Days, but was Seconds
		// p1.plus(Duration.ofHours(1));
	}
}