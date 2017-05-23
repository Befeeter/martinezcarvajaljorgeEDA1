package org.eda1.actividad04.ejercicio02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class SpellChecker {

	protected TreeSet<String> dictionarySet;
	protected TreeSet<String> documentSet;

	public SpellChecker() {

		dictionarySet = new TreeSet<String>();
		documentSet = new TreeSet<String>();

	}

	// add one word to dictionary.
	public void addToDictionary(String word) {
		dictionarySet.add(word);
	}

	// add a list of words to dictionary.
	public void addToDictionary(LinkedList<String> additionalWords) {
		Iterator<String> it1 = additionalWords.iterator();
		while (it1.hasNext()) {
			dictionarySet.add(it1.next());
		}
	}

	// add a line to document.
	public void addToDocument(String line) {
		documentSet.add(line);
	}

	public LinkedList<String> compare() {
		Iterator<String> it1 = documentSet.iterator();
		LinkedList<String> lista = new LinkedList<String>();
		int aux;
		while (it1.hasNext()) {
			Iterator<String> it2 = dictionarySet.iterator();
			String palabra = it1.next();
			aux = 0;
			while (it2.hasNext()) {
				String palabra2 = it2.next();
				if (palabra.equals(palabra2))
					aux++;
			}
			if (aux == 0)
				lista.add(palabra);

		}
		return lista;
	}

	// return a linkedList with the content of the dictionary treeSet.
	public LinkedList<String> dictionaryToList() {
		LinkedList<String> lista = new LinkedList<String>();
		Iterator<String> it1 = dictionarySet.iterator();
		while (it1.hasNext()) {
			lista.add(it1.next());
		}
		return lista;
	}

	// return a linkedList with the content of the Document TreeSet
	public LinkedList<String> documentToList() {
		LinkedList<String> lista = new LinkedList<String>();
		Iterator<String> it1 = documentSet.iterator();
		while (it1.hasNext()) {
			lista.add(it1.next());
		}
		return lista;
	}

	// return true if the word has on the dictionary.
	public boolean isInDictionary(String word) {
		Iterator<String> it1 = dictionarySet.iterator();
		while (it1.hasNext()) {
			String palabra = it1.next();
			if (word.equals(palabra))

				return true;
		}
		return false;
	}

	public int sizeDictionary() {
		return dictionarySet.size();
	}

}
