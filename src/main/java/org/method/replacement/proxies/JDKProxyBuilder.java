package org.method.replacement.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.method.replacement.interceptor.MethodCallInterceptor;
import org.method.replacement.interfaces.ProxyBuilder;

public class JDKProxyBuilder implements ProxyBuilder {

	@Override
	public Object creteProxy(Class<?> objectToProxied, InvocationHandler invocationHandlerInstance) {
	   Object proxy= Proxy.newProxyInstance(MethodCallInterceptor.class.getClassLoader(),
				new Class[] { objectToProxied }, invocationHandlerInstance);
		return proxy;
	}

}
