package org.method.replacement.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.method.replacement.context.MethodReplacementContext;
import org.method.replacement.interfaces.MethodReplacementFactory;
import org.method.replacement.interfaces.MethodReplacer;

public class MethodReplacementImplementationFactory implements MethodReplacementFactory{

	private static Map<MethodReplacementContext, MethodReplacer> methodReplacementImplMap=new ConcurrentHashMap<>();

	@Override
	public void addMethodReplacementImplemntation(MethodReplacementContext methodReplacementContext,
			MethodReplacer methodReplacor) {
		methodReplacementImplMap.put(methodReplacementContext, methodReplacor);
		
	}

	@Override
	public MethodReplacer getMethodReplacementImplemntation(MethodReplacementContext methodReplacementContext) {
		return methodReplacementImplMap.get(methodReplacementContext);
	}
	
	
	
	
}
