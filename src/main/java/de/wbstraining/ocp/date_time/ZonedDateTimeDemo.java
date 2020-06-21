package de.wbstraining.ocp.date_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {
	public static void main(String[] args) {
		LocalDate d = LocalDate.of(2017, 6, 27);
		LocalTime t = LocalTime.of(19, 20); // stunde, minute
		// sie sollten die of()- methoden von ZonedDateTime kennen
		// allen of()- methoden von ZonedDateTime muss eine ZoneId
		// übergeben werden
		ZonedDateTime zdt1 = ZonedDateTime.of(d, t, ZoneId.of("Europe/Berlin"));
		ZonedDateTime zdt2 = ZonedDateTime.of(d, t, ZoneId.of("US/Eastern"));
		System.out.println(zdt1);
		// sie müssen die string-repräsentation von ZonedDateTime-
		// objekten kennen
		// 2017-06-27T19:20+02:00[Europe/Berlin]
		// sie müssen wissen, wie sie daraus die gmt- time ermitteln
		// hier: -2:00 (also 17:20)
		System.out.println(zdt2);
		// 2017-06-27T19:20-04:00[US/Eastern]
		// gmt- time: 23:20
		// sie müssen aus den string-repräsentationen von
		// ZonedDateTime- objekten
		// die zeitdifferenz ermitteln können
		long t1 = zdt1.toEpochSecond();
		long t2 = zdt2.toEpochSecond();
		Duration duration = Duration.ofSeconds(t1 - t2);
		System.out.println(duration.toMinutes());
		// -360
		System.out.println(ZoneId.of("Europe/Berlin").getClass()); // java.time.ZoneRegion
		// der byte-code der klasse ZoneRegion liegt in rt.jar.
		// diese klasse wird von der api-dokumentation nicht angezeigt und ist nicht public.
		// eine anwendung des prinzips der kapselung...
	}
}