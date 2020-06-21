package de.wbstraining.ocp.nested_classes;

public class LocalDemo2 {
	public void m1(int n) {
		@SuppressWarnings("unused")
		class Inner31 {
			int f = n;
			// interface I1 {}
			// enum E1 {A,B,C};
			// static class C1 {}
		}
	}

	public void m2(final int n) {
		@SuppressWarnings("unused")
		class Inner31 {
			int f = n;
		}
	}
}