package org.eda1.examenSegundoParcial.ejercicio01;

import java.util.TreeSet;

public class DatosCiudad implements Comparable {
	String pais;
	String continente;
	TreeSet<String> direcciones = new TreeSet<String>();

	public DatosCiudad(String pais, String conti, TreeSet<String> direc) {
		this.pais = pais;
		this.continente = conti;
		this.direcciones = direc;
	}

	public String getPais() {

		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getContinente() {
		return this.continente;
	}

	public void setContinente(String continente) { 
		this.continente = continente;
	}

	public void setDirecciones(TreeSet<String> direcciones) { 
		this.direcciones = direcciones;
	}

	public TreeSet<String> getDirecciones(){ 
		return this.direcciones;
	}

	public int compareTo(Object otroDatosCuidad){ 
		DatosCiudad other = (DatosCiudad) otroDatosCuidad;
		if (direcciones.size() < other.direcciones.size())
			return -1;
		if (direcciones.size() > other.direcciones.size())
			return 1;
		else
			return 0;
		
	}

	@Override
	public String toString() {
		return "DatosCiudad [pais=" + pais + ", continente=" + continente
				+ ", direcciones=" + direcciones + "]";
	}
	
	
	// Otras funciones que considere necesarias
}