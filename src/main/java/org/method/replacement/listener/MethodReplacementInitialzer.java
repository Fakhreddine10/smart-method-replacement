package org.method.replacement.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.method.replacement.initializer.SmartMethodReplacementInitializer;
import org.method.replacement.interfaces.Initializer;

public class MethodReplacementInitialzer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
      System.out.println("Context Destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Initializer initializer = new SmartMethodReplacementInitializer();
		initializer.initialize();
	}

}
