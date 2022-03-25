package reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class TextReader {
	final private Path file;
	final private Pattern validLine = Pattern.compile(".*:.*:(NOUN|VERB|ADJECTIVE|PHRASE|N|V|A|P)", Pattern.CASE_INSENSITIVE);
	
	public TextReader(Path path) {
		this.file = path;
	}
	
	private boolean checkIfLineIsValid(String s) {
		return validLine.matcher(s).matches();
	}
	
	private String getLineAfterComment(String lineWithComment, int position, Path path) {
		final String[] lineParts = lineWithComment.split("\\*\\/");
		if (lineParts.length > 2 || lineParts.length < 1) {
			System.out.println("Invalid line at line " + position + " in file " + path); //create an exception later
		}
		return lineParts[1];
	}
	
	public FrenchEnglishPair[] parse() {
		final ArrayList<FrenchEnglishPair> words = new ArrayList<>();
		
		try (final BufferedReader reader = Files.newBufferedReader(file)) {
			String line;
			int position = 0;
			boolean isInComment = false;

			while ((line = reader.readLine()) != null) {
				position++;
				
				if (position == 1) {
					if (line.startsWith("<")) {
						continue;
						//get metadata
					}
				}
				
				if (line.startsWith("/*")) { 
					isInComment = true; 
					continue; 
				}
				if (line.contains("*/")) { 
					isInComment = false; 
					if (line.length() == 2) {
						continue; 
					} else {
						line = getLineAfterComment(line, position, file);	
					}

				}
				if (isInComment) { continue; }
				if (line.startsWith("//")) { continue; }
				
				if (!checkIfLineIsValid(line)) {
					System.out.println("Invalid line at line " + position + " in file " + file); //create an exception later
					continue;
				}
				
				line = line.replaceAll("_", " ");
				String[] parts = line.split(":");
				
				if (parts[0].startsWith(" ") || parts[1].startsWith(" ")) {
					System.out.println("Warning! In line " + position + ", a part starts with a space in file " + file); //create a warning
				}
				
				words.add(new FrenchEnglishPair(parts[0], parts[1], TYPE.determineType(parts[2].toLowerCase())));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return words.toArray(new FrenchEnglishPair[0]);
	}
}
