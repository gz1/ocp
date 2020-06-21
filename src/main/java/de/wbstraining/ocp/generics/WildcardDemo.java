package de.wbstraining.ocp.generics;

import java.util.ArrayList;
import java.util.List;


class Frucht {
}

class Apfel extends Frucht {
}

class Birne extends Frucht {
}

public class WildcardDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Frucht> fruechte = new ArrayList<>();
		
		// auf extendsFruechte darf jede list zugewiesen werden,
		// deren element-typ Frucht oder ein subtyp von Frucht ist
		List<? extends Frucht> extendsFruechte = new ArrayList<>();
		
		// auf superFruechte darf jede list zugewiesen werden,
		// deren element-typ Frucht oder ein supertyp von Frucht ist
		List<? super Frucht> superFruechte = new ArrayList<>();
		fruechte.add(new Apfel()); // ok
		fruechte.add(new Birne()); // ok
		
		List<Birne> birnen = new ArrayList<>();
		// fruechte = birnen; // compilerfehler
		// extendsFruechte.add(new Birne()); // compilerfehler
		extendsFruechte.add(null); // ok
		Frucht frucht = extendsFruechte.get(0); // ok
		superFruechte.add(new Birne()); // ok
		superFruechte.add(null);
		// frucht = superFruechte.get(0); // compilerfehler
		Object o = superFruechte.get(0); // ok
	}
}