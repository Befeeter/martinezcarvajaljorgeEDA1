package org.eda1.practica02.ejercicio01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

import org.eda1.estructurasdedatos.BSTree;

public class ProcesarDirecciones {

	BSTree<DireccionMaquinas> treeDirecciones;

	public ProcesarDirecciones() {
		treeDirecciones = new BSTree<DireccionMaquinas>();
	}

	public ProcesarDirecciones(BSTree<DireccionMaquinas> treeDirecciones) {
		this.treeDirecciones = treeDirecciones;
	}

	public BSTree<DireccionMaquinas> cargarArchivo(String archivo) {

		treeDirecciones = new BSTree<DireccionMaquinas>();
		try {
			Scanner f = new Scanner(new FileReader(new File(archivo)));
			String linea = f.nextLine();
			while (linea != null) {
				Scanner sc = new Scanner(linea);
				// sc.useLocale(Locale.ENGLISH);
				// Para definir el lenguaje en ingles y usar el separador de
				// decimales como punto (.) y no como coma (,).
				String direccion = sc.next();
				String maquina = sc.next();
				addDireccionMaquinaWithFind(direccion, maquina);
				/*
				 * DireccionMaquinas dM = new DireccionMaquinas(direccion,
				 * maquina); DireccionMaquinas aux = treeDirecciones.find(dM);
				 * if (aux == null) treeDirecciones.add(dM); else{
				 * MaquinaContador mQ = new MaquinaContador(maquina);
				 * aux.addMaquinaWithFind(mQ); }
				 */
				linea = f.nextLine();
			}
			f.close();
		} catch (Exception e) {
		}
		return treeDirecciones;
	}

	public void guardarDireccionesIncidencias(String archivo) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

			bw.write(treeDirecciones.toString());
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addDireccionMaquina(String direccion, String maquina) {
		DireccionMaquinas dM = new DireccionMaquinas(direccion, maquina);
		treeDirecciones.add(dM);
		return true;

	}

	public boolean addDireccionMaquinaWithFind(String direccion, String maquina) {
		DireccionMaquinas dM = new DireccionMaquinas(direccion, maquina);
		DireccionMaquinas aux = treeDirecciones.find(dM);
		if (aux == null) {
			treeDirecciones.add(dM);
			return true;
		} else {
			MaquinaContador mQ = new MaquinaContador(maquina);
			aux.addMaquinaWithFind(mQ);
			return false;
		}
	}

	public int maquinasConContador(int contador) { // Implementar.
		int cont = 0;
		Iterator<DireccionMaquinas> iterator = treeDirecciones.iterator();
		while (iterator.hasNext()) {
			DireccionMaquinas actual = iterator.next(); // me devuelve el
														// siguiente elemento
														// del arbol
			BSTree<MaquinaContador> mactual = actual.getMaquinas(); // asigno la
																	// maquina a
																	// un
																	// elemento
																	// del arbol
			Iterator<MaquinaContador> iterator2 = mactual.iterator();
			for (int i = 0; i < mactual.size(); i++) {
				if (iterator2.hasNext())
					if (iterator2.next().getContador() == contador)
						cont++;
			}
		}
		return cont;
	}

	public String direccionMaquinasConContador(int contador) { // implementar
		String cadena = "";
		Iterator<DireccionMaquinas> iterator = treeDirecciones.iterator();
		while (iterator.hasNext()) {
			DireccionMaquinas actual = iterator.next();
			BSTree<MaquinaContador> mactual = actual.getMaquinas();
			Iterator<MaquinaContador> iterator2 = mactual.iterator();
			for (int i = 0; i < mactual.size(); i++) {

				if (iterator2.hasNext()) {
					MaquinaContador aux = iterator2.next();
					if (aux.getContador() == contador)
						cadena = cadena + "("+actual.getDireccion()+", " + aux.getMaquina()+")\n";

				}

			}

		}
		return cadena;
	}

	public int contadorDeDireccionMaquina(String direccion, String maquina) {
		int cont = -1;
		Iterator <DireccionMaquinas> iterator = treeDirecciones.iterator();
		while (iterator.hasNext()){
			DireccionMaquinas actual = iterator.next();
				if (actual.getDireccion().equals(direccion)){
			BSTree<MaquinaContador> mactual = actual.getMaquinas();
			Iterator<MaquinaContador> iterator2 = mactual.iterator();
			for (int i=0; i<mactual.size();i++){
				if (iterator2.hasNext()){
					MaquinaContador aux = iterator2.next();
						if(aux.getMaquina().equals(maquina))
							cont = aux.getContador();
					
				}
				}
			}
			
		}
		return cont;
	}

}
