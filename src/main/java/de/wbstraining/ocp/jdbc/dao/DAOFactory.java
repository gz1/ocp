package de.wbstraining.ocp.jdbc.dao;

public class DAOFactory {

	public static IBuchDAO getBuchDAO() {
		return new JdbcBuchDAO();
	}
}
