package de.wbstraining.ocp.nested_classes;

public class MemberDemo1 {
	int n;
	static int sn;

	void m1() {
	}

	public class Inner1 {
		void m1() {
			n = 3;
			sn = 4;
			MemberDemo1.this.m1();
		}
	}
	
	// compilerfehler!
	static void m10() {
		// Inner1 inner1 = new Inner1();
	}
	
	// compiliert!
	void m11() {
		@SuppressWarnings("unused")
		Inner1 inner1 = new Inner1();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MemberDemo1 demo1 = new MemberDemo1();
		Inner1 inner1 = demo1.new Inner1();
		// die folgende zeile compiliert nicht, weil
		// die main()- methode static ist und damit
		// kein impliziter objekt-bezug gegeben ist.
		
		// sie würde compiliert werden, wenn die methode main()
		// nicht static wäre!
		
		// Inner1 inner2 = new Inner1();
		MemberDemo1.Inner1 demo2 = new MemberDemo1().new Inner1();
	}
}