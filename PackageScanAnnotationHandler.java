package org.method.replacement.annotation.scanner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.method.replacement.annotation.Scanner;
import org.reflections.Reflections;

public final class PackageScanAnnotationHandler {

	private static final Reflections SCANNER = new Reflections();

	private static List<String> packageToBeScanned;
	

	public static List<String> getListOfPackageToBeScanned() {
		if (packageToBeScanned == null) {
			Set<Class<?>> listOfClassAnnotated = SCANNER.getTypesAnnotatedWith(Scanner.class);
			if (listOfClassAnnotated.size() > 1)
				throw new RuntimeException("you have more than one class which annotated with scanner");
			String[] packages = listOfClassAnnotated.iterator().next().getAnnotation(Scanner.class).packageScan();
			packageToBeScanned = Arrays.asList(packages);
			return packageToBeScanned;
		}
		return packageToBeScanned;
	}

}
