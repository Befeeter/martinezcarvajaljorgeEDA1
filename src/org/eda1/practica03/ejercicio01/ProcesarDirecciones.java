package org.eda1.practica03.ejercicio01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ProcesarDirecciones {

	TreeMap<String, TreeMap<String, Integer>> mapa;

	public ProcesarDirecciones() {
		mapa = new TreeMap<String, TreeMap<String, Integer>>();
	}

	public void cargarArchivo(String archivo) {
		try {
			Scanner f = new Scanner(new FileReader(new File(archivo)));

			while (f.hasNextLine()) {
				String linea = f.nextLine();
				Scanner l = new Scanner(linea);
				while (l.hasNext()) {
					String ip = l.next();
					String direccion = l.next();
					TreeMap<String, Integer> tree2 = new TreeMap<String, Integer>();
					tree2.put(direccion, 1);
					if (!mapa.containsKey(ip))
						mapa.put(ip, tree2);
					else {
						if (mapa.get(ip).containsKey(direccion)) {
							int cont = mapa.get(ip).get(direccion);
							cont++;
							mapa.get(ip).put(direccion, cont);
						} else
							mapa.get(ip).put(direccion, 1);
					}
				}
				l.close();
			}
			f.close();

		} catch (Exception e) {
			System.out
					.println("Error en la carga Generacion del archivo de salida");
		}
	}

	public int tamano() {
		return mapa.size();
	}

	public void generarDirecciones(String archivo) throws FileNotFoundException {
		String stringArchivoSalida = "";

		for (Entry<String, TreeMap<String, Integer>> e1 : mapa.entrySet()) {
			TreeMap<String, Integer> mapa2 = e1.getValue();
			stringArchivoSalida = stringArchivoSalida + e1.getKey() + " => {";
			for (Entry<String, Integer> e2 : mapa2.entrySet()) {
				stringArchivoSalida = stringArchivoSalida + e2.toString()
						+ ", ";
			}
			stringArchivoSalida = stringArchivoSalida.substring(0,
					stringArchivoSalida.length() - 2);
			stringArchivoSalida = stringArchivoSalida + "} \n";
		}

		File archivoSalida = new File(archivo);
		PrintWriter pw = new PrintWriter(archivoSalida);

		pw.print(stringArchivoSalida);

		pw.close();

	}

	public void mostrarDirecciones() {

	}

	public void generarIncidencias(String archivo) throws FileNotFoundException {

		String stringArchivoSalida = "";

		for (Entry<String, TreeMap<String, Integer>> e1 : mapa.entrySet()) {
			TreeMap<String, Integer> mapa2 = e1.getValue();
			if (mapa2.size() > 1) {
				stringArchivoSalida = stringArchivoSalida + e1.getKey()
						+ " => {";
				for (Entry<String, Integer> e2 : mapa2.entrySet()) {
					stringArchivoSalida = stringArchivoSalida + e2.toString()
							+ ", ";
				}
				stringArchivoSalida = stringArchivoSalida.substring(0,
						stringArchivoSalida.length() - 2);
				stringArchivoSalida = stringArchivoSalida + "} \n";
			}

		}

		File archivoSalida = new File(archivo);
		PrintWriter pw = new PrintWriter(archivoSalida);

		pw.print(stringArchivoSalida);

		pw.close();
	}

	public void mostrarIncidencias() {

	}

	public ArrayList<String> maquinasConContadorMayorQue(int c) {
		ArrayList<String> lista = new ArrayList<String>();

		for (Entry<String, TreeMap<String, Integer>> e1 : mapa.entrySet()) {
			TreeMap<String, Integer> mapa2 = e1.getValue();
			for (Entry<String, Integer> e2 : mapa2.entrySet()) {
				if (e2.getValue() > c)
					lista.add(e2.getKey());
			}
		}
		return lista;
	}

	public int maquinasConContadorIgualA(int c) {
		int cont = 0;
		for (Entry<String, TreeMap<String, Integer>> e1 : mapa.entrySet()) {
			TreeMap<String, Integer> mapa2 = e1.getValue();
			for (Entry<String, Integer> e2 : mapa2.entrySet()) {
				if (e2.getValue() == c)
					cont++;
			}
		}
		return cont;
	}

	public int valorContador(String direccion, String maquina) {
		return mapa.get(direccion).get(maquina).intValue();
	}

	public ArrayList<String> incidenciasGeneradasPor(String direccion) {
		ArrayList <String> lista = new ArrayList <String> ();
		for (Entry<String, TreeMap<String, Integer>> e1 : mapa.entrySet()) {
			TreeMap <String, Integer> mapa2 = e1.getValue();
			if (mapa2.size() > 1 && e1.getKey().equals(direccion))
				for (Entry<String,Integer> e2: mapa2.entrySet())
					lista.add(e2.getKey());
		}
		return lista;
	}

	public int numeroDeIncidenciasGeneradasPor(String direccion) {

		return incidenciasGeneradasPor(direccion).size();
	}

}
