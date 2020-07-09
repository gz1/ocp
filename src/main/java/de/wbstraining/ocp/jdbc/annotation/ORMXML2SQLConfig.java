package de.wbstraining.ocp.jdbc.annotation;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class ORMXML2SQLConfig extends DefaultHandler {

	private SQLUtilConfig config = new SQLUtilConfig();

	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException {
		if (qName.equals("connection")) {
			handleConnection(attributes);
		} else if (qName.equals("tableMapping")) {
			handleTableMapping(attributes);
		} else if (qName.equals("typeMapping")) {
			handleTypeMapping(attributes);
		}
	}

	private void handleConnection(Attributes attributes) {
		config.setDriver(attributes.getValue("driver"));
		config.setUrl(attributes.getValue("url"));
		config.setUser(attributes.getValue("user"));
		config.setPassword(attributes.getValue("password"));
	}

	private void handleTableMapping(Attributes attributes) {
		String className = attributes.getValue("className");
		String tableName = attributes.getValue("tableName");
		config.putTableMapping(className, tableName);
	}

	private void handleTypeMapping(Attributes attributes) {
		String javaType = attributes.getValue("javaType");
		String sqlType = attributes.getValue("sqlType");
		config.putTypeMapping(javaType, sqlType);
	}

	public SQLUtilConfig xml2Object(String pathToXML) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(false);

		SAXParser parser = factory.newSAXParser();

		XMLReader reader = parser.getXMLReader();

		reader.setErrorHandler(new ErrorHandler() {
			@Override
			public void warning(SAXParseException exception) throws SAXException {
				throw exception;
			}

			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				throw exception;
			}

			@Override
			public void error(SAXParseException exception) throws SAXException {
				throw exception;

			}
		});

		InputSource source = new InputSource(pathToXML);

		config = new SQLUtilConfig();

		reader.setContentHandler(this);
		reader.parse(source);

		return config;
	}
}
