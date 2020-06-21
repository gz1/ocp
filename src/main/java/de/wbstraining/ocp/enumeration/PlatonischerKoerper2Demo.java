package de.wbstraining.ocp.enumeration;

public class PlatonischerKoerper2Demo {

	/*
	 * wir geben für jede konstante des enum PlatonischerKoerper die anzahl der
	 * ecken, kanten und flächen aus.
	 */
	public static void main(String[] args) {
		for (PlatonischerKoerper2 pk2 : PlatonischerKoerper2.values()) {
			System.out.println(pk2);
		}
	}
}
