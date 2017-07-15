package org.fileread;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SampleFileReaderTest {

	private static final String AAA_BBB_CCC = "aaa,bbb,ccc";

	@Test
	public void readFileCase00Test() {

		/* GIVEN */
		String fileName = getClass().getClassLoader().getResource("testCase01.csv").getPath();
		SampleFileReader sampleFileReader = new SampleFileReader(fileName);

		/* WHEN */
		List<String> result = sampleFileReader.readFile();

		/* THEN */
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(AAA_BBB_CCC, result.get(0));
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
		SampleFileReader sampleFileReader = new SampleFileReader(fileName);

		/* WHEN */
		String result = sampleFileReader.getFirstLine();
		/* THEN */
		assertEquals(AAA_BBB_CCC, result);
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
		SampleFileReader sampleFileReader = new SampleFileReader(fileName);

		/* WHEN */
		String result = sampleFileReader.getFirstLine();
		/* THEN */
		assertEquals(null, result);
	}

	@Test
	public void readFileStreamCase00Test() throws Exception {

		/* GIVEN */
		File file = new File("src/test/resources/testCase01.csv");
		String absolutePath = file.getAbsolutePath();
		SampleFileReader sampleFileReader = new SampleFileReader(absolutePath);
		/* WHEN */
		Stream<String> result = sampleFileReader.readFileStream();

		/* THEN */
		List<String> resultList = result.collect(Collectors.toList());
		Assert.assertNotNull(result);
		Assert.assertEquals(AAA_BBB_CCC, resultList.get(0));
	}

	@Ignore(value = "understand difference between getResource.getPath and new File.getAbsolutePath")
	@Test
	public void readFileStreamCase01Test() throws Exception {

		/* GIVEN */
		String filePath = getClass().getClassLoader().getResource("emptyFile.csv").getPath();
		SampleFileReader sampleFileReader = new SampleFileReader(filePath);

		/* WHEN */
		Stream<String> result = sampleFileReader.readFileStream();

		/* THEN */
		List<String> resultList = result.collect(Collectors.toList());
		Assert.assertNotNull(result);
		Assert.assertEquals(AAA_BBB_CCC, resultList.get(0));
	}

	/**
	 *  
	 */
	@Test
	public void getLastLineCase00Test() throws Exception {

		/* GIVEN */
		File file = new File("src/test/resources/getLastLineCase00Test.csv");
		SampleFileReader sampleFileReader = new SampleFileReader(file.getAbsolutePath());
		
		/* WHEN */
		String resut = sampleFileReader.getLastLine();
		
		/* THEN */
		Assert.assertEquals("ddd,eee,fff", resut);
	}
	@Test
	public void getLastLineCase01Test() throws Exception {

		/* GIVEN */
		File file = new File("src/test/resources/getLastLineCase01Test.csv");
		SampleFileReader sampleFileReader = new SampleFileReader(file.getAbsolutePath());
		
		/* WHEN */
		String resut = sampleFileReader.getLastLine();
		
		/* THEN */
		Assert.assertNull( resut);
	}
}
