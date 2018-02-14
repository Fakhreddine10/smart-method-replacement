package org.method.replacement.annotation.scanner;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.method.replacement.annotation.MethodImplReplacement;
import org.method.replacement.annotation.scanner.PackageScanAnnotationHandler;
import org.method.replacement.factory.MethodReplacementContextFactory;
import org.method.replacement.factory.MethodReplacementImplementationFactory;
import org.method.replacement.interfaces.ContextFactory;
import org.method.replacement.interfaces.MethodReplacementFactory;
import org.method.replacement.interfaces.MethodReplacor;
import org.reflections.Reflections;

public class MethodReplacementAnnotationHandler {
	private static final List<String> packagesToBeScanned = PackageScanAnnotationHandler.getListOfPackageToBeScanned();
	private static final Reflections scanner = new Reflections(packagesToBeScanned);
	private static final Set<String> classes = new HashSet<>();
	private static final MethodReplacementFactory METHOD_REPLACEMENT_FACTORY = new MethodReplacementImplementationFactory();
	private static final ContextFactory CONTEXT_FACTORY = new MethodReplacementContextFactory();

	public static void initializeMethodReplacementFactory() {
		Set<Method> methods = scanner.getMethodsAnnotatedWith(MethodImplReplacement.class);
		methods.forEach(method -> {
			classes.add(method.getDeclaringClass().getName());
			METHOD_REPLACEMENT_FACTORY.addMethodReplacementImplemntation(CONTEXT_FACTORY.newContext(method),
					createMethodReplacorInstance(
							method.getAnnotation(MethodImplReplacement.class).methodReplacor().getName()));

		});

	}
	public static Set<String> getClassesToBeProxied(){
		return classes;
	}

	private static MethodReplacor createMethodReplacorInstance(String className) {
		MethodReplacor methodReplacorImpl = null;
		try {
			methodReplacorImpl = (MethodReplacor) Class.forName(className).newInstance();
		} catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return methodReplacorImpl;

	}

}
