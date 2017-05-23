package org.eda1.practica02.ejercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eda1.estructurasdedatos.AVLTree;
import org.eda1.estructurasdedatos.Iterator;

public class ProcesarDatos {

	public static AVLTree<EmpresaProyectos> cargarArchivo(String archivo) {

		AVLTree<EmpresaProyectos> listaEmpresas = new AVLTree<EmpresaProyectos>();

		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			/*
			 * String ruta = System.getProperty("user.dir"); String
			 * nombreArchivo = "entradas.txt"; ruta = ruta + File.separator +
			 * "src" + File.separator + "org" + File.separator + "eda1" +
			 * File.separator + "practica01" + File.separator + "ejercicio02" +
			 * File.separator + archivo;
			 * 
			 * System.out.println(ruta);
			 */
			// System.exit(0);

			fr = new FileReader(archivo);// ruta);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {

				// Separamos por elemento cada linea con el elemento separador.
				StringTokenizer token = new StringTokenizer(linea, " ");
				String sempresa = token.nextToken(); // Empresa
				String proyecto = token.nextToken(); // Proyecto
				String ciudad = token.nextToken(); // Ciudad
				System.out.println("Empresa: " + sempresa + " Proyecto:"
						+ proyecto + " Ciudad:" + ciudad);

				addEmpresaProyectoCiudadWithFind(listaEmpresas, sempresa,
						proyecto, ciudad);

			}

			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaEmpresas;
	}

	public static boolean addEmpresaProyectoCiudad(
			AVLTree<EmpresaProyectos> listaEmpresas, String empresa,
			String proyecto, String ciudad) {

		EmpresaProyectos e = new EmpresaProyectos(empresa);
		e.addProyectoCiudad(proyecto, ciudad);
		return listaEmpresas.add(e);
	}

	public static boolean addEmpresaProyectoCiudadWithFind(
			AVLTree<EmpresaProyectos> listaEmpresas, String empresa,
			String proyecto, String ciudad) {
		EmpresaProyectos e = new EmpresaProyectos(empresa);
		EmpresaProyectos otraEmpresaProyectos = listaEmpresas.find(e);
		if (otraEmpresaProyectos == null) {
			e.addProyectoCiudad(proyecto, ciudad);
			return listaEmpresas.add(e);
		} else {
			otraEmpresaProyectos.addProyectoCiudadWithFind(proyecto, ciudad);
			return false;
		}
	}

	public static void mostrarEmpresasProyectosCiudades(
			AVLTree<EmpresaProyectos> listaEmpresas) {

		Iterator<EmpresaProyectos> it1 = listaEmpresas.iterator();
		Iterator<ProyectoCiudades> it2;
		Iterator<String> it3;

		System.out.println("Listado de Empresas:\n");
		while (it1.hasNext()) {
			EmpresaProyectos e = it1.next();
			System.out.println("Empresa: " + e.getEmpresa());
			it2 = e.getProyectoCiudades().iterator();
			while (it2.hasNext()) {
				ProyectoCiudades p = it2.next();
				System.out.println("\tProyecto: " + p.getProyecto());
				it3 = p.getCiudades().iterator();
				while (it3.hasNext()) {
					String ciudad = it3.next();
					System.out.println("\t\tCiudad: " + ciudad);
				}
			}
		}

	}

	public static void guardarEmpresasProyectosCiudades(
			AVLTree<EmpresaProyectos> listaEmpresas, String archivo) {

		try {
			BufferedWriter f = new BufferedWriter(new FileWriter(new File(
					archivo)));
			f.write(listaEmpresas.toString());
			f.close();
		} catch (Exception e) {
			System.out.println("Error de escritura en fichero");
		}

	}

	public static int numeroProyectosEmpresa(
			AVLTree<EmpresaProyectos> listaEmpresas, String empresa) {
		EmpresaProyectos emp1, emp2;

		emp1 = new EmpresaProyectos(empresa);
		emp2 = listaEmpresas.find(emp1);
		if (emp2 == null)
			return 0;
		else
			return emp2.getProyectoCiudades().size();
	}

	public static int numeroCiudadesProyecto(
			AVLTree<EmpresaProyectos> listaEmpresas, String proyecto) {
		EmpresaProyectos emp;
		ProyectoCiudades proy1, proy2;
		proy1 = new ProyectoCiudades(proyecto);
		Iterator<EmpresaProyectos> it1 = listaEmpresas.iterator();

		while (it1.hasNext()) {
			emp = it1.next();
			proy2 = emp.getProyectoCiudades().find(proy1);
			if (proy2 != null)
				return proy2.getCiudades().size();
		}
		return 0;
	}

	public static int numeroCiudadesEmpresa(
			AVLTree<EmpresaProyectos> listaEmpresas, String empresa) {

		ArrayList<String> nciudades = new ArrayList<String>();
		Iterator<ProyectoCiudades> it1;
		EmpresaProyectos e = new EmpresaProyectos(empresa);

		if (listaEmpresas.find(e) != null) {
			e = listaEmpresas.find(e);
			it1 = e.getProyectoCiudades().iterator();
			while (it1.hasNext()) {
				ProyectoCiudades p = it1.next();
				Iterator<String> it2 = p.getCiudades().iterator();
				while (it2.hasNext()) {
					String ciudad = it2.next();
					if (!nciudades.contains(ciudad))
						nciudades.add(ciudad);
				}

			}

		}
		return nciudades.size();
	}

	public static String devolverEmpresasProyectosCiudades(
			AVLTree<EmpresaProyectos> listaEmpresas) {
		String cadena = "";
		Iterator<EmpresaProyectos> it1 = listaEmpresas.iterator();
		Iterator<ProyectoCiudades> it2;
		Iterator<String> it3;

		while (it1.hasNext()) {
			EmpresaProyectos e = it1.next();
			cadena = cadena + e.getEmpresa() + ": ";
			it2 = e.getProyectoCiudades().iterator();
			while (it2.hasNext()) {
				ProyectoCiudades p = it2.next();
				cadena = cadena + p.getProyecto() + "<";
				it3 = p.getCiudades().iterator();
				while (it3.hasNext()) {
					String c = it3.next();
					if (!it3.hasNext())
						cadena = cadena + c;
					else
						cadena = cadena + c + ", ";
				}
				if (!it2.hasNext())
					cadena = cadena + ">";
				else
					cadena = cadena + ">; ";
			}
			cadena = cadena + "\n";
		}
		return cadena;
	}

	public static ArrayList<String> devolverEmpresasCiudad(
			AVLTree<EmpresaProyectos> listaEmpresas, String ciudad) {
		ArrayList<String> lista = new ArrayList<String>();
		Iterator<EmpresaProyectos> it1 = listaEmpresas.iterator();
		Iterator<ProyectoCiudades> it2;

		while (it1.hasNext()) {
			EmpresaProyectos e = it1.next();
			boolean estaEmpresa = false;
			it2 = e.getProyectoCiudades().iterator();
			while (it2.hasNext() && !estaEmpresa) {
				ProyectoCiudades p = it2.next();
				if (p.getCiudades().contains(ciudad))
					estaEmpresa = true;
			}
			if (estaEmpresa == true)
				lista.add(e.getEmpresa());

		}

		return lista;
	}

	public static ArrayList<String> devolverProyectosCiudad(
			AVLTree<EmpresaProyectos> listaEmpresas, String ciudad) {
		ArrayList<String> lista = new ArrayList<String>();
		Iterator<EmpresaProyectos> it1 = listaEmpresas.iterator();
		Iterator<ProyectoCiudades> it2;

		while (it1.hasNext()) {
			EmpresaProyectos e = it1.next();
			it2 = e.getProyectoCiudades().iterator();
			while (it2.hasNext()) {
				ProyectoCiudades p = it2.next();
				if (p.getCiudades().contains(ciudad))
					lista.add(p.getProyecto());
			}
		}

		return lista;
	}

	public static ArrayList<String> devolverCiudadesEmpresa(
			AVLTree<EmpresaProyectos> listaEmpresas, String empresa) {

		ArrayList<String> nciudades = new ArrayList<String>();
		Iterator<ProyectoCiudades> it1;
		EmpresaProyectos e = new EmpresaProyectos(empresa);

		if (listaEmpresas.find(e) != null) {
			e = listaEmpresas.find(e);
			it1 = e.getProyectoCiudades().iterator();
			while (it1.hasNext()) {
				ProyectoCiudades p = it1.next();
				Iterator<String> it2 = p.getCiudades().iterator();
				while (it2.hasNext()) {
					String ciudad = it2.next();
					if (!nciudades.contains(ciudad))
						nciudades.add(ciudad);
				}

			}

		}
		return nciudades;
	}

	public static ArrayList<String> devolverCiudadesProyectoEmpresa(
			AVLTree<EmpresaProyectos> listaEmpresas, String proyecto,
			String empresa) {
		ArrayList<String> lista = new ArrayList<String>();
		EmpresaProyectos e = new EmpresaProyectos(empresa);
		if (listaEmpresas.find(e) == null)
			return lista;
		e = listaEmpresas.find(e);
		ProyectoCiudades p = new ProyectoCiudades(proyecto);
		if (e.getProyectoCiudades().find(p) == null)
			return lista;
		p = e.getProyectoCiudades().find(p);
		// ahora recorro mi lista de empresas y para cada empresa distinta de
		// la que busco y para cada proyecto, busco cada ciudad en mi lista
		// de ciudades del proyecto p y si esta la añado a la lita resultado
		// siempre que no este ya añadida
		Iterator<EmpresaProyectos> it1 = listaEmpresas.iterator();
		while (it1.hasNext()) {
			EmpresaProyectos e2 = it1.next();
			if (!e2.getEmpresa().equals(e.getEmpresa())) {
				Iterator<ProyectoCiudades> it2 = e2.getProyectoCiudades()
						.iterator();
				while (it2.hasNext()) {
					ProyectoCiudades p2 = it2.next();
					Iterator<String> it3 = p2.getCiudades().iterator();
					while (it3.hasNext()) {
						String ciudad = it3.next();
						if (p.getCiudades().find(ciudad) != null) {
							if (lista.indexOf(ciudad) == -1)
								lista.add(ciudad);
						}
					}
				}
			}
		}
		return lista;
	}

	public static ArrayList<String> devolverEmpresaParesProyectoCiudadesComunes(
			AVLTree<EmpresaProyectos> listaEmpresas, String empresa) {
		
		EmpresaProyectos emp1, emp2;
		ArrayList <String> lista;
		Iterator <ProyectoCiudades> it1, it2;
		Iterator<String> it3;
		int n =0;
	
		emp1= new EmpresaProyectos (empresa);
		emp2 = listaEmpresas.find(emp1);
		
		if (emp2 == null)
			return null;
		lista = new ArrayList();
		it1 = emp2.getProyectoCiudades().iterator();
		while (it1.hasNext()){
			ProyectoCiudades p1 = it1.next();
			 n++;
			if (it1.hasNext()){
				it2 = emp2.getProyectoCiudades().iterator();
				for (int i =0; i<n; i++)
					it2.next();
				while (it2.hasNext()){
					ProyectoCiudades p2 = it2.next();
					it3 = p1.getCiudades().iterator();
						while (it3.hasNext()){
							String ciudad = it3.next();
							if (p2.getCiudades().contains(ciudad))
								lista.add(p1.getProyecto()+" - "+p2.getProyecto()+" => "+ciudad);
						}
				}
			}
			
		}
		
		return lista;
		

	}
}
