package de.wbstraining.ocp.date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class DateTimeFormatterDemo {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		DateTimeFormatter fShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter fMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter fLong = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		DateTimeFormatter fFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		DateTimeFormatter fPattern = DateTimeFormatter.ofPattern("dd. MMMM yyyy");
		System.out.println(date1.format(fShort));
		// 05.06.18
		System.out.println(date1.format(fMedium));
		fMedium.format(date1);
		// 05.06.2018
		System.out.println(date1.format(fLong));
		// 5. Juni 2018
		System.out.println(date1.format(fFull));
		// Dienstag, 5. Juni 2018
		System.out.println(date1.format(fPattern));
		// 05. Juni 2018
		System.out.println("---------");
		LocalDateTime ldt1 = LocalDateTime.now();
		System.out.println(ldt1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		System.out.println(ldt1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
		
		// exception
		// System.out.println(ldt1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));
		
		
		//  exception 
		// System.out.println(ldt1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)));
		 
	}
}