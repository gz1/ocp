package de.wbstraining.ocp.refactoring.bo;

public class Event {

	private String eventId;
	
	private Theme theme;

	private Duration duration;
	
	private Catering catering;
	
	private Night night;

	private Music music;
	
	private Season season;
	
	public Event() {
		
	}
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Catering getCatering() {
		return catering;
	}

	public void setCatering(Catering catering) {
		this.catering = catering;
	}

	public Night getNight() {
		return night;
	}

	public void setNight(Night night) {
		this.night = night;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}


	
}
