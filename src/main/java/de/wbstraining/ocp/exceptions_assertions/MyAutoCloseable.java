package de.wbstraining.ocp.exceptions_assertions;

class MyAutoCloseable implements AutoCloseable {

	private String name;
	private boolean methodThrows;
	private boolean closeThrows;

	public MyAutoCloseable(String name, 
			boolean methodThrows, boolean closeThrows) {
		this.methodThrows = methodThrows;
		this.closeThrows = closeThrows;
		this.name = name;

	}

	@Override
	public void close() throws RuntimeException {
		System.out.println(
			"closing " + name);
		if (closeThrows) {
			throw new RuntimeException(
				"exc in close() from " + name);
		}
	}

	public void m() throws RuntimeException {
		System.out.println("m() in " + name );
		if (methodThrows) {
			throw new RuntimeException(
				"exc in m() from " + name);
		}
	}
}
