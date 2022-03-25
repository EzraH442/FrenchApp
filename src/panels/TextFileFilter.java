package panels;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import app.Utils;

public class TextFileFilter extends FileFilter {
	final String ACCEPTED_EXTENTION = "txt";

	public TextFileFilter() {
		
	}
	
	@Override
	public boolean accept(File inputFile) {
		if (inputFile.isDirectory()) { return true; }

	    String extension = Utils.getFileExtension(inputFile.toPath());
	    if (extension == null) { return false; }
	    
	    return extension.equals(ACCEPTED_EXTENTION);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
