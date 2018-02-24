package org.method.replacement.test;

import org.method.replacement.annotation.MethodImplReplacement;

public class ClassTest {

	
	@MethodImplReplacement(methodReplacer=MethodReplacerImpl.class)
	public void message() {
		
	}
}
