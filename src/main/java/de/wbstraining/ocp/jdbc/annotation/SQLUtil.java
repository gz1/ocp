package de.wbstraining.ocp.jdbc.annotation;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SQLUtil {

	private SQLUtilConfig config;

	public SQLUtil(String pathToXML) throws IOException,
			ParserConfigurationException, SAXException {
		config = new ORMXML2SQLConfig().xml2Object(pathToXML);
	}

	public String class2TableDefinition(String className, 
		Map<String, String> tableMappings,	Map<String, String> typeMappings)
			throws ClassNotFoundException {
		Class<?> cls = Class.forName(className);
		
		StringBuilder sql = new StringBuilder("create table if not exists ");
		PrimaryKey primaryKey;
		
		NavigableMap<Integer, String> primaryKeys = new TreeMap<>();

		sql.append(tableMappings.get(className)).append("(");

		for (Field field : cls.getDeclaredFields()) {
			if (field.getAnnotation(Column.class) != null) {
				sql.append(field.getName()).append(" ")
						.append(typeMappings
								.get(field.getType().getSimpleName()))
						.append(",");
			}
			if ((primaryKey = field.getAnnotation(PrimaryKey.class)) != null) {
				primaryKeys.put(primaryKey.index(), field.getName());
			}
		}

		sql.append("primary key(");

		for (int i : primaryKeys.keySet()) {
			sql.append(primaryKeys.get(i))
					.append(i < primaryKeys.size() ? "," : "))");
		}
		return sql.toString();
	}
	
	// create table if not exists BuchGZ1(
	// 	 isbn varchar(128),autor varchar(128),titel varchar(128),preis decimal(8,2),
	//	 primary key(isbn)
	// )

	public String class2TableDefinition(String className)
			throws ClassNotFoundException {
		return class2TableDefinition(
			className, config.getTableMappings(), config.getTypeMappings());
	}

	// erzeugt alle im descriptor aufgelisteten tabellen
	public void createTables() throws SQLException, ClassNotFoundException {
		// TODO
	}
}
