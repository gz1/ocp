package de.wbstraining.ocp.date_time.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DatesToStringDemo {

	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.of(2020, Month.JUNE, 16);
		LocalDateTime localDateTime1 = LocalDateTime.of(2020, Month.JUNE, 16, 9, 30);
		LocalDateTime localDateTime2 = LocalDateTime.of(2020, Month.JUNE, 16, 9, 30, 9, 100);
		LocalTime localTime = LocalTime.of(9, 30);

		System.out.println(localDate);  // 2020-06-16
		System.out.println(localDateTime1);  // 2020-06-16T09:30
		System.out.println(localDateTime2); // 2020-06-16T09:30:09.000000100
		System.out.println(localTime); // 09:30
	}

}
