package de.wbstraining.ocp.date_time;

import java.time.LocalTime;

public class LocalTimeDemo {
	public static void main(String[] args) {
		LocalTime time = LocalTime.of(1, 2);
		System.out.println(time);
		// 01:02
		time = time.plusHours(1).plusMinutes(2).plusNanos(3);
		System.out.println(time);
		// 02:04:00.000000003
	}
}