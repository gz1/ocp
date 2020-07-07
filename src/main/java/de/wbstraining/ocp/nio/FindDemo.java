package de.wbstraining.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FindDemo {
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("src/main/java");
		BiPredicate<Path, BasicFileAttributes> matcher = (path, attrs) -> {
			return attrs.size() > 100 && attrs.size() < 200;
		};
		Consumer<Path> action = (p) -> {
			System.out.println(p.getFileName() + "(" + p.toFile().length() + ")");
		};
		Files.find(dir, Integer.MAX_VALUE, matcher).forEach(action);
	}
}