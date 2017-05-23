package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;

public class ProyectoCiudades {

	private String proyecto;
	private ArrayList <String> ciudades;
	
	public ProyectoCiudades ()	{
		proyecto="";
		ciudades = new ArrayList<String> ();
		
	}
	
	public ProyectoCiudades (String proy){
		proyecto = proy;
		ciudades = new ArrayList<String> ();
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
	
	public ArrayList<String> getCiudades(){
		return ciudades;
	}
	
	public String getCiudad (int index){
		return ciudades.get(index);
	}
	
	public int size (){
		return ciudades.size();
	}
	
	public boolean equals (Object o){
		ProyectoCiudades p = (ProyectoCiudades) o;
		
		if (proyecto.equals(p.proyecto))
			return true;
		else
			return false;
		
	}
	
	public int compareTo (Object obj) {
		ProyectoCiudades p = (ProyectoCiudades) obj;
		return proyecto.compareTo(p.proyecto);
	}
	public String toString (){
		String cadena;
		cadena ="\n Proyecto: "+proyecto;
		cadena = cadena + "\n Lista de ciudades: ";
			for (int i =0; i<ciudades.size(); i++) {
				cadena= cadena+ ciudades.get(i);
			}
			return cadena;
			}
	}
	

