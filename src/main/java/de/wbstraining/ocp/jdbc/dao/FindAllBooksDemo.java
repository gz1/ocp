package de.wbstraining.ocp.jdbc.dao;

public class FindAllBooksDemo {

	public static void main(String[] args) {

		IBuchDAO buchDAO = DAOFactory.getBuchDAO();
		buchDAO.findAll().forEach(System.out::println);
	}
}
