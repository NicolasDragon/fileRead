package org.fileread;

import java.io.File;
import java.security.InvalidParameterException;

/**
 * class in charge of parameter Controls only accessible from same package
 * 
 * @author MSI
 *
 */
class SampleFileReaderParameterControls {
	private static final String FILE_PATH_CAN_NOT_BE_NULL = "filePath can not be null";
	private static final String FILE_PATH_MUST_BE_ABSOLUTE = "filePath must be absolute";

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

	/**
	 * 
	 * @param filePath
	 */
	private static void controlFilePathIsAbsolute(final String filePath) {
		File file = new File(filePath);
		if (!file.isAbsolute()) {
			throw new InvalidParameterException(FILE_PATH_MUST_BE_ABSOLUTE);
		}
	}

	private static void controlFilePathIsNotNull(final String filePath) {
		if (filePath == null) {
			throw new InvalidParameterException(FILE_PATH_CAN_NOT_BE_NULL);
		}
	}

}
