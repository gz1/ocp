package de.wbstraining.ocp.jdbc.dao;

public class CreateBuchDemo {

	public static void main(String[] args) {
		DAOFactory.getBuchDAO().create(
				new Buch("978-3866475601", "herman melville", "bartleby", 7.00));
	}

}
