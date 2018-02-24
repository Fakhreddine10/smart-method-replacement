package org.method.replacement.factory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.method.replacement.interceptor.MethodCallInterceptor;
import org.method.replacement.interfaces.ProxyBuilder;
import org.method.replacement.interfaces.ProxyBuilderFactory;
import org.method.replacement.interfaces.ProxyFactory;

public class ProxyFactoryImpl implements ProxyFactory {
	private final ConcurrentHashMap<String, Object> proxiesMap = new ConcurrentHashMap<>();
	private final ProxyBuilderFactory proxyBuilderFactory = new ProxyBuilderFactoryImpl();
	private final ProxyFactory proxyFactory = new ProxyFactoryImpl();
	private static final Logger LOGGER = Logger.getLogger(ProxyFactoryImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getProxy(Object proxyClass) {
		T proxy = (T) proxiesMap.get(proxyClass.getClass().getName());
		if (proxy == null) {
			try {
				Class<T> proxiedclass = (Class<T>) Class.forName(proxyClass.getClass().getName());
				ProxyBuilder proxyBuilder = proxyBuilderFactory
						.createProxyBuilder(Class.forName(proxyClass.getClass().getName()));
				proxy = (T) proxyBuilder.creteProxy(proxiedclass, new MethodCallInterceptor(proxyClass));
				proxyFactory.addProxy(proxy);
			} catch (ClassNotFoundException e) {
				LOGGER.log(Level.SEVERE, "Cannot create Proxy instance for" + proxyClass.getClass().getName(), e);
			}
		}
		return proxy;
	}

	@Override
	public <T> void addProxy(T proxy) {
		proxiesMap.put(proxy.getClass().getName(), proxy);

	}

}
