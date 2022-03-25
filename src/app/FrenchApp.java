package app;

import java.awt.Dimension;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import reader.WordGroup;

public class FrenchApp {
	static Path FILE_PATH = null;
	
	final static Map<String, WordGroup> textResources = new HashMap<>();
	static List<WordGroup> selectedResources = new ArrayList<>();
	
	static Dimension defaultDimention = new Dimension(700, 800);
	
	static {
		Utils.initializePathAndCollectResources();
	}

	private static void createAndShowGUI() {
		final JFrame frame = new JFrame("French Cards");
		final MainPanel container = new MainPanel();
		
		container.setPreferredSize(defaultDimention);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(defaultDimention);
		
		frame.add(container);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}