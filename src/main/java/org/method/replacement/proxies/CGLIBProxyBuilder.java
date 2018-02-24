package org.method.replacement.proxies;

import java.lang.reflect.InvocationHandler;

import org.method.replacement.interfaces.ProxyBuilder;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class CGLIBProxyBuilder implements ProxyBuilder {
	private Enhancer enhancer = new Enhancer();

	@Override
	public Object creteProxy(Class<?> objectToProxied, InvocationHandler invocationHandlerInstance) {
		enhancer.setSuperclass(objectToProxied);
		enhancer.setCallback((Callback) invocationHandlerInstance);
		return enhancer.create();
	}

}
