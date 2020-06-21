package de.wbstraining.ocp.date_time;

import java.time.LocalDate;
import java.time.Month;


public class LeapYearDemo {
	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2016, Month.JANUARY, 29);
		LocalDate d2 = LocalDate.of(2015, Month.JANUARY, 29);
		LocalDate d = d1.plusDays(31);
		System.out.println(d); // 2016-02-29
		d = d2.plusDays(31);
		System.out.println(d); // 2015-03-01
	}
}