package de.wbstraining.ocp.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Vector;

public class NullAsCollectionElementDemo {
	public static void main(String[] args) {
		new HashSet<String>().add(null); // ok
		new LinkedHashSet<>().add(null); // ok
		// new TreeSet<String>().add(null); NullPointerException
		new HashMap<String, String>().put(null, "abc"); // ok
		// new TreeMap<String, String>().put(null, "abc");
		// NullPointerException
		new HashMap<String, String>().put("abc", null); // ok
		new TreeMap<String, String>().put("abc", null); // ok
		new ArrayList<String>().add(null); // ok
		new LinkedList<String>().add(null); // ok
		new Vector<String>().add(null); // ok
	}
}