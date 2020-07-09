package de.wbstraining.ocp.jdbc.dao;

import java.util.List;

public interface IBuchDAO {
	
	public void create(Buch buch) throws PersistenceException;
	public List<Buch> findAll() throws PersistenceException;
}
