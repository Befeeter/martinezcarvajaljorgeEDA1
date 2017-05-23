package org.eda1.actividad01.serializacionED;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaSerializacion {

	public ArrayList<CiudadBarrios> cargarArchivo(String inputFile) {
		// TODO Auto-generated method stub
		ArrayList<CiudadBarrios> lista = new ArrayList<CiudadBarrios> ();
		
		try {
			Scanner f = new Scanner (new FileReader (new File (inputFile)));
			String linea = f.nextLine();
			while (linea != null) {
				Scanner sc = new Scanner (linea);
				sc.useLocale(Locale.ENGLISH); 
				//Para definir el lenguaje en ingles y usar el separador de
				//decimales como punto (.) y no como coma (,).
				String ciudad = sc.next();
				double latitud = sc.nextDouble();
				double longitud = sc.nextDouble();
				CiudadBarrios cB = new CiudadBarrios (ciudad, latitud, longitud);
				int n = sc.nextInt();
				for (int i=0; i<n; i++) {
					String barrio = sc.next();
					cB.addBarrio(barrio);
				}
				lista.add(cB);
				linea = f.nextLine();
			}
			f.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}

	public String mostrarEstructura(ArrayList<CiudadBarrios> cB) {
		// TODO Auto-generated method stub
		String cadena = "";
		
		for (int i=0; i<cB.size(); i++) {
			cadena = cadena + "[" + cB.get(i).ciudad + ", " +
				cB.get(i).latitud + ", " + cB.get(i).longitud
				+ ", {";// + cB.get(i).getBarrios().size() + ", ";
			for (int j=0; j<cB.get(i).getBarrios().size(); j++) {
				cadena = cadena + cB.get(i).getBarrios().get(j);
				if (j != cB.get(i).getBarrios().size() - 1)
					cadena = cadena + ", ";
			}
			cadena = cadena + "}]\n";
		}
		return cadena;
	}

}
