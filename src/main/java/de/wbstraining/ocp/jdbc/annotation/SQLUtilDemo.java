package de.wbstraining.ocp.jdbc.annotation;

public class SQLUtilDemo {

	public static void main(String[] args) throws Exception {
		
		SQLUtil sqlUtil = new SQLUtil("src/main/resources/io/myorm.xml");
		
		String sql = sqlUtil.class2TableDefinition(
				"de.wbstraining.ocp.jdbc.annotation.BuchGZ1");
		System.out.println(sql);
		
		// sqlUtil.createTables();
	}
}
