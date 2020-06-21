package de.wbstraining.ocp.date_time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// construction
		LocalDate d1 = LocalDate.now();
		LocalDate d21 = LocalDate.of(2017, Month.JUNE, 26);
		LocalDate d22 = LocalDate.of(2017, 6, 26);
		// plus / minus
		System.out.println(d22.plusDays(10));
		System.out.println(d22.plusMonths(10));
		System.out.println(d22.plusYears(10));
		System.out.println("---");
		// Period (implementiert TemporalAmount)
		System.out.println(d22.plus(Period.ofDays(5)));
		System.out.println(d22.plus(Period.ofMonths(5)));
		System.out.println(d22.plus(Period.ofWeeks(5)));
		System.out.println(d22.plus(Period.ofYears(5)));
		System.out.println("---");
		// ChronoUnit (implementiert TemporalUnit)
		// System.out.println(d22.plus(10, ChronoUnit.HOURS));
		System.out.println(d22.plus(10, ChronoUnit.DAYS));
	}
}