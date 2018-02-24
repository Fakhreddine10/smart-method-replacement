package org.method.replacement.initializer;

import org.method.replacement.annotation.scanner.MethodReplacementAnnotationHandler;
import org.method.replacement.interfaces.Initializer;

public class SmartMethodReplacementInitializer implements Initializer {


	@Override
	public void initialize() {
		MethodReplacementAnnotationHandler.initializeMethodReplacementFactory();
	}

}
