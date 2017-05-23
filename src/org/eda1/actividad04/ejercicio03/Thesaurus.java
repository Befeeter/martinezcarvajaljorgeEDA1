package org.eda1.actividad04.ejercicio03;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Thesaurus {
	
	protected TreeMap<String, TreeSet<String>> thesaurusMap;
	
	public Thesaurus (){
		thesaurusMap = new TreeMap<String, TreeSet<String>> ();
	}

	public void add (String line){
		TreeSet <String> nuevo = new TreeSet<String> ();
		Scanner l = new Scanner(line);
		String key=l.next();
		while (l.hasNext()){
		nuevo.add(l.next());
		}
		thesaurusMap.put(key, nuevo);
		l.close();
	}
	
	public void add (String word, String synonym){
		thesaurusMap.get(word).add(synonym);
	}
	
	public TreeSet remove (String word){
		TreeSet removed = null;
		String aux;
		
		removed = thesaurusMap.get(word);
		thesaurusMap.remove(word);
		return removed;
	}
	
	public boolean remove (String word, String synonym){
		if (thesaurusMap.get(word).remove(synonym))
			return true;
		else
			return false;
	}
	
	public TreeSet <String> update (String word,LinkedList <String> synonyms){
		TreeSet <String> updated = new TreeSet <String> ();
		Iterator <String> it1 = synonyms.iterator();
		while (it1.hasNext()){
			String synonym = it1.next();
			updated.add(synonym);
		}		
		thesaurusMap.put(word, updated);
		return updated;
	}
	
	public int size (){
		return thesaurusMap.size();
	}
	
	public TreeSet<String> getSynonymous (String word){
		TreeSet<String> synonymous = new TreeSet<String> ();
		synonymous = thesaurusMap.get(word);
		return synonymous;
	}
	
	public int size (String word){
		return thesaurusMap.get(word).size();
	}
	
	public boolean isSynonymousOf(String word,String synonym){
		if (thesaurusMap.get(word) == null)
			return false;
		
		if (thesaurusMap.get(word).contains(synonym))
			return true;
		else
			return false;
	}
	
	public boolean isSynonymous (String synonym){
		return thesaurusMap.containsValue(synonym);
	}
	
	public boolean hasSynonymous (String word){
		if(thesaurusMap.get(word).isEmpty() == true)
			return false;
		else
			return true;
	}
	
	public String showThesaurus (){
		String cadena;
		cadena = thesaurusMap.toString();
		return cadena;
	}
}
