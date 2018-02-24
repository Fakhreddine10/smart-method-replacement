package org.method.replacement.test;

import org.method.replacement.initializer.SmartMethodReplacementInitializer;
import org.method.replacement.interfaces.Initializer;

public class TestMain {

	public static void main(String[] args) {

		Initializer initializer = new SmartMethodReplacementInitializer();
		initializer.initialize();
	}

}
