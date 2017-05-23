package org.eda1.practica03.ejercicio03;

import java.io.File;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Concordancia {

	private Pattern identifierPattern;

	public Concordancia(String expresion) {
		identifierPattern = Pattern.compile(expresion); // compilamos el patron
														// con la
														// expresion regular
														// recibida.

	}

	public String concordance(String cadena) {
		TreeMap<String, TreeSet<Integer>> map = new TreeMap<String, TreeSet<Integer>>();
		TreeSet<Integer> aux = new TreeSet<Integer>();
		String identifier;
		Matcher matcher = identifierPattern.matcher(cadena); // a partir del
																// patron creado
																// me permite
																// crear una
																// cariable para
																// hacaer las
																// busquedas en
																// la cadena
		while (matcher.find()) { // mientras haya elementos en la cadena que
									// coinciden con el patron.
			identifier = cadena.substring(matcher.start(), matcher.end()); // cojo
																			// el
																			// trozo
																			// de
																			// cadena
																			// que
																			// coincide.
			aux.add(1); // establezco el numero de linea donde se encuentra
			map.put(identifier, aux); // lo añado al mapa

		}

		return writeConcordance(map);// retorno el resultado del metodo que
										// escribe con el formato indicado en el
										// enunciado
	}

	public String concordance(File filename) { // repito las mismas operaciones
												// que en el metodo anterior,
												// pero para todas las lineas
												// del fichero.
		String cadena = "";
		try {
			Scanner f = new Scanner(filename);
			TreeMap<String, TreeSet<Integer>> map = new TreeMap<String, TreeSet<Integer>>();
			int numLinea = 1; // en este metodo he de conocer la linea que estoy
								// revisando en cada momento.
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String identifier = "";
				Matcher matcher = identifierPattern.matcher(linea);
				TreeSet<Integer> aux;
				while (matcher.find()) {
					identifier = linea
							.substring(matcher.start(), matcher.end());
					aux = map.get(identifier);
					if (aux == null) { // si el identificador no se encuentra en
										// el mapa
						aux = new TreeSet<Integer>(); // creo el TreeSet
					}
					aux.add(numLinea); // añado el numeor de linea al TreeSet
					map.put(identifier, aux); // añado la entrada al mapa con
												// los cambios realizados.
				}
				numLinea++; // paso a la siguiente linea.
			}
			f.close();
			cadena = writeConcordance(map);
		} catch (Exception e) {
			System.out.println("Error en lectura del archivo");
		}

		return cadena;
	}

	/**
	 * Este metodo crea una cadena con el formato del enunciado
	 * 
	 * @param map
	 *            es el TreeMap de TreeSet que tiene la información a escribir
	 * @return la cadena con el formato especificado
	 */
	private String writeConcordance(TreeMap<String, TreeSet<Integer>> map) {
		String cadena = "";
		// para cada entrada ajusto el identificador a 14 espacios y luego le
		// añado la cantidad de lineas donde aparece seguida de todos los
		// numeros de linea.
		for (Entry<String, TreeSet<Integer>> e1 : map.entrySet()) {
			String identifier = e1.getKey();
			while (identifier.length() < 14)
				identifier = identifier + " ";
			cadena = cadena + identifier + e1.getValue().size() + ":";
			for (Integer i : e1.getValue())
				cadena = cadena + "    " + i;
		}
		return cadena;
	}

	/**
	 * A partir de una cadena realiza los calculos necesarios para saber cuantas
	 * palabras coinciden con un patron y cuantas veces en cada linea.
	 * 
	 * @param cadena
	 *            cadena a comprobar
	 * @return la cadena de caracteres con el formato especificado.
	 */
	public String newConcordance(String cadena) {
		TreeMap<String, TreeMap<Integer, Integer>> map = new TreeMap<String, TreeMap<Integer, Integer>>();
		TreeMap<Integer, Integer> aux = new TreeMap<Integer, Integer>();
		// Utilizo un TreeMap que tiene como clave la palabra y como contenido
		// otro TreeMap que tiene como clave el numero de linea donde aparece y
		// como contenido el numero de veces que aparece en esa linea.
		String identifier = "";
		Matcher matcher = identifierPattern.matcher(cadena);
		while (matcher.find()) {
			identifier = cadena.substring(matcher.start(), matcher.end());
			if (!map.containsKey(identifier)) {
				aux.put(1, 1);
				map.put(identifier, aux);
			} else {
				aux = map.get(identifier);
				int cont = aux.get(1).intValue();
				cont++;
				aux.put(1, cont);
				map.put(identifier, aux);
			}
		}

		return newWriteConcordance(map);
	}

	/**
	 * Lo mismo que el metodo anterior (newConcordance (String)) pero
	 * aplicandolo a todas las lineas de un fichero
	 * 
	 * @param filename
	 *            recibe el fichero a analizar
	 * @return devuelve la cadena con el formato esperado.
	 */
	public String newConcordance(File filename) {
		String cadena = "";
		TreeMap<String, TreeMap<Integer, Integer>> map = new TreeMap<String, TreeMap<Integer, Integer>>();
		TreeMap<Integer, Integer> aux;
		// Realiza lo mismo que el metodo Concordance(file) pero en lugar de
		// usar un TreeMap de TreeSet utiliza un TreeMap de TreeMap
		try {
			Scanner l = new Scanner(filename);
			int numLinea = 1;
			while (l.hasNextLine()) {
				String linea = l.nextLine();
				String identifier = "";
				Matcher matcher = identifierPattern.matcher(linea);
				while (matcher.find()) {
					identifier = linea
							.substring(matcher.start(), matcher.end());
					aux = map.get(identifier);
					if (aux == null) { // compruebo si no existe el
										// identificador
						aux = new TreeMap<Integer, Integer>();
						aux.put(numLinea, 1);
						map.put(identifier, aux);
					} else {
						Integer cont = aux.get(numLinea);
						if (cont == null) { // si no existe la linea para ese
											// identificador.
							aux.put(numLinea, 1);
						} else {
							cont++;
							aux.put(numLinea, cont);
						}
						map.put(identifier, aux);
					}
				}
				numLinea++;
			}
			l.close();
			cadena = newWriteConcordance(map);
		} catch (Exception e) {
			System.out.println("Error en la lectura del fichero");
		}
		return cadena;
	}

	/**
	 * Este metodo crea una cadena con el formato del enunciado
	 * 
	 * @param map
	 *            es el TreeMap de TreeMap que contiene la información a
	 *            escribir
	 * @return la cadena con el formato especificado
	 */
	private String newWriteConcordance(
			TreeMap<String, TreeMap<Integer, Integer>> map) {
		String cadena = "";
		TreeMap<Integer, Integer> aux;

		for (Entry<String, TreeMap<Integer, Integer>> e1 : map.entrySet()) {
			String identifier = e1.getKey();
			while (identifier.length() < 14)
				identifier = identifier + " ";
			cadena = cadena + identifier;
			int suma = 0; // Establece el numero de veces que aparece la palabra
			aux = e1.getValue();
			for (Entry<Integer, Integer> e2 : aux.entrySet()) {
				suma = suma + e2.getValue(); // suma el contenido del TreeMap
												// que contiene el numero de
												// veces que aparece la palabra
												// para cada linea
			}
			cadena = cadena + suma + ":";
			for (Entry<Integer, Integer> e2 : aux.entrySet()) {
				cadena = cadena + "    " + e2.getKey() + "(" + e2.getValue()
						+ ")";
			}
			cadena = cadena + "\n";
		}
		return cadena;
	}
}
