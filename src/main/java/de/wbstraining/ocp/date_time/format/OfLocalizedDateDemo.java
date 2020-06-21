package de.wbstraining.ocp.date_time.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class OfLocalizedDateDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		LocalDate localDate = LocalDate.of(2020, Month.JUNE, 16);
		LocalDateTime localDateTime = LocalDateTime.of(
				2020, Month.JUNE, 16, 9, 30);
		LocalTime localTime = LocalTime.of(9, 30);
		
		DateTimeFormatter dfShort = DateTimeFormatter.ofLocalizedDate(
				FormatStyle.SHORT);
		DateTimeFormatter dfMedium = DateTimeFormatter.ofLocalizedDate
				(FormatStyle.MEDIUM);
		
		System.out.println(localDate.format(dfShort));
		//  6/16/20
		System.out.println(localDateTime.format(dfShort));
		//  6/16/20
		
		// System.out.println(localTime.format(dfShort));
		
		
		System.out.println(dfShort.format(localDate));
		//  6/16/20
		System.out.println(dfShort.format(localDateTime));
		// 6/16/20
		
		// System.out.println(dfShort.format(localTime));
		
		System.out.println(localDate.format(dfMedium));
		// Jun 16, 2020
		System.out.println(localDateTime.format(dfMedium));
		// Jun 16, 2020
	}

}
