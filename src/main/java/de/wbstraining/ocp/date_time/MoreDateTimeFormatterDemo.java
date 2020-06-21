package de.wbstraining.ocp.date_time;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class MoreDateTimeFormatterDemo {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("'aktuelles datum: 'dd.MM.yyyy");
		String text = date.format(formatter1);
		System.out.println(text);
		try {
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("aktuelles datum: dd.MM.yyyy");
			text = date.format(formatter2);
			System.out.println(text);
		} catch (DateTimeException e) {
			// java.lang.IllegalArgumentException:
			// Unknown pattern letter: t
			System.out.println(e);
		}
	}
}