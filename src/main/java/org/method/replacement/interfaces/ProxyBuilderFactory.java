package org.method.replacement.interfaces;

public interface ProxyBuilderFactory {

	public <T> ProxyBuilder createProxyBuilder(Class<T> classTobeProxied);
}
