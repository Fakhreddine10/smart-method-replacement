package org.method.replacement.annotation.scanner;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.method.replacement.annotation.MethodImplReplacement;
import org.method.replacement.annotation.scanner.PackageScanConfigHandler;
import org.method.replacement.factory.MethodReplacementContextFactory;
import org.method.replacement.factory.MethodReplacementImplementationFactory;
import org.method.replacement.interfaces.ContextFactory;
import org.method.replacement.interfaces.MethodReplacementFactory;
import org.method.replacement.interfaces.MethodReplacer;
import org.reflections.Reflections;

public abstract class MethodReplacementAnnotationHandler {
	private static final List<String> PACKAGESTOBESCANNED = PackageScanConfigHandler.getListOfPackageToBeScanned();
	private static final Reflections SCANNER = new Reflections(PACKAGESTOBESCANNED);
	private static final Set<String> CLASSES = new HashSet<>();
	private static final MethodReplacementFactory METHOD_REPLACEMENT_FACTORY = new MethodReplacementImplementationFactory();
	private static final ContextFactory CONTEXT_FACTORY = new MethodReplacementContextFactory();
	private static final Logger LOGGER = Logger.getLogger(MethodReplacementAnnotationHandler.class.getName());

	private MethodReplacementAnnotationHandler() {
	}

	public static void initializeMethodReplacementFactory() {
		Set<Method> methods = SCANNER.getMethodsAnnotatedWith(MethodImplReplacement.class);
		methods.forEach(method -> {
			CLASSES.add(method.getDeclaringClass().getName());
			METHOD_REPLACEMENT_FACTORY.addMethodReplacementImplemntation(CONTEXT_FACTORY.newContext(method),
					createMethodReplacorInstance(
							method.getAnnotation(MethodImplReplacement.class).methodReplacer().getName()));

		});

	}

	public static Set<String> getClassesToBeProxied() {
		return CLASSES;
	}

	private static MethodReplacer createMethodReplacorInstance(String className) {
		MethodReplacer methodReplacorImpl = null;
		try {
			methodReplacorImpl = (MethodReplacer) Class.forName(className).newInstance();
		} catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
			LOGGER.log(Level.WARNING, "Unable to instantiate MethodReplacer Implementation", e);
		}
		return methodReplacorImpl;

	}

}
