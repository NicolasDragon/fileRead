package org.fileread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleFileReader {
	/* path to the file we want to read */
	private Path absolutePath;

	public SampleFileReader(final String absoluteFilePath) {
		SampleFileReaderParameterControls.controlFilePathParameter(absoluteFilePath);
		String osAppropriatePath = determineGoodAbsoluteFilePath(absoluteFilePath);
		this.absolutePath = Paths.get(osAppropriatePath);
	}

	/**
	 * if linux filePath and we are on a windows os we change the url
	 * 
	 * @param absoluteFilePath
	 * @return file path according to the os
	 */
	private String determineGoodAbsoluteFilePath(final String absoluteFilePath) {
		if (isLinuxFilePath(absoluteFilePath)) {
			return System.getProperty("os.name").contains("indow") ? absoluteFilePath.substring(1) : absoluteFilePath;

		} else {
			return absoluteFilePath;
		}
	}

	/**
	 * say if it's a linux path
	 * 
	 * @param absoluteFilePath
	 * @return
	 */
	private boolean isLinuxFilePath(final String absoluteFilePath) {
		return absoluteFilePath.charAt(0) == "/".charAt(0);
	}

	/**
	 * 
	 * @param absolutePath
	 * @return
	 */
	public List<String> readFile() {
		return readFileLogic();

	}

	/**
	 * read file as a stream . use UTF-8
	 * 
	 * @param absolutePathParam
	 * @return
	 */
	public Stream<String> readFileStream() {
		Stream<String> result = readFileAsStreamLogic();
		return result;
	}

	/**
	 * return stream <br>
	 * 
	 * the stream will be closed with the terminate operation
	 * 
	 * @param absolutePath
	 * @return
	 */
	private Stream<String> readFileAsStreamLogic() {
		Stream<String> result = null;
		try {
			BufferedReader bufferedReader = Files.newBufferedReader(absolutePath);
			result = bufferedReader.lines();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * return the first line of the file <br>
	 * if empty file return null
	 * 
	 * @param fileName
	 * @return first line or null if empty file
	 */
	public String getFirstLine() {
		List<String> linesList = readFileLogic();
		if (linesList.size() == 0) {
			return null;
		}
		return linesList.get(0);

	}

	/**
	 * get Last line of the file TODO check List maximum size
	 * 
	 * @return
	 */
	public String getLastLine() {
		List<String> linesList = readFileLogic();
		if (linesList.size() == 0) {
			return null;
		}
		return linesList.get(linesList.size() - 1);
	}

	/**
	 * 
	 * @param absolutePath
	 * @return
	 */
	private List<String> readFileLogic() {
		List<String> result = new ArrayList<String>();
		BufferedReader br = null;
		FileReader fileReader = null;

		try {
			fileReader = new FileReader(absolutePath.toString());
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
