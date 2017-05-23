package org.eda1.examenParcialGrupoA.ejercicio02;

public class WordFrequency implements Comparable {

	private String word;
	private int frequency;

	public WordFrequency(String w, int f) {
		word = w;
		frequency = f;
	}

	public WordFrequency(String w) {
		word = w;
		frequency = 1;
	}

	public WordFrequency() {
		word = "";
		frequency = 0;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void incrementFrequency() {
		frequency++;
	}

	public int compareTo(Object other) {
		if (!(other instanceof WordFrequency)) // compruebo que se puede
												// instanciar.
			return -1;
		WordFrequency aux = (WordFrequency) other;
		return word.compareTo(aux.word);
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof WordFrequency))
			return false;
		WordFrequency aux = (WordFrequency) obj;
		return word.equals(aux.word);
	}

	@Override
	public String toString() {
		return "WordFrequency [word=" + word + ", frequency=" + frequency + "]";
	}

}
