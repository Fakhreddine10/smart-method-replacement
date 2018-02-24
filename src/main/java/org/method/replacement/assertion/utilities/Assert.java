package org.method.replacement.assertion.utilities;

import org.method.replacement.exceptions.StringEmptyNotAllowed;

public interface Assert {

	public static void assertNotNull(Object obj, String message) {
		if (obj == null)
			throw new NullPointerException(message);
	}

	public static void assertStringNotEmpty(String obj, String message) {
		if (obj.isEmpty())
			throw new StringEmptyNotAllowed(message);
	}
}
