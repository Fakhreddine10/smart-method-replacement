package org.method.replacement.factory;

import org.method.replacement.exceptions.ProxyCreationException;
import org.method.replacement.interfaces.ProxyBuilder;
import org.method.replacement.interfaces.ProxyBuilderFactory;
import org.method.replacement.metadata.ClassMetadata;
import org.method.replacement.proxies.CGLIBProxyBuilder;
import org.method.replacement.proxies.JDKProxyBuilder;

public class ProxyBuilderFactoryImpl implements ProxyBuilderFactory {

	@Override
	public <T> ProxyBuilder createProxyBuilder(Class<T> classTobeProxied) {
		ProxyBuilder proxyBuilder = null;
		ClassMetadata classMetadata = new ClassMetadata(classTobeProxied);
		if (classMetadata.isJDKProxyWillBeUsed())
			proxyBuilder = new JDKProxyBuilder();
		if (classMetadata.isCGLIBProxyWillBeUsed())
			proxyBuilder = new CGLIBProxyBuilder();
		if (proxyBuilder == null)
			throw new ProxyCreationException("we can't create a proxy for final class or contain final methods");
		return proxyBuilder;
	}

}
