package org.eda1.examenSegundoParcialGrupoA.ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Thesaurus {
	
	protected TreeMap<String, TreeSet<String>> thesaurusMap;
	
	public Thesaurus (){
		thesaurusMap = new TreeMap<String, TreeSet<String>> ();
	}

	public void add (String line){
		ArrayList <String> sinonimos = new ArrayList <String> ();
		Scanner l = new Scanner(line);
		String key;
		while (l.hasNext()){
			sinonimos.add(l.next());
		}
		for (int j = 0; j < sinonimos.size(); j++) {
			for (int i = j+1; i < sinonimos.size(); i++) {
				if (i != j)
					add(sinonimos.get(j), sinonimos.get(i)); //añado todos los sinonimos
			}
		}
		l.close();
	}
	
	public void add (String word, String synonym){
		TreeSet<String> s;
		if (thesaurusMap.containsKey(word))
			thesaurusMap.get(word).add(synonym);
		else {
			s = new TreeSet<String> ();
			s.add(synonym);
			thesaurusMap.put(word, s);
		}
		if (thesaurusMap.containsKey(synonym))
			thesaurusMap.get(synonym).add(word);
		else {
			s = new TreeSet<String> ();
			s.add(word);
			thesaurusMap.put(synonym, s);
		}
	}
	
	public TreeSet remove (String word){
		TreeSet removed = null;
		String aux;
		
		removed = thesaurusMap.get(word);
		thesaurusMap.remove(word);
		for (Entry<String,TreeSet<String>> e : thesaurusMap.entrySet()) {
			if (e.getValue().contains(word))
				e.getValue().remove(word);
		}
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
		if(thesaurusMap.containsKey(word))
			return true;
		else
			return false;
	}
	
	public String showThesaurus (){
		String cadena;
		cadena = thesaurusMap.toString();
		return cadena;
	}

	public Thesaurus subThesaurus(String inicio, String fin) {
		Thesaurus thesa = new Thesaurus ();
		for (Entry<String, TreeSet<String>> e : thesaurusMap.entrySet()) {
			if (e.getKey().compareTo(inicio) >=0 && e.getKey().compareTo(fin) <= 0) {
				thesa.thesaurusMap.put(e.getKey(), (TreeSet<String>)e.getValue().clone());
			}
		}
		return thesa;
	}
	
	public String toString() {
		return thesaurusMap.toString();
	}
}
