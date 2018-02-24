package org.method.replacement.annotation.scanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.reflections.Reflections;

public final class PackageScanConfigHandler {

	private static final Reflections SCANNER = new Reflections();

	private static List<String> packageToBeScanned;

	public static List<String> getListOfPackageToBeScanned() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return packageToBeScanned;

	}

}
