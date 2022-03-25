package app;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import reader.FrenchEnglishPair;
import reader.TextReader;
import reader.WordGroup;

public class Utils {
	final private static Random randomizer = new Random();
	final private static String WORD_FOLDER = "resources/words";
	
	public static void initializePathAndCollectResources() {
		final Map<String, String> env = new HashMap<>();
		URI uri = null;
		try {
			uri = FrenchApp.class.getClassLoader().getResource(WORD_FOLDER).toURI();
		} catch (URISyntaxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		final String[] array = uri.toString().split("!");
		
		try (final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env)) {
			FrenchApp.FILE_PATH = fs.getPath(array[1]);
			getFiles(FrenchApp.FILE_PATH).forEach((path) -> {
				addFileToResources(path);
			});
		} catch (IllegalArgumentException e) {
			FrenchApp.FILE_PATH = Paths.get(uri);
			getFiles(FrenchApp.FILE_PATH).forEach((path) -> {
				addFileToResources(path);
			});
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static ArrayList<Path> getFiles(Path folder) {
		final ArrayList<Path> files = new ArrayList<>();
		
		try (Stream<Path> paths = Files.walk(folder)) {
			paths
				.filter(Files::isRegularFile)
				.forEach(path -> files.add(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return files;
	}
	
	public static void addFileToResources(Path file) {
		TextReader r = new TextReader(file);
		FrenchApp.textResources.put(
				file.getFileName().toString(), 
				new WordGroup(
						r.parse(), 
						file.getFileName().toString())
				);
	}
	
	public static void updateSelectedResources() {
		final List<WordGroup> resources = new ArrayList<>();
		for (Map.Entry<String, WordGroup> entry : FrenchApp.textResources.entrySet()) {
			if (entry.getValue().isSelected()) {
				resources.add(entry.getValue());
			}
		}
		FrenchApp.selectedResources = resources;
	}
	
	public static void createNewResource(Path file) {
		try {
			Files.copy(file, FrenchApp.FILE_PATH.resolve(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
			addFileToResources(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getFileExtension(Path file) {
	    String extention = null;
	    String s = file.getFileName().toString();
	    int i = s.lastIndexOf('.');

	    if (i > 0 &&  i < s.length() - 1) {
	        extention = s.substring(i+1).toLowerCase();
	    }
	    return extention;
	}
	
	public static FrenchEnglishPair selectRandomWord() {
		return FrenchApp.selectedResources.get(randomizer.nextInt(FrenchApp.selectedResources.size())).selectRandomWord();
	}
	
	public static boolean areResourcesSelected() {
		return FrenchApp.selectedResources.size() == 0;
	}
	
	public static Map<String, WordGroup> getResources() {
		return FrenchApp.textResources;
	}
	
	public static void setIsSelectedForWordGroup(String resourceName, boolean selected) {
		FrenchApp.textResources.get(resourceName).setIsSelected(selected);
	}
		
}
