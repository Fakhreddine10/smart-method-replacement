package org.method.replacement.interfaces;

import java.lang.reflect.InvocationHandler;

public interface ProxyBuilder {

	
	public Object creteProxy(Class<?> objectToProxied,InvocationHandler invocationHandlerInstance); 
}
