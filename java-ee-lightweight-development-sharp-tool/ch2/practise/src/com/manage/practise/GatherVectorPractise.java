package com.manage.practise;

import java.util.ArrayList;
import java.util.Vector;

public class GatherVectorPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<String> ve = new Vector<String>(10);
		ve.addElement("one");
		ve.addElement("two");
		ve.addElement("three");
		ve.remove(0);
		ve.remove(1);
		ve.remove(2);
	}

}
