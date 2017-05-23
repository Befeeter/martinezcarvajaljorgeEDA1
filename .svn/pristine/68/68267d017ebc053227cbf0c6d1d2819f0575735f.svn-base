package org.eda1.practica03.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class ProcesarDatos {

	private TreeMap<String, TreeMap<String, TreeSet<String>>> mapa;

	public ProcesarDatos() {
		mapa = new TreeMap<String, TreeMap<String, TreeSet<String>>>();
	}

	public void cargarArchivo(String archivo) {
		try {
			Scanner f = new Scanner(new FileReader(new File(archivo)));

			while (f.hasNextLine()) {
				String linea = f.nextLine();
				Scanner l = new Scanner(linea);
				while (l.hasNext()) {
					String empresa = l.next();
					String proyecto = l.next();
					String ciudad = l.next();
					TreeMap<String, TreeSet<String>> tree2 = new TreeMap<String, TreeSet<String>>();
					TreeSet<String> tciudad = new TreeSet<String>();
					tciudad.add(ciudad);
					tree2.put(proyecto, tciudad);
					if (!mapa.containsKey(empresa))
						mapa.put(empresa, tree2);
					else {
						if (mapa.get(empresa).containsKey(proyecto)) {
							if (!mapa.get(empresa).get(proyecto)
									.contains(ciudad))
								mapa.get(empresa).get(proyecto).add(ciudad);
						} else
							mapa.get(empresa).put(proyecto, tciudad);
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

	public int size() {
		return mapa.size();
	}

	public void mostrarEmpresasProyectosCiudades() {
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			System.out.println(e1.getKey()+": \n");
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				System.out.println(e2.getKey()+": "+e2.getValue().toString()+" \n");
			}
		}
	}

	public void guardarEmpresasProyectosCiudades(String archivo) throws FileNotFoundException{
		String stringArchivoSalida="";
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			stringArchivoSalida= stringArchivoSalida+e1.getKey()+": \n";
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				stringArchivoSalida = stringArchivoSalida+e2.getKey()+": "+e2.getValue().toString()+" \n";
			}
		}
		
		File archivoSalida = new File(archivo);
		PrintWriter pw = new PrintWriter(archivoSalida);

		pw.print(stringArchivoSalida);

		pw.close();
	}

	public ArrayList<String> devolverCiudades() {
		ArrayList<String> ciudades = new ArrayList<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				TreeSet<String> ciu = e2.getValue();
				Iterator<String> it1 = ciu.iterator();
				while (it1.hasNext()) {
					String ciudad = it1.next();
					if (!ciudades.contains(ciudad))
						ciudades.add(ciudad);
				}
			}
		}
		return ciudades;
	}

	public ArrayList<String> devolverProyectos() {
		ArrayList<String> proyectos = new ArrayList<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				if (!proyectos.contains(e2.getKey()))
					proyectos.add(e2.getKey());
			}
		}
		return proyectos;
	}

	public ArrayList<String> devolverEmpresas() {
		ArrayList<String> empresas = new ArrayList<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			if (!empresas.contains(e1.getKey()))
				empresas.add(e1.getKey());
		}
		return empresas;
	}

	public int numeroProyectosEmpresa(String emrpesa) {
		return mapa.get(emrpesa).size();
	}

	public int numeroCiudadesProyecto(String proyecto) {
		int num = 0;
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			if (mapa2.containsKey(proyecto))
				num = mapa2.get(proyecto).size();
		}
		return num;
	}

	public int numeroCiudadesEmpresa(String emrpsea) {

		TreeMap<String, TreeSet<String>> auxempresas = mapa.get(emrpsea);
		TreeSet<String> auxciudades = new TreeSet<String>();
		for (Entry<String, TreeSet<String>> e1 : auxempresas.entrySet()) {
			Iterator<String> it1 = e1.getValue().iterator();
			while (it1.hasNext()) {
				auxciudades.add(it1.next());
			}
		}

		return auxciudades.size();
	}

	public String devolverEmpresasProyectosCiudades() {
		String cadena = "";
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			cadena = cadena + e1.getKey() + ": ";
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				cadena = cadena + e2.getKey() + "<";
				TreeSet<String> aux = e2.getValue();
				Iterator<String> it1 = aux.iterator();
				while (it1.hasNext()) {
					cadena = cadena + it1.next() + ", ";
				}
				cadena = cadena.substring(0, cadena.length() - 2);
				cadena = cadena + ">; ";

			}
			cadena = cadena.substring(0, cadena.length() - 2);
			cadena = cadena + "\n";
		}
		return cadena;
	}

	public ArrayList<String> devolverEmpresasCiudad(String ciudad) {
		ArrayList<String> empresas = new ArrayList<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				TreeSet<String> ciu = e2.getValue();
				Iterator<String> it1 = ciu.iterator();
				while (it1.hasNext()) {
					String aux = it1.next();
					if (ciudad.equals(aux))
						if (!empresas.contains(e1.getKey()))
							empresas.add(e1.getKey());
				}
			}
		}
		return empresas;
	}

	public ArrayList<String> devolverProyectosCiudad(String ciudad) {
		ArrayList<String> proyectos = new ArrayList<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				TreeSet<String> ciu = e2.getValue();
				Iterator<String> it1 = ciu.iterator();
				while (it1.hasNext()) {
					String aux = it1.next();
					if (ciudad.equals(aux))
						if (!proyectos.contains(e2.getKey()))
							proyectos.add(e2.getKey());

				}
			}
		}
		return proyectos;
	}

	public ArrayList<String> devolverCiudadesEmpresa(String empresa) {
		ArrayList<String> ciudades = new ArrayList<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			if (e1.getKey().equals(empresa)) {
				TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
				for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
					TreeSet<String> ciu = e2.getValue();
					Iterator<String> it1 = ciu.iterator();
					while (it1.hasNext()) {
						String aux = it1.next();
						if (!ciudades.contains(aux))
							ciudades.add(aux);
					}
				}
			}
		}
		return ciudades;
	}

	public ArrayList<String> devolverCiudadesProyectoEmpresa(String proyecto,
			String empresa) {
		ArrayList<String> ciudades = new ArrayList<String>();
		TreeSet<String> ciu = mapa.get(empresa).get(proyecto);
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				if (!e1.getKey().equals(empresa)) {
					TreeSet<String> aux = e2.getValue();
					Iterator<String> it1 = aux.iterator();
					while (it1.hasNext()) {
						String ciudad = it1.next();
						if (ciu.contains(ciudad))
							if (!ciudades.contains(ciudad))
								ciudades.add(ciudad);
					}
				}

			}
		}
		return ciudades;
	}

	public ArrayList<String> devolverEmpresaParesProyectoCiudadesComunes(
			String empresa) {
		ArrayList<String> ciudades = new ArrayList<String>();
		ArrayList<String> recorridos = new ArrayList<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			if (e1.getKey().equals(empresa)) {
				TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
				for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
					ArrayList<String> prociu = devolverCiudadesProyectoEmpresa(
							e2.getKey(), empresa);
					for (Entry<String, TreeSet<String>> e3 : mapa2.entrySet()) {
						if(!recorridos.contains(e3.getKey())){
						if (!e2.getKey().equals(e3.getKey())) {
							TreeSet<String> citys = e3.getValue();
							Iterator<String> it1 = citys.iterator();
							while (it1.hasNext()) {
								String ciud = it1.next();
								Iterator<String> it2 = prociu.iterator();
								if (prociu.contains(ciud))
									while (it2.hasNext()) {
										String ciud2 = it2.next();
										if (ciud.equals(ciud2)) {
											String cadena = e2.getKey() + " - "
													+ e3.getKey() + " => "
													+ ciud2;
											ciudades.add(cadena);
										}
									}
							}
						}
						}
						
					}
					recorridos.add(e2.getKey());
				}
			}
		}
		return ciudades;
	}

	public String devolverProyectoConMayorNumeroDeCiudades() {
		String proyecto = "";
		String empresa = mapa.firstKey();
		proyecto= mapa.get(empresa).firstKey();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			for (Entry<String, TreeSet<String>> e2 : mapa2.entrySet()) {
				TreeSet<String> ciu = e2.getValue();
				if(ciu.size()>mapa.get(empresa).get(proyecto).size()) {
					empresa = e1.getKey();
					proyecto = e2.getKey();
				}
			}
		}
		return proyecto;
	}

	public String devolverEmpresaConMayorNumeroDeProyectos() {
		String empresa = "";
		empresa = mapa.firstKey();
		for (Entry<String, TreeMap<String, TreeSet<String>>> e1 : mapa
				.entrySet()) {
			TreeMap<String, TreeSet<String>> mapa2 = e1.getValue();
			if (mapa.get(empresa).size()<mapa2.size())
				empresa = e1.getKey();
				
			
			}
		return empresa;
	}

	public String devolverCiudadConMayorNumeroDeProyectos() {
		String ciudad = "";
		ArrayList<String>ciudades = devolverCiudades();
		Iterator<String>it1 = ciudades.iterator();
		ciudad = it1.next();
		while (it1.hasNext()){
			String ciudad2= it1.next();
			if (devolverProyectosCiudad(ciudad).size()<devolverProyectosCiudad(ciudad2).size())
				ciudad = ciudad2;
		}
		return ciudad;
	}
}
