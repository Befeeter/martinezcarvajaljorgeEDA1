package org.eda1.examenSegundoParcial.ejercicio01;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProcesarDatos {

	private TreeMap<String, TreeMap<String, TreeMap<String, DatosCiudad>>> mapa;

	public ProcesarDatos() {
		mapa = new TreeMap<String, TreeMap<String, TreeMap<String, DatosCiudad>>>();

	}

	public void cargarArchivo(String archivo) {
		try {
			Scanner f = new Scanner(new File(archivo));
			while (f.hasNext()) {
				String linea = f.nextLine();
				Scanner l = new Scanner(linea);
				while (l.hasNext()) {
					TreeMap<String, TreeMap<String, DatosCiudad>> proy = new TreeMap<String, TreeMap<String, DatosCiudad>>();
					TreeMap<String, DatosCiudad> ciu = new TreeMap<String, DatosCiudad>();
					TreeSet<String> direcciones = new TreeSet<String>();
					String empresas = l.next();
					String proyectos = l.next();
					String ciudad = l.next();
					String pais = l.next();
					String continente = l.next();
					while (l.hasNext()) {
						String direccion = l.next();
						if (!direcciones.contains(direccion))
							direcciones.add(direccion);
					}

					DatosCiudad datciu = new DatosCiudad(pais, continente,
							direcciones);
					ciu.put(ciudad, datciu);
					if (mapa.get(empresas) == null){
						proy.put(proyectos, ciu);
						if (!mapa.containsKey(empresas))
							mapa.put(empresas, proy);
						else
							mapa.get(empresas).put(proyectos, ciu);
					}
					else {
						if (mapa.get(empresas).get(proyectos) == null){
							if (!mapa.containsKey(empresas))
								mapa.put(empresas, proy);
							else
								mapa.get(empresas).put(proyectos, ciu);
						}
						else
							mapa.get(empresas).get(proyectos)
									.put(ciudad, datciu);
						
					}
					
				}
			}
		} catch (Exception e) {
			System.out.println("Error en la lectura del fichero");
		}

	}

	public int size() {
		return mapa.size();
	}

	/**
	 * implementar la consulta que devuelva las empresas que tienen proyectos en
	 * ciudades europeas
	 * 
	 * @return
	 */

	// TreeMap(Empresas, TreeMap(Proyectos, TreeMap(Ciudades, DatosCiudad)))
	public TreeMap<String, ArrayList<String>> consulta1() {
		TreeMap<String, ArrayList<String>> lista = new TreeMap<String, ArrayList<String>>();
		ArrayList<String> ciudades;

		for (Entry<String, TreeMap<String, TreeMap<String, DatosCiudad>>> e1 : mapa
				.entrySet()) {
			ciudades = new ArrayList<String>();
			for (Entry<String, TreeMap<String, DatosCiudad>> e2 : e1.getValue()
					.entrySet()) {
				for (Entry<String, DatosCiudad> e3 : e2.getValue().entrySet()) {
					if (e3.getValue().continente.contains("Europe")) {
						String cadena = e2.getKey() + "<" + e3.getKey() + "."
								+ e3.getValue().getPais() + "."
								+ e3.getValue().getContinente() + "(";
						int n = 0;
						for (String s : e3.getValue().getDirecciones()) {
							cadena = cadena + s;
							if (n < e3.getValue().getDirecciones().size() - 1)
								cadena = cadena + ", ";
							n++;
						}
						cadena = cadena + ")>";
						ciudades.add(cadena);
					}
				}
			}
			if (ciudades.size() != 0)
				lista.put(e1.getKey(), ciudades);
		}
		return lista;
	}

	/**
	 * consulta que devuelva las empresas y los proyectos asociados a dichas
	 * empresas que estén ubicadas en la misma dirección de una determinada
	 * ciudad.
	 * 
	 * @return
	 */
	// TreeMap(Empresas, TreeMap(Proyectos, TreeMap(Ciudades, DatosCiudad)))
	public TreeMap<String, ArrayList<String>> consulta2() {
		// TreeMap<Calle>,ArrayList<String>>;
		TreeMap<String, ArrayList<String>> nuevo = new TreeMap<String, ArrayList<String>>();
		ArrayList<String> lista;

		for (Entry<String, TreeMap<String, TreeMap<String, DatosCiudad>>> e1 : mapa
				.entrySet()) {
			for (Entry<String, TreeMap<String, DatosCiudad>> e2 : e1.getValue()
					.entrySet()) {
				for (Entry<String, DatosCiudad> e3 : e2.getValue().entrySet()) {
					for (String s : e3.getValue().getDirecciones()) {
						String cadena = s;
						String cadena2 = "(" + e1.getKey() + ", " + e2.getKey()
								+ ")";
						if (!nuevo.containsKey(cadena)) {
							lista = new ArrayList<String>();
							lista.add(e3.getKey());
							lista.add(cadena2);
						} else {
							lista = nuevo.get(cadena);
							lista.add(cadena2);
						}
						nuevo.put(cadena, lista);
					}
				}
			}
		}
		TreeMap<String, ArrayList<String>> nuevo2 = new TreeMap<String, ArrayList<String>>();
		for (Entry<String, ArrayList<String>> e : nuevo.entrySet()) {
			if (e.getValue().size() != 2) {
				nuevo2.put(e.getKey(), e.getValue());
			}
		}
		return nuevo2;
	}
}
