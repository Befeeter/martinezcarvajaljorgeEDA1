package org.eda1.practica01.ejercicio02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProcesarDatos {

	public static ArrayList<EmpresaProyectos> cargarArchivo(String archivo) {
		Empresas empresa;
		empresa = new Empresas();
		ArrayList<EmpresaProyectos> listaempresas = null;

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

				EmpresaProyectos ep = new EmpresaProyectos(sempresa);
				ep.addProyectoCiudad(proyecto, ciudad);
				empresa.addEmpresa(ep);

			}

			listaempresas = empresa.devolverLista();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaempresas;
	}

	public static void guardarEmpresasProyectosCiudades(
			ArrayList<EmpresaProyectos> listaEmpresas, String archivo) {

	}

	public static String devolverEmpresasProyectosCiudades(
			ArrayList<EmpresaProyectos> listaEmpresas) {
		String cadena = "";

		for (int i = 0; i < listaEmpresas.size(); i++) {
			EmpresaProyectos e = listaEmpresas.get(i);
			cadena = cadena + e.getEmpresa() + ": ";
			for (int j = 0; j < e.getProyectoCiudades().size(); j++) {
				ProyectoCiudades p = e.getProyectoCiudades(j);
				cadena = cadena + p.getProyecto() + "<";
				for (int k = 0; k < p.getCiudades().size(); k++) {
					if (k == p.getCiudades().size() - 1)
						cadena = cadena + p.getCiudad(k);
					else
						cadena = cadena + p.getCiudad(k) + ", ";
				}
				if (j == e.getProyectoCiudades().size() - 1)
					cadena = cadena + ">";
				else
					cadena = cadena + ">; ";
			}
			cadena = cadena + "\n";
		}
		return cadena;
	}

	public static ArrayList<String> enumerarEmpresasCiudad(
			ArrayList<EmpresaProyectos> listaEmpresas, String ciudad) {
		ArrayList<String> lista = new ArrayList<String>();

		for (int i = 0; i < listaEmpresas.size(); i++) {
			EmpresaProyectos e = listaEmpresas.get(i);
			boolean estaEmpresa = false;
			for (int j = 0; j < e.getProyectoCiudades().size() && !estaEmpresa; j++) {
				ProyectoCiudades p = e.getProyectoCiudades(j);
				if (p.getCiudades().contains(ciudad))
					estaEmpresa = true;
			}
			if (estaEmpresa == true)
				lista.add(e.getEmpresa());

		}

		return lista;
	}

	public static ArrayList<String> enumerarProyectosCiudad(
			ArrayList<EmpresaProyectos> listaEmpresas, String ciudad) {
		ArrayList<String> lista = new ArrayList<String>();

		for (int i = 0; i < listaEmpresas.size(); i++) {
			EmpresaProyectos e = listaEmpresas.get(i);
			for (int j = 0; j < e.getProyectoCiudades().size(); j++) {
				ProyectoCiudades p = e.getProyectoCiudades(j);
				if (p.getCiudades().contains(ciudad))
					lista.add(p.getProyecto());
			}
		}

		return lista;
	}

	public static int contarCiudadesEmpresa(
			ArrayList<EmpresaProyectos> listaEmpresas, String empresa) {

		ArrayList<String> nciudades = new ArrayList<String>();
		EmpresaProyectos e = new EmpresaProyectos(empresa);

		int i = listaEmpresas.indexOf(e);
		if (i != -1) {
			e = listaEmpresas.get(i);
			for (int j = 0; j < e.getProyectoCiudades().size(); j++) {
				ProyectoCiudades p = e.getProyectoCiudades().get(j);
				for (int k = 0; k < p.getCiudades().size(); k++) {
					if (!nciudades.contains(p.getCiudad(k)))
						nciudades.add(p.getCiudad(k));
				}

			}

		}
		return nciudades.size();
	}

	public static ArrayList<String> enumerarCiudadesProyectoEmpresa(
			ArrayList<EmpresaProyectos> listaEmpresas, String proyecto,
			String empresa) {
		ArrayList<String> lista = new ArrayList<String>();
		EmpresaProyectos e = new EmpresaProyectos(empresa);
		int i = listaEmpresas.indexOf(e);
		if (i == -1) 
			return lista;
		e = listaEmpresas.get(i);
		ProyectoCiudades p = new ProyectoCiudades(proyecto);
		int j = e.getProyectoCiudades().indexOf(p);
		if (j == -1) 
			return lista;
		p = e.getProyectoCiudades(j);
		//ahora recorro mi lista de empresas y para cada empresa distinta de 
		//la que busco y para cada proyecto, busco cada ciudad en mi lista
		//de ciudades del proyecto p y si esta la añado a la lita resultado
		//siempre que no este ya añadida
		for (int i2 = 0; i2 < listaEmpresas.size(); i2++) {
			EmpresaProyectos e2 = listaEmpresas.get(i2);
			if ( ! e2.equals(e)) {
				for (int j2 = 0; j2 < e2.getProyectoCiudades().size(); j2++) {
					ProyectoCiudades p2 = e2.getProyectoCiudades(j2);
					for (int k2=0; k2<p2.size(); k2++) {
						if (p.getCiudades().indexOf(p2.getCiudad(k2)) != -1) {
							if (lista.indexOf(p2.getCiudad(k2)) == -1)
								lista.add(p2.getCiudad(k2));
						}
					}
				}
			}
		}		
		return lista;
	}
}
