package org.eda1.examenParcialGrupoA.ejercicio02;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.eda1.estructurasdedatos.AVLTree;
import org.eda1.estructurasdedatos.Iterator;

public class ProcessText {

	private AVLTree<WordFrequency> avlWords;

	public ProcessText() {
		avlWords = new AVLTree<WordFrequency>();
	}

	public ProcessText(AVLTree<WordFrequency> avlW) {
		avlWords = avlW;
	}

	public AVLTree<WordFrequency> loadFile(String file) {
		try {
			Scanner f = new Scanner(new File(file));
			while (f.hasNext()) {
				String linea = f.nextLine();
				Scanner l = new Scanner(linea);
				while (l.hasNext()) {
					String palabra = l.next();
					addWrod(palabra);
				}
				l.close();
			}
			f.close();
		} catch (Exception e) {
			System.out.println("Error al cargar el archivo");
		}

		return avlWords;
	}

	public boolean addWrod(String word) {
		word = removeSpecialCharacters(word);
		WordFrequency aux = new WordFrequency(word);
		WordFrequency wf2 = avlWords.find(aux);
		if (wf2 == null) {
			avlWords.add(aux);
			return true;
		} else {
			wf2.incrementFrequency();
			return false;
		}
	}

	public String removeSpecialCharacters(String input) {
		String specialChart = ",.;:_()[]{}<>*+-/=%&$|'\"^¿?!¡0123456789";
		String output = input;
		for (int i = 0; i < specialChart.length(); i++) {
			output = output.replace(String.valueOf(specialChart.charAt(i)), "");
		}
		return output.toLowerCase();
	}

	public int getFrecuencyOfWord(String word) {
		WordFrequency aux = new WordFrequency(word);
		if (avlWords.find(aux) != null)
			return avlWords.find(aux).getFrequency();
		else
			return -1;
	}

	public ArrayList<String> getWordsWithFrequency(int frec) {
		ArrayList<String> lista = new ArrayList<String>();
		Iterator<WordFrequency> it1 = avlWords.iterator();
		while (it1.hasNext()) {
			WordFrequency aux = it1.next();
			if (aux.getFrequency() == frec)
				lista.add(aux.getWord());
		}
		return lista;
	}

}
