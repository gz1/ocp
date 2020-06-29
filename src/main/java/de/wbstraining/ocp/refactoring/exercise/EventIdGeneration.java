package de.wbstraining.ocp.refactoring.exercise;

import de.wbstraining.ocp.refactoring.bo.Catering;
import de.wbstraining.ocp.refactoring.bo.Event;
import de.wbstraining.ocp.refactoring.bo.Music;
import de.wbstraining.ocp.refactoring.bo.Night;
import de.wbstraining.ocp.refactoring.bo.Season;
import de.wbstraining.ocp.refactoring.bo.Theme;

public class EventIdGeneration {
	private static final String HALFDAY = "HALFDAY";
	private static final String WEEKEND = "WEEKEND";
	private static final String HIKE = "HIKE";
	private static final String _SELF = "_SELF";
	private static final String _PICNIC = "_PICNIC";
	private static final String _DINNER = "_DINNER";
	private static final String _CAMPING = "_CAMPING";
	private static final String _HUT = "_HUT";
	private static final String SNOWBOARD = "SNOWBOARD";
	private static final String SIGHTSEEING = "SIGHTSEEING";
	private static final String LONDON = "LONDON";
	private static final String ROCK = "ROCK";
	private static final String CLASSIC = "CLASSIC";
	private static final String CONCERT = "CONCERT";
	private static final String UNSUPPORTED_EVENT = "UNSUPPORTED_EVENT";

	public void addEventId(Event event) {
		String result = UNSUPPORTED_EVENT;
		StringBuffer id = new StringBuffer(event.getTheme().toString());
		event.setEventId(result);
		
		if((null != event.getTheme() && event.getTheme().equals(Theme.TRIP_CITY)&& null != event.getNight() && event.getNight().equals(Night.MOUNTAIN_HUT))|| (null!= event.getMusic() && event.getMusic().equals(Music.ORCHESTER))&& event.getCatering() != null && event.getCatering().equals(Catering.PICNIC)) {
			return;
		}
		if(null != event.getMusic() && event.getMusic().equals(Music.DG)) {return;}else {
		if(null != event.getNight() && event.getNight().equals(Night.CAMPING)) {event.setEventId(WEEKEND+HIKE+_CAMPING);return;}else if(null != event.getMusic() && event.getMusic().equals(Music.ORCHESTER)&& null != event.getCatering() && !event.getCatering().equals(Catering.MENUE)){event.setEventId(CLASSIC+CONCERT);return;}else {
		if(event.getCatering() != null && event.getCatering().equals(Catering.NONE)&& event.getMusic() == null) {event.setEventId(HALFDAY+HIKE+_SELF); return;}
		if(event.getCatering() != null && event.getCatering().equals(Catering.PICNIC)){
				if( event.getMusic() != null && event.getMusic().equals(Music.ORCHESTER)) {
			event.setEventId(UNSUPPORTED_EVENT);
			return;
		}else {
			if(null != event.getSeason() && !event.getSeason().equals(Season.FALL)) {event.setEventId(HALFDAY+HIKE+_PICNIC);
			return;}
		}}
		if(event.getCatering() != null && event.getCatering().equals(Catering.MENUE) && event.getMusic() != null && event.getMusic().equals(Music.ORCHESTER)) {
			if(event.getCatering().equals(Catering.PICNIC)) {event.setEventId(UNSUPPORTED_EVENT); return;}
			event.setEventId(CLASSIC + CONCERT + _DINNER);
			return;
			}else if(event.getCatering() != null && event.getCatering().equals(Catering.NONE)) {event.setEventId(HALFDAY+HIKE+_SELF); return;}
		if(event.getSeason() != null && event.getSeason().equals(Season.FALL)) {event.setEventId(UNSUPPORTED_EVENT);return;}
		if(null != event.getTheme() && !event.getTheme().equals(Theme.TRIP_OUTDOOR) && (null != event.getCatering() && (event.getCatering().equals(Catering.BUFFET) || event.getCatering().equals(Catering.BARBEQUE)) 
				&& event.getMusic() != null && !event.getMusic().equals(Music.SOLO))) {
				if(event.getMusic().equals(Music.BAND)) {
					event.setEventId(ROCK+ CONCERT);
				} else if(event.getCatering().equals(Catering.MENUE) && event.getMusic().equals(Music.ORCHESTER)) {
					event.setEventId(CLASSIC + CONCERT + _DINNER);
					return;
				}
			event.setEventId(UNSUPPORTED_EVENT);
			return;
		} else {
			
		
		if(null != event.getCatering() && event.getCatering().equals(Catering.PICNIC)) {
			event.setEventId(WEEKEND + HIKE + _PICNIC);
			return;
		}if(null != event.getNight() && event.getNight().equals(Night.MOUNTAIN_HUT) && null != event.getSeason() && !event.getSeason().equals(Season.WINTER)) {
			event.setEventId(WEEKEND + HIKE + _HUT
					);
			return;
		}else if(event.getMusic() != null && event.getMusic().equals(Music.ORCHESTER) ) {
			event.setEventId(CLASSIC + CONCERT);
			return;
		}else if(null != event.getSeason() && event.getSeason().equals(Season.WINTER)) {
			event.setEventId(WEEKEND + SNOWBOARD + _HUT);return;
		}
		
		if(event.getMusic() != null && !event.getMusic().equals(Music.DG) && !event.getMusic().equals(Music.NONE) && !event.getMusic().equals(Music.ORCHESTER)) {
			event.setEventId(ROCK + CONCERT);
			return;
		}
		
		if(Night.CAMPING.equals(event.getNight())) {
			event.setEventId(WEEKEND + HIKE + _CAMPING);
		}else if(event.getTheme().equals(Theme.TRIP_CITY)) {
			event.setEventId(WEEKEND + SIGHTSEEING + LONDON);return;
		}else if(event.getCatering() != null && event.getCatering().equals(Catering.NONE) && event.getMusic() != null && !event.getMusic().equals(Music.ORCHESTER)) {
			event.setEventId(HALFDAY + HIKE + _SELF);
			return;
		}
		
		if(event.getTheme().equals(Theme.CONCERT) && event.getMusic().equals(Music.ORCHESTER)) { 
			if(!event.getCatering().equals(Catering.BARBEQUE)) {
				String key = CLASSIC + event.getTheme().toString();
				if(!event.getCatering().equals(Catering.NONE)) {
					event.setEventId(key + _DINNER);
					}else {
					event.setEventId(key);}
				return;
			}
		}	
		
		if(!Catering.BUFFET.equals(event.getCatering()) && !Catering.BARBEQUE.equals(event.getCatering())) {
				id.append(UNSUPPORTED_EVENT);
			event.setEventId(result);
		} else if(Catering.BUFFET.equals(event.getCatering())) {
			
		}
		
	}}}}
}
