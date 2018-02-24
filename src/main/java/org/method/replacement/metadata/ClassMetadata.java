package org.method.replacement.metadata;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ClassMetadata {

	private List<Class<?>> interfaces;
	private boolean isThereFinalMethod;
	private boolean isThisAFinalClass;

	public ClassMetadata(Class<?> proxiedClass) {
		this.isThisAFinalClass = Modifier.isFinal(proxiedClass.getModifiers());
		this.isThereFinalMethod = isThereFinalMethod(proxiedClass.getMethods());
		this.interfaces = Arrays.asList(proxiedClass.getInterfaces());

	}

	public boolean isThereFinalMethod() {
		return isThereFinalMethod;
	}

	public boolean isThisAFinalClass() {
		return isThisAFinalClass;
	}

	public boolean isJDKProxyWillBeUsed() {
		return !interfaces.isEmpty();

	}

	public boolean isCGLIBProxyWillBeUsed() {
		return interfaces.isEmpty() && !isThisAFinalClass && !isThereFinalMethod;
	}

	private boolean isThereFinalMethod(Method[] methods) {
		for (Method method : methods) {
			if (Modifier.isFinal(method.getModifiers())) {
				return true;
			}
		}
		return false;

	}

}
