package de.wbstraining.ocp.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStoreDemo {
	public static void main(String[] args) throws IOException {
		String s = "src/wbs/nio/misc/FileStoreDemo.java";
		Path path = Paths.get(s);
		for (FileStore fileStore : path.getFileSystem().getFileStores()) {
			System.out.println(fileStore.name() + "," + fileStore.getTotalSpace() + "," + fileStore.getUsableSpace());
		}
	}
}