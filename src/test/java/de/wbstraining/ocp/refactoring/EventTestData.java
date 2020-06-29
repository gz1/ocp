package de.wbstraining.ocp.refactoring;

import de.wbstraining.ocp.refactoring.bo.Catering;
import de.wbstraining.ocp.refactoring.bo.Duration;
import de.wbstraining.ocp.refactoring.bo.Event;
import de.wbstraining.ocp.refactoring.bo.Music;
import de.wbstraining.ocp.refactoring.bo.Night;
import de.wbstraining.ocp.refactoring.bo.Season;
import de.wbstraining.ocp.refactoring.bo.Theme;

public class EventTestData {

	public static Event rockConcert(){
		Event result = new Event();
		result.setTheme(Theme.CONCERT);
		result.setMusic(Music.BAND);		
		return result;
	}
	
	public static Event classicConcert(){
		Event result = new Event();
		result.setTheme(Theme.CONCERT);
		result.setMusic(Music.ORCHESTER);
		result.setCatering(Catering.NONE);
		return result;
	}
	
	public static Event classicConcertWithDinner(){
		Event result = new Event();
		result.setTheme(Theme.CONCERT);
		result.setMusic(Music.ORCHESTER);
		result.setCatering(Catering.MENUE);
		return result;
	}
	
	public static Event halfdayHikeSummerWithPicNic(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SUMMER);
		result.setDuration(Duration.UPTO_ONE_DAY);
		result.setCatering(Catering.PICNIC);
		return result;
	}
	
	public static Event halfdayHikeSpringWithPicNic(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SPRING);
		result.setDuration(Duration.UPTO_ONE_DAY);
		result.setCatering(Catering.PICNIC);
		return result;
	}
	
	public static Event halfdayHikeSummerSelf(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SUMMER);
		result.setDuration(Duration.UPTO_ONE_DAY);
		result.setCatering(Catering.NONE);
		return result;
	}
	
	public static Event halfdayHikeSpringSelf(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SPRING);
		result.setDuration(Duration.UPTO_ONE_DAY);
		result.setCatering(Catering.NONE);
		return result;
	}
	
	public static Event weekendHikeMountainHutSpring(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SPRING);
		result.setDuration(Duration.WEEKEND);
		result.setNight(Night.MOUNTAIN_HUT);
		return result;
	}
	
	public static Event weekendHikeMountainHutSummer(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SUMMER);
		result.setDuration(Duration.WEEKEND);
		result.setNight(Night.MOUNTAIN_HUT);
		return result;
	}
	
	public static Event weekendSnowboard(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.WINTER);
		result.setDuration(Duration.WEEKEND);
		result.setNight(Night.MOUNTAIN_HUT);
		return result;
	}
	
	public static Event weekendHikeMountainCampingSpring(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SPRING);
		result.setDuration(Duration.WEEKEND);
		result.setNight(Night.CAMPING);
		return result;
	}
	
	public static Event weekendHikeMountainCampingSummer(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_OUTDOOR);
		result.setSeason(Season.SUMMER);
		result.setDuration(Duration.WEEKEND);
		result.setNight(Night.CAMPING);
		return result;
	}
	
	public static Event sightseeingLondon(){
		Event result = new Event();
		result.setTheme(Theme.TRIP_CITY);
		result.setDuration(Duration.WEEKEND);
		result.setNight(Night.HOTEL);
		return result;
	}

}
