package org.fileread;

import java.io.File;
import java.security.InvalidParameterException;

/**
 * class only accessible from same package
 * 
 * @author MSI
 *
 */
class SampleFileReaderControls {
	/**
	 * 
	 * @param filePath
	 */
	private static void controlFilePathIsAbsolute(final String filePath) {
		File file = new File(filePath);
		if (!file.isAbsolute()) {
			throw new InvalidParameterException("filePath must be absolute");
		}
	}

	private static void controlFilePathIsNotNull(final String filePath) {
		if (filePath == null) {
			throw new InvalidParameterException("filePath can not be null");
		}
	}

	/**
	 * control the filePath parameter : <br>
	 * - not null <br>
	 * - is absolute <br>
	 * 
	 * @param filePath
	 * @throws InvalidParameterException
	 */
	public static void controlFilePathParameter(final String filePath) {
		controlFilePathIsNotNull(filePath);
		controlFilePathIsAbsolute(filePath);
	}

}
