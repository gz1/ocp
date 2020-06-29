package de.wbstraining.ocp.refactoring.solution;

import java.util.Arrays;
import java.util.function.Predicate;

import de.wbstraining.ocp.refactoring.bo.Catering;
import de.wbstraining.ocp.refactoring.bo.Duration;
import de.wbstraining.ocp.refactoring.bo.Event;
import de.wbstraining.ocp.refactoring.bo.Music;
import de.wbstraining.ocp.refactoring.bo.Night;
import de.wbstraining.ocp.refactoring.bo.Season;
import de.wbstraining.ocp.refactoring.bo.Theme;

public class Predicates {

	public static Predicate<Event> rockConcert(){
		return event -> Theme.CONCERT.equals(event.getTheme())
				&& Music.BAND.equals(event.getMusic());
	}
	
	public static Predicate<Event> classicConcert(){
		return event -> Theme.CONCERT.equals(event.getTheme())
				&& Music.ORCHESTER.equals(event.getMusic())
				&& Catering.NONE.equals(event.getCatering());
	}
	
	public static Predicate<Event> classicConcertWithDinner(){
		return event -> Theme.CONCERT.equals(event.getTheme())
				&& Music.ORCHESTER.equals(event.getMusic())
				&& Catering.MENUE.equals(event.getCatering());
	}
	
	public static Predicate<Event> halfdayHikeWithPicNic(){
		return event-> Theme.TRIP_OUTDOOR.equals(event.getTheme())
				&& Arrays.asList(Season.SPRING, Season.SUMMER).contains(event.getSeason())
				&& Duration.UPTO_ONE_DAY.equals(event.getDuration())
				&& Catering.PICNIC.equals(event.getCatering());
	}
	
	public static Predicate<Event> halfdayHikeSelf(){
		return event-> Theme.TRIP_OUTDOOR.equals(event.getTheme())
				&& Arrays.asList(Season.SPRING, Season.SUMMER).contains(event.getSeason())
				&& Duration.UPTO_ONE_DAY.equals(event.getDuration())
				&& Catering.NONE.equals(event.getCatering());
	}
	
	public static Predicate<Event> weekendHikeMountainHut(){
		return event-> Theme.TRIP_OUTDOOR.equals(event.getTheme())
				&& Arrays.asList(Season.SPRING, Season.SUMMER).contains(event.getSeason())
				&& Duration.WEEKEND.equals(event.getDuration())
				&& Night.MOUNTAIN_HUT.equals(event.getNight());
	}
	
	public static Predicate<Event> weekendSnowboard(){
		return event-> Theme.TRIP_OUTDOOR.equals(event.getTheme())
				&& Season.WINTER.equals(event.getSeason())
				&& Duration.WEEKEND.equals(event.getDuration())
				&& Night.MOUNTAIN_HUT.equals(event.getNight());
	}
	
	public static Predicate<Event> weekendHikeMountainCamping(){
		return event-> Theme.TRIP_OUTDOOR.equals(event.getTheme())
				&& Arrays.asList(Season.SPRING, Season.SUMMER).contains(event.getSeason())
				&& Duration.WEEKEND.equals(event.getDuration())
				&& Night.CAMPING.equals(event.getNight());
	}
	
	public static Predicate<Event> sightseeingLondon(){
		return event -> Theme.TRIP_CITY.equals(event.getTheme())
				&& Duration.WEEKEND.equals(event.getDuration())
				&& Night.HOTEL.equals(event.getNight());
	}
}
