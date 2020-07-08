package de.wbstraining.ocp.nio;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class WalkFileTreeDemo {
public static void main(String[] args) {
Path dir = Paths.get(args[0]);
try {
Files.walkFileTree(dir, new MySimpleFileVisitor());
}
catch(IOException ioe) {
ioe.printStackTrace();
}
}
}