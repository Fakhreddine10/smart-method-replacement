package org.method.replacement.factory;

import java.lang.reflect.Method;

import org.method.replacement.context.MethodReplacementContext;
import org.method.replacement.interfaces.ContextFactory;

public class MethodReplacementContextFactory implements ContextFactory {

	@Override
	public MethodReplacementContext newContext(Method method) {
		MethodReplacementContext methodReplacementContext = new MethodReplacementContext();
		methodReplacementContext.setClassName(method.getDeclaringClass().getName());
		methodReplacementContext.setMethodName(method.getName());
		methodReplacementContext.setReturnedtype(method.getReturnType().getName());
		methodReplacementContext.setArgumentList(method.getParameters());
		methodReplacementContext.setModifier(method.getModifiers());
		return methodReplacementContext;
	}

}
