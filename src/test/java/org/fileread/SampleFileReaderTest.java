package org.fileread;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SampleFileReaderTest {

	SampleFileReader sampleFileReader = new SampleFileReader();

	@Test
	public void readFileCase00Test() {

		/* GIVEN */
		String fileName = getClass().getClassLoader().getResource("testCase01.csv").getPath();

		/* WHEN */
		List<String> result = sampleFileReader.readFile(fileName);

		/* THEN */
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("aaa,bbb,ccc", result.get(0));
	}



	/**
	 * verify the method returns the first line
	 * 
	 * @throws Exception
	 */
	@Test
	public void getFirstLineCase00Test() throws Exception {
		/* GIVEN */
		String fileName = getClass().getClassLoader().getResource("testCase01.csv").getPath();
		/* WHEN */
		String result = sampleFileReader.getFirstLine(fileName);
		/* THEN */
		assertEquals("aaa,bbb,ccc", result);
	}

	/**
	 * must return null if file is empty
	 * 
	 * @throws Exception
	 */
	@Test
	public void getFirstLineCase01Test() throws Exception {
		/* GIVEN */
		String fileName = getClass().getClassLoader().getResource("emptyFile.csv").getPath();
		/* WHEN */
		String result = sampleFileReader.getFirstLine(fileName);
		/* THEN */
		assertEquals(null, result);
	}
}
