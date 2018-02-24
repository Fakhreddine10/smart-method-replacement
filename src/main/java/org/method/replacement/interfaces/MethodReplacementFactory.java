package org.method.replacement.interfaces;

import org.method.replacement.context.MethodReplacementContext;

public interface MethodReplacementFactory {

	public void addMethodReplacementImplemntation(MethodReplacementContext methodReplacementContext,
			MethodReplacer methodReplacor);
	
	public MethodReplacer getMethodReplacementImplemntation(MethodReplacementContext methodReplacementContext);

}
