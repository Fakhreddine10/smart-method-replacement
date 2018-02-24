package org.method.replacement.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.method.replacement.context.MethodReplacementContext;
import org.method.replacement.factory.MethodReplacementContextFactory;
import org.method.replacement.factory.MethodReplacementImplementationFactory;
import org.method.replacement.interfaces.ContextFactory;
import org.method.replacement.interfaces.MethodReplacementFactory;
import org.method.replacement.interfaces.MethodReplacer;

public class MethodCallInterceptor implements InvocationHandler {
	private static ContextFactory contextFactory = new MethodReplacementContextFactory();
	private static MethodReplacementFactory methodReplacementFactory = new MethodReplacementImplementationFactory();
	private Object realObject;

	public MethodCallInterceptor(Object realObject) {
		this.realObject = realObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MethodReplacementContext methodReplacementContext = contextFactory.newContext(method);
		MethodReplacer methodReplacer = methodReplacementFactory
				.getMethodReplacementImplemntation(methodReplacementContext);
		if (methodReplacer != null)
			return methodReplacer.reimplement(realObject, method, args);

		return method.invoke(realObject, args);
	}

}
