package de.wbstraining.ocp.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection connectionByProperties(String pathToPropertiesFile)
			throws IOException, SQLException {
		// TODO
		return null;
	}
	
	// hinweis: zu einlesen des property-files eignet sich die klasse
	// java.util.Properties
	
	
	// inhalt der properties- datei (z.b. main/resources/io/jdbc.properties):
	
	// url=jdbc:mysql://localhost:3306/jdbc20?useUnicode=yes&characterEncoding=UTF-8
	// user=root
	// password=mysql

}
