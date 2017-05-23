package org.eda1.practica02.ejercicio01;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eda1.estructurasdedatos.BSTree;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src"
				+ File.separator + "org" + File.separator + "eda1"
				+ File.separator + "practica02" + File.separator
				+ "ejercicio01" + File.separator;

		String stringArchivoEntrada = "entradas.txt";
		stringArchivoEntrada = directorioEntrada + stringArchivoEntrada;

		String entradas = "";

		BSTree<DireccionMaquinas> treeDireccionesMaquina = new BSTree<DireccionMaquinas>();

		ProcesarDirecciones procesarDirecciones = new ProcesarDirecciones(
				treeDireccionesMaquina);

		treeDireccionesMaquina = procesarDirecciones
				.cargarArchivo(stringArchivoEntrada);

		// assertTrue(treeDireccionesMaquina.size()==0);
		System.out.println(treeDireccionesMaquina.size());

	}

}
