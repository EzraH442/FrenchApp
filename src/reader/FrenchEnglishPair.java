package reader;

public class FrenchEnglishPair {	
	final private String frenchWord;
	final private String englishWord;
	TYPE type;

	public FrenchEnglishPair(final String french, final String english, final TYPE type) {
		this.frenchWord = french;
		this.englishWord = english;
		this.type = type;
	}
	
	public String getEnglishWord() {
		return this.englishWord;
	}
	public String getFrenchWord() {
		return this.frenchWord;
	}
	public TYPE getType() {
		return this.type;
	}
	@Override
	public String toString() {
		return this.frenchWord + " : " + this.englishWord;
	}
}
