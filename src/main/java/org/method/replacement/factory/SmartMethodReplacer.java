package org.method.replacement.factory;

import org.method.replacement.interfaces.ProxyFactory;

public abstract class SmartMethodReplacer {

	private static final ProxyFactory proxyFactory = new ProxyFactoryImpl();

	private SmartMethodReplacer() {

	}

	public static Object getObject(Object obj) {
		return proxyFactory.getProxy(obj);
	}

}
