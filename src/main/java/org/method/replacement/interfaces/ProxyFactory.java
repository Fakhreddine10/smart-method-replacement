package org.method.replacement.interfaces;

public interface ProxyFactory {

	public <T> T getProxy(Object proxyClass);
	
	public <T> void addProxy(T proxy);
}
