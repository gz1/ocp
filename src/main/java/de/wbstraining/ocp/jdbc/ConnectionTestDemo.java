package de.wbstraining.ocp.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTestDemo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306?" + "useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "mysql";
		Properties props = new Properties();
		props.put("user", user);
		props.put("password", password);
		
		// variante 1 ohne DriverManager
		Driver driver = new com.mysql.cj.jdbc.Driver();
		try (Connection conn = driver.connect(url, props)) {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println(meta.supportsTransactions());
		}
		
		// variante 2 mit DriverManager
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println(meta.supportsTransactions());
		}

	}

}