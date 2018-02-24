package org.method.replacement.interfaces;

import java.lang.reflect.Method;

public interface MethodReplacer {

	
	Object reimplement(Object obj, Method method, Object[] args) throws Throwable;
}
