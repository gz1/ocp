package de.wbstraining.ocp.jdbc.annotation;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleSaxHandlerDemo {
	public static void main(String[] args) throws IOException, 
			SAXException, ParserConfigurationException {
		String xmlFile = "src/main/resources/io/myorm.xml";
		InputSource source = new InputSource(xmlFile);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(false);
		SAXParser parser = factory.newSAXParser();
		DefaultHandler handler = new SimpleSaxHandler();
		parser.parse(source, handler);
	}
}