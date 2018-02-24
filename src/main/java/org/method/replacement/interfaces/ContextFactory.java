package org.method.replacement.interfaces;

import java.lang.reflect.Method;

import org.method.replacement.context.MethodReplacementContext;

public interface ContextFactory {
	
	
	public MethodReplacementContext newContext(Method method);
}
