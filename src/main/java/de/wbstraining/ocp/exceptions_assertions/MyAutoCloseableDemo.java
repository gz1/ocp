package de.wbstraining.ocp.exceptions_assertions;

public class MyAutoCloseableDemo {

	public static void main(String[] args) {
		try (MyAutoCloseable a1 = new 
			    MyAutoCloseable("a", false, false);
			MyAutoCloseable a2 = new 
				MyAutoCloseable("b", true, true)) {
			a1.m();
			a2.m();
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			for(Throwable t : e.getSuppressed()) {
				System.out.println(t);
			}
		} finally {
			System.out.println("in finally");
		}
	}

}
