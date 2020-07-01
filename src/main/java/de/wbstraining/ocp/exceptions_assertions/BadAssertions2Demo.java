package de.wbstraining.ocp.exceptions_assertions;

public class BadAssertions2Demo {

	static int n = 0;

	// nicht ok. assertion hat side effect
	
	public static boolean m1() {
		n = 1;
		return false;
	}

	// assert zum parametercheck von p u b l i c methoden
	// ist nicht "appropriate"
	
	public void m2(String s) {
		assert s.length() > 5; 
	}
	
	// ok... die methode m3() ist private...
	
	private static void m3(String s) {
		assert s.indexOf('1') >= 0; 
	}

	public static void main(String[] args) {
		
		assert m1(); 
		
		// nicht ok. assertion error sollte hier nicht gefangen
		// werden
		
		try {
			m3("xyz");
			
		} catch (AssertionError e) {
			// ein leerer catch-block ist auch nicht ok...
		}
	}
}
