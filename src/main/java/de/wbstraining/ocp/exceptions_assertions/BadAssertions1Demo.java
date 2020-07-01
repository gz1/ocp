package de.wbstraining.ocp.exceptions_assertions;

public class BadAssertions1Demo {

	public static void m1() {
	}

	public static String m2() {
		return "abc";
	}

	public static boolean m3() {
		return false;
	}

	public static void main(String[] args) {
		assert m3(); // ok
		// compilerfehler 
		// m1() liefert keinen wert
		// assert m1(); 
		
		// compilerfehler
		// m2() liefert keinen boolean
		// assert m2(); 
		
		// compilierungsfähig
		// nicht appropriate.
		assert args.length != 0; 
		
		// compilierungsfähig. nicht appropriate.
		assert args.length != 0 : m2(); 
		
		// compilerfehler: m1() liefert keinen
		// assert args.length != 0 : m1(); 
		
	}
}
