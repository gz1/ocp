package de.wbstraining.ocp.nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyUsingResolveSiblingDemo {
	public static void main(String[] args) throws IOException {
		Path src = Paths.get("src/main/resources/io/buchexemplare.txt");
		Path dst = Paths.get("buchexemplare2.txt");
		try {
			Files.copy(src, src.resolveSibling(dst), StandardCopyOption.REPLACE_EXISTING);
		} catch (FileAlreadyExistsException e) {
			System.out.println(e);
		} catch (NoSuchFileException e) {
			System.out.println(e);
		}
	}
}