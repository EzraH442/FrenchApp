package reader;

import conjugation.GENDER;
import conjugation.TENSE;

public class Metadata {
	private TYPE defaultType;
	private GENDER gender;
	private TENSE tense;
	
	public Metadata(TYPE defaultType) {
		this.defaultType = defaultType;
	}
	public Metadata(TYPE defaultType, TENSE tense) {
		this.defaultType = defaultType;
		this.tense = tense;
	}
	public Metadata(TYPE defaultType, GENDER gender) {
		this.defaultType = defaultType;
		this.gender = gender;
	}
	
	public TYPE getDefaultType() {
		return defaultType;
	}

	public GENDER getGender() {
		return gender;
	}

	public TENSE getTense() {
		return tense;
	}
	
	
}
