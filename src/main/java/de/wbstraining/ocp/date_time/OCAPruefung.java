package de.wbstraining.ocp.date_time;

import java.time.LocalDate;

//  wir ändern nun die klasse OCAPruefung.
//  sie bekommt ein natural ordering.
//  1. sortierkriterium: prüfungsdatum
//  2. sortierkriterium: name

public class OCAPruefung implements Comparable<OCAPruefung> {

	private String name;
	private LocalDate pruefungsDatum;
	private int punktzahl;

	public OCAPruefung(String name, LocalDate pruefungsDatum, int punktzahl) {
		this.name = name;
		this.pruefungsDatum = pruefungsDatum;
		this.punktzahl = punktzahl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPruefungsDatum() {
		return pruefungsDatum;
	}

	public void setPruefungsDatum(LocalDate pruefungsDatum) {
		this.pruefungsDatum = pruefungsDatum;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

	@Override
	public String toString() {
		return "OCAPruefung [name=" + name + ", pruefungsDatum=" + pruefungsDatum + ", punktzahl=" + punktzahl + "]";
	}

	// natural ordering (p, name)
	@Override
	public int compareTo(OCAPruefung pruefung) {
		int diff = Integer.compare(this.punktzahl, pruefung.punktzahl);
		return diff != 0 ? diff : this.name.compareTo(pruefung.name);
	}

}
