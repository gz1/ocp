package de.wbstraining.ocp.jdbc.annotation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SQLUtil {

	private SQLUtilConfig config;

	public SQLUtil(String pathToXML) throws IOException,
		ParserConfigurationException, SAXException {
		// TODO
	}

	public String class2TableDefinition(String className, 
		Map<String, String> tableMappings,
		Map<String, String> typeMappings)
			throws ClassNotFoundException, SQLException {
		// TODO
		return null;
	}
	
	// create table if not exists BuchGZ1(
	// 	 isbn varchar(128),autor varchar(128),titel varchar(128),preis decimal(8,2),
	//	 primary key(isbn)
	// )

	public String class2TableDefinition(String className)
			throws ClassNotFoundException, SQLException {
		// TODO
		return null;
	}

	// erzeugt alle im descriptor aufgelisteten tabellen
	public void createTables() throws SQLException, ClassNotFoundException {
		// TODO
	}
}
