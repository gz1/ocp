package de.wbstraining.ocp.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamDemo {
	public static void main(String[] args) {
		String path = "src/main/resources/io/data_output.data";
		try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readShort());
			System.out.println(dis.readInt());
			System.out.println(dis.readLong());
			System.out.println(dis.readFloat());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
			dis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}