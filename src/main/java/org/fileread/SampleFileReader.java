package org.fileread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleFileReader {
	/**
	 * 
	 * @param absolutePath
	 * @return
	 */
	public List<String> readFile(final String absolutePath) {
		SampleFileReaderControls.controlFilePathParameter(absolutePath);
		return readFileLogic(absolutePath);

	}

	/**
	 * return the first line of the file
	 * 
	 * @param fileName
	 * @return
	 */
	public String getFirstLine(final String fileName) {
		List<String> linesList = readFileLogic(fileName);
		if (linesList.size() == 0) {
			return null;
		}
		return linesList.get(0);

	}

	/**
	 * 
	 * @param absolutePath
	 * @return
	 */
	private List<String> readFileLogic(final String absolutePath) {
		List<String> result = new ArrayList<String>();
		BufferedReader br = null;
		FileReader fileReader = null;

		try {

			fileReader = new FileReader(absolutePath);
			br = new BufferedReader(fileReader);
			result = readEachLineUntilEmptyLine(br);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fileReader != null)
					fileReader.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		return result;
	}

	/**
	 * 
	 * @param br
	 * @return
	 * @throws IOException
	 */
	private List<String> readEachLineUntilEmptyLine(BufferedReader br) throws IOException {
		List<String> result = new ArrayList<String>();
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) {
			result.add(sCurrentLine);
		}
		return result;
	}

}
