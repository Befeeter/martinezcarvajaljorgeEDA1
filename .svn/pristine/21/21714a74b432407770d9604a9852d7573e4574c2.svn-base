package org.eda1.actividad04.ejercicio02;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SpellCheckerTester {

	protected SpellChecker spellChecker;

	public SpellCheckerTester() {
		spellChecker = new SpellChecker();
	}

	// Load the dictionary from a file.
	public void loadDictionary(String filename) {
		try {
			Scanner f = new Scanner(new FileReader(new File(filename)));

			while (f.hasNextLine()) {
				String linea = f.nextLine();
				spellChecker.dictionarySet.add(linea);
			}

			f.close();
		} catch (Exception e) {
			System.out.println("Error en la carga del Diccionario");
		}
	}

	// add a list of words to dictionarySet.
	public void extendDictionary(LinkedList<String> wordsNoInDictionary) {
		Iterator<String> it1 = wordsNoInDictionary.iterator();
		while (it1.hasNext()) {
			spellChecker.dictionarySet.add(it1.next());
		}
	}

	public void loadDocument(String filename) {
		Pattern patron = Pattern.compile("[^a-zA-Z]+"); // definimos el patro no
														// Alfabetico ni
														// espacios ni signos de
														// puntuacion
		try {
			Scanner f = new Scanner(new FileReader(new File(filename)));

			while (f.hasNextLine()) {
				String linea = f.nextLine();
				Scanner l = new Scanner(linea);
				// System.out.println(linea);
				l.useDelimiter(patron); // establecemos como delimitador el
										// patron establecido.
				while (l.hasNext()) {
					String palabra = l.next();
					// System.out.println(palabra);
					palabra = palabra.toLowerCase();
					spellChecker.documentSet.add(palabra);
				}
			}

			f.close();
		} catch (Exception e) {
			System.out.println("Error en la carga del documento");
		}
	}

	public LinkedList<String> showDifferences() {
		return spellChecker.compare();
	}

	public boolean isInDictionary(String word) {
		return spellChecker.isInDictionary(word);
	}

	public int sizeDictionary() {
		return spellChecker.sizeDictionary();
	}

}
