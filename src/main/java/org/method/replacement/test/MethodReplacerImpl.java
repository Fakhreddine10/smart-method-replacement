package org.method.replacement.test;

import java.lang.reflect.Method;

import org.method.replacement.interfaces.MethodReplacer;

public class MethodReplacerImpl implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {

		
		System.out.println("Test");
		return "test Done";
	}

}
