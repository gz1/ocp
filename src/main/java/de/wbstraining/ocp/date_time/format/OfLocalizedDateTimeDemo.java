package de.wbstraining.ocp.date_time.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class OfLocalizedDateTimeDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		LocalDate localDate = LocalDate.of(2020, Month.JUNE, 16);
		LocalDateTime localDateTime = LocalDateTime.
				of(2020, 6, 16, 9, 30);
		LocalTime localTime = LocalTime.of(9, 30);
		
		DateTimeFormatter dfShort = DateTimeFormatter.
				ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter dfMedium = DateTimeFormatter.
				ofLocalizedDateTime(FormatStyle.MEDIUM);
		
		// System.out.println(localDate.format(dfShort));		
		
		System.out.println(localDateTime.format(dfShort));
		//	6/16/20 9:30 AM
		
		// System.out.println(localTime.format(dfShort));
		
		// System.out.println(dfShort.format(localDate));			
		
		System.out.println(dfShort.format(localDateTime));
		//	6/16/20 9:30 AM	
		
		// System.out.println(dfShort.format(localTime));
		
		System.out.println(dfMedium.format(localDateTime));
		//	Jun 16, 2020 9:30:00 AM	
	}

}
