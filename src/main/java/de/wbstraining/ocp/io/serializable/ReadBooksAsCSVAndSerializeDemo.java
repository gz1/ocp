package de.wbstraining.ocp.io.serializable;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

import de.wbstraining.ocp.pattern.builder.BuchExemplar;
import de.wbstraining.ocp.pattern.builder.BuchExemplarUtil;

public class ReadBooksAsCSVAndSerializeDemo {

	public static void main(String[] args) throws IOException {

		String csvIn = "src/main/resources/io/buchexemplare.txt";
		String serOut = "src/main/resources/io/buchexemplare.ser";

		List<BuchExemplar> exemplare = BuchExemplarUtil.
				exemplareFromFile(csvIn, "\t+");

		try (ObjectOutput oo = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(serOut)))) {
			for(BuchExemplar exemplar : exemplare) {
				oo.writeObject(exemplar);
			}
		}
	}
}
