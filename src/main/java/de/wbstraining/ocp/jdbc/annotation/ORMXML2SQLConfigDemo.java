package de.wbstraining.ocp.jdbc.annotation;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ORMXML2SQLConfigDemo {

	public static void main(String[] args) throws
			ParserConfigurationException, SAXException, IOException {
		
		String pathToXML = "src/main/resources/io/myorm.xml";
		
		ORMXML2SQLConfig handler = new ORMXML2SQLConfig();
		
		SQLUtilConfig config = handler.xml2Object(pathToXML);
		
		System.out.println(config.getDriver());
		System.out.println(config.getUrl());
		System.out.println(config.getUser());
		System.out.println(config.getPassword());
		System.out.println(config.getTableMappings());
		System.out.println(config.getTypeMappings());
	}

}
