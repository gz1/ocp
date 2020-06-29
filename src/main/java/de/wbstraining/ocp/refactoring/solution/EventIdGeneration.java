package de.wbstraining.ocp.refactoring.solution;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import de.wbstraining.ocp.refactoring.bo.Event;

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
	private static final String UNSUPPORTED_EVENT = "UNSUPPORTED_EVENT";
	
	private Map<Predicate<Event>, Function<Event, String>> map = new LinkedHashMap<>();
	
	public EventIdGeneration() {
		initMap();
	}
	
	public Optional<String> eventId(Event event){
		return this.map.entrySet().stream()
		.filter(entry -> entry.getKey().test(event))
		.map(entry -> entry.getValue())
		.map(f -> f.apply(event))
		.findFirst();
	}
	
	public void addEventId(Event event) {
		Optional<String> id = eventId(event);
		id.ifPresent(eventId -> event.setEventId(eventId));
		}
	
	private void initMap() {
		this.map.put(Predicates.rockConcert(), event -> ROCK + event.getTheme().toString());
		this.map.put(Predicates.classicConcert(), event -> CLASSIC + event.getTheme().toString());
		this.map.put(Predicates.classicConcertWithDinner(), event -> CLASSIC + event.getTheme().toString() + _DINNER);
		this.map.put(Predicates.halfdayHikeSelf(), event -> HALFDAY + HIKE + _SELF);
		this.map.put(Predicates.halfdayHikeWithPicNic(), event -> HALFDAY + HIKE + _PICNIC);
		this.map.put(Predicates.weekendHikeMountainCamping(), event -> WEEKEND + HIKE + _CAMPING);
		this.map.put(Predicates.weekendHikeMountainHut(), event -> event.getDuration() + HIKE + _HUT);
		this.map.put(Predicates.weekendSnowboard(), event -> event.getDuration() + SNOWBOARD + _HUT);
		this.map.put(Predicates.sightseeingLondon(), event -> event.getDuration() + SIGHTSEEING + LONDON);
		this.map.put(event -> true, event -> UNSUPPORTED_EVENT);
	}
}