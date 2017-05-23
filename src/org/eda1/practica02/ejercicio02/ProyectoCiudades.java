package org.eda1.practica02.ejercicio02;

import java.util.ArrayList;

import org.eda1.estructurasdedatos.AVLTree;

public class ProyectoCiudades implements Comparable {

	private String proyecto;
	private AVLTree <String> ciudades;
	
	public ProyectoCiudades ()	{
		proyecto="";
		ciudades = new AVLTree<String> ();
		
	}
	
	public ProyectoCiudades (String proy){
		proyecto = proy;
		ciudades = new AVLTree<String> ();
	}
	
	public void setProyecto (String proy){
		proyecto = proy;
	}
	
	public String getProyecto (){
	
		return proyecto;
	}
	
	public void addCiudad (String ciudad){
		if (! ciudades.contains(ciudad))
			ciudades.add(ciudad);
		
	}
	
	public AVLTree<String> getCiudades(){
		return ciudades;
	}
	
	
	public int size (){
		return ciudades.size();
	}
	
	/*public boolean equals (Object o){
		ProyectoCiudades p = (ProyectoCiudades) o;
		
		if (proyecto.equals(p.proyecto))
			return true;
		else
			return false;
		
	}*/
	
	public int compareTo (Object otroProyectoCiudades) {
		if (! (otroProyectoCiudades instanceof ProyectoCiudades))
			throw new ClassCastException("Error de comparacion");
		ProyectoCiudades p = (ProyectoCiudades) otroProyectoCiudades;
		return proyecto.compareTo(p.proyecto);
	}
	
	/*public String toString (){
		String cadena;
		cadena ="\n Proyecto: "+proyecto;
		cadena = cadena + "\n Lista de ciudades: ";
			for (int i =0; i<ciudades.size(); i++) {
				cadena= cadena+ ciudades.get(i);
			}
			return cadena;
			}*/
	}
	

