package de.wbstraining.ocp.generics;

class C11 {
}

interface I11 {
}

interface I12 {
}

class GC<T extends C11 & I11 & I12> {
}

class C11Sub1 extends C11 {
}

class C11Sub2 extends C11 implements I11 {
}

class C11Sub3 extends C11 implements I11, I12 {
}

public class TypParameterSectionDemo {
	public static void main(String[] args) {
		// GC<C11Sub1> gc1;
		// GC<C11Sub2> gc2;
		@SuppressWarnings("unused")
		GC<C11Sub3> gc3;
	}
}