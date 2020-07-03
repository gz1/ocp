package de.wbstraining.ocp.io.serializable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import de.wbstraining.ocp.pattern.builder.BuchExemplar;

public class DeserializeBooksDemo {

	// hinweis:
	// die methode available() von BufferedInputStream könnte nützlich sein...

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String serIn = "src/main/resources/io/buchexemplare.ser";
		BuchExemplar exemplar;

		try (BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(serIn));
				ObjectInput oi = new ObjectInputStream(bis)) {
			while(bis.available() != 0) {
				exemplar = (BuchExemplar) oi.readObject();
				System.out.println(exemplar);
			}
		}
	}

}
