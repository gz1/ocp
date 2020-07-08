package de.wbstraining.ocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc20?" + "useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "mysql";
		String sql = "SELECT isbn, autor, " + "preis FROM buch WHERE preis > ?";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setDouble(1, 20.0);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.printf("%-20s%-20s %5.2f%n", rs.getString("isbn"), rs.getString("autor"),
							rs.getDouble("preis"));
				}
			} catch (SQLException sqle) {
				conn.rollback();
				conn.setAutoCommit(true);
				System.out.println("rolling back...");
				throw sqle;
			}
			conn.setAutoCommit(true);
		}
	}
}