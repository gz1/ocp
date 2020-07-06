package de.wbstraining.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToRealPathDemo {
	public static void main(String[] args) {
		// - wirft checked exception IOException!
		// - die angegebene datei m u s s existieren!
		// - normalisierung!
		// - umwandlung in absoluten pfad
		// (nach vorheriger normalisierung)!
		// - symbolischen links wird per default gefolgt!
		// - das kann mit dem argument
		// LinkOption.NOFOLLOW_LINKS geändert werden!
		Path p1 = Paths.get("src/main/resources/io/buchexemplare2.txt");
		Path p2 = Paths.get("./src/../src/main/resources/io/buchexemplare.txt");
		try {
			Files.deleteIfExists(p1);
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			Path p11 = p1.toRealPath();
			System.out.println(p11);  // exception
		} catch (IOException e) {
			// System.out.println(e);
			e.printStackTrace();
		}
		try {
			Path p21 = p2.toRealPath();
			System.out.println(p21);
			System.out.println(p21.toAbsolutePath().normalize());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}