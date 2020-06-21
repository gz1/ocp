package de.wbstraining.ocp.collections;

class A implements Comparable<A> {
	private int n;

	public A(int n) {
		this.n = n;
	}

	@Override
	public int compareTo(A a) {
		return this.n % 2 - a.n % 2;
	}

	@Override
	public String toString() {
		return Integer.toString(n);
	}

	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (o == this) {
			result = true;
		} else if (o != null && o instanceof A) {
			result = ((A) o).n == this.n;
		}
		return result;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public int hashCode() {
		return n;
	}
}