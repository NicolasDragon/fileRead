package org.fileread;

import java.security.InvalidParameterException;

import org.junit.Test;

public class SampleFileReaderControlsTest {
	/**
	 * case where fileName is empty
	 */
	@Test(expected = InvalidParameterException.class)
	public void readFileCase01() {
		/* GIVEN */
		String fileName = null;
		/* WHEN */
		SampleFileReaderParameterControls.controlFilePathParameter(fileName);
	}

	/**
	 * case where fileName is Not Absolute
	 */
	@Test(expected = InvalidParameterException.class)
	public void readFileCase02() {
		/* GIVEN */
		String fileName = "../testCase01.csv";
		/* WHEN */
		SampleFileReaderParameterControls.controlFilePathParameter(fileName);
	}

}
