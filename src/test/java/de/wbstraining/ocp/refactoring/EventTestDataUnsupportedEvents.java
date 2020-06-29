package de.wbstraining.ocp.refactoring;

import de.wbstraining.ocp.refactoring.bo.Catering;
import de.wbstraining.ocp.refactoring.bo.Duration;
import de.wbstraining.ocp.refactoring.bo.Event;
import de.wbstraining.ocp.refactoring.bo.Music;
import de.wbstraining.ocp.refactoring.bo.Night;
import de.wbstraining.ocp.refactoring.bo.Season;
import de.wbstraining.ocp.refactoring.bo.Theme;

public class EventTestDataUnsupportedEvents {

	public static Event concertNotLive(){
		Event result = new Event();
		result.setTheme(Theme.CONCERT);
		result.setMusic(Music.DG);		
		return result;
	}
	
	public static Event classicConcertWithPicNic(){
		Event result = new Event();
		result.setTheme(Theme.CONCERT);
		result.setMusic(Music.ORCHESTER);
		result.setCatering(Catering.PICNIC);
		return result;
	}
	
	public static Event hikingForAMonth(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SUMMER);
		result.setDuration(Duration.ONE_MONTH);
		return result;
	}
	
	public static Event halfdayHikeFall(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.FALL);
		result.setDuration(Duration.UPTO_ONE_DAY);
		result.setCatering(Catering.PICNIC);
		return result;
	}
	
	public static Event halfdayHikeMenue(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SUMMER);
		result.setDuration(Duration.UPTO_ONE_DAY);
		result.setCatering(Catering.MENUE);
		return result;
	}
	
	public static Event weekendHikeMountainHotel(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SPRING);
		result.setDuration(Duration.WEEKEND);
		result.setNight(Night.HOTEL);
		return result;
	}
	
	public static Event sightseeingLondonMountainHut(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_CITY);
		result.setDuration(Duration.WEEKEND);
		result.setNight(Night.MOUNTAIN_HUT);
		return result;
	}
}
