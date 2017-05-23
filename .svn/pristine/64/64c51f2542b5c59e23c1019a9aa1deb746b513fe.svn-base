package org.eda1.actividad04.ejercicio03;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class ThesaurusTester {

	protected Thesaurus thesaurus;

	public ThesaurusTester() {
		thesaurus = new Thesaurus();
	}

	public void constructThesaurus(String fileName) {
		try {
			Scanner f = new Scanner(new FileReader(new File(fileName)));

			while (f.hasNextLine()) {
				String linea = f.nextLine();
				Scanner l = new Scanner(linea);
				String key;
				key = l.next();
				thesaurus.add(key);
				while (l.hasNext()) {
					String palabra = l.next();
					thesaurus.add(key, palabra);
				}
				l.close();
			}

			f.close();

		} catch (Exception e) {
			System.out.println("Error en la carga del Diccionario");
		}

	}
	
	public void printSynonyms(){
		
	}
	
	public String showThesaurus(){
		return thesaurus.showThesaurus();
	}
	
	public void add (String line){
		thesaurus.add(line);
	}
	
	public void add (String word, String synonym){
		thesaurus.add(word, synonym);
	}
	
	public TreeSet remove (String word){
		return thesaurus.remove(word);
	}
	
	public boolean remove (String word, String synonym){
		return thesaurus.remove(word, synonym);
	}
	
	public TreeSet <String> update (String word, LinkedList<String> synonyms){
		return thesaurus.update(word, synonyms);
	}
	
	public int size(){
		return thesaurus.size();
	}
	
	public TreeSet<String> getSynonymous(String word){
		return thesaurus.getSynonymous(word);
	}
	
	public int size(String word){
		return thesaurus.size(word);
	}
	
	public boolean isSynonymousOf(String word, String synonym){
		return thesaurus.isSynonymousOf(word, synonym);
	}
	
	public boolean isSynonymous(String synonym){
		return thesaurus.isSynonymous(synonym);
	}
	
	public boolean hasSynonymous (String word){
		return thesaurus.hasSynonymous(word);
	}
	
}
