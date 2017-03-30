package diffutils.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class Example {

	/** File separator. */
	protected static final String FS = File.separator;
	/** The base resource path. */
	protected static String BASE_PATH = "src" + FS + "test" + FS + "resources";

	/**
	 * Tries to read the file and split it into a list of lines.
	 * 
	 * @param filename
	 *            The filename as path.
	 * @return A list of lines.
	 */
	public static List<String> fileToLines(String filename) {
		List<String> lines = new LinkedList<>();
		String line = "";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// ignore ... any errors should already have been
					// reported via an IOException from the final flush.
				}
			}
		}
		return lines;
	}
}
