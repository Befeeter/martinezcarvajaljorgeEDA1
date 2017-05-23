package org.eda1.examenParcialGrupoB.ejercicio01;


import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.eda1.utilidades.Greater;

public class ProcesarDatosEPCB {

	public static ArrayList<EmpresaProyectoCiudadBeneficio> cargarArchivo(
			String archivo) {

		ArrayList<EmpresaProyectoCiudadBeneficio> lista = new ArrayList<EmpresaProyectoCiudadBeneficio>();
		try {
			Scanner f = new Scanner(new FileReader(new File(archivo)));
			while (f.hasNextLine()){
				String linea = f.nextLine();
				Scanner l = new Scanner (linea);
				String empresa = l.next();
				String proyecto = l.next();
				String ciudad = l.next();
				Double beneficio = l.nextDouble();
				
				EmpresaProyectoCiudadBeneficio e = new EmpresaProyectoCiudadBeneficio(empresa, proyecto, ciudad, beneficio);
				lista.add(e);
			}
			
			
			f.close();
		} catch (Exception e) {
			System.out.println("Error en la lectura del fichero");
		}

		return lista;
	}

	public static ArrayList<EmpresaProyectoCiudadBeneficio> getTopK(
			ArrayList<EmpresaProyectoCiudadBeneficio> ePCB, int k) {
		ArrayList<EmpresaProyectoCiudadBeneficio> lista = new ArrayList<EmpresaProyectoCiudadBeneficio>();
		EmpresaProyectoCiudadBeneficio e;
		Greater<EmpresaProyectoCiudadBeneficio> comp = new Greater<EmpresaProyectoCiudadBeneficio>();

		MyPQWithHeap<EmpresaProyectoCiudadBeneficio> miPQ = new MyPQWithHeap<EmpresaProyectoCiudadBeneficio>(
				comp);

		for (int i = 0; i < ePCB.size(); i++) {
			e = ePCB.get(i);
			miPQ.add(e);
		}

		int n = 0;
		while (n < k && !miPQ.isEmpty()) {
			e = miPQ.poll();
			lista.add(0, e);
			n++;
		}

		return lista;
	}

}
