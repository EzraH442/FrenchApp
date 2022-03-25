package reader;

import java.util.Random;

public class WordGroup {
	private boolean isSelected = false;
	final private FrenchEnglishPair[] words;
	final private String name;
	final Random randomizer = new Random();
	public WordGroup(final FrenchEnglishPair[] words, final String name) {
		this.words = words;
		this.isSelected = false;
		this.name = name;
	}
	
	public FrenchEnglishPair selectRandomWord() {
		return words[randomizer.nextInt(words.length)];
	}
	
	public void setIsSelected(final boolean b) {
		this.isSelected = b;
	}
	public boolean isSelected() {
		return this.isSelected;
	}
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		final StringBuilder s = new StringBuilder("[{name: " + name + "}, {selected: " + isSelected + "}, {words: ");
		for (FrenchEnglishPair word : words) {
			s.append(word.toString());
			s.append(", ");
		}
		s.replace(s.length()-2, s.length(), "}]");
		return s.toString();
	}
}
