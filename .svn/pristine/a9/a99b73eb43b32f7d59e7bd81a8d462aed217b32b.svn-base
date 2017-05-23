package org.eda1.practica02.ejercicio02;

import java.util.ArrayList;

import org.eda1.estructurasdedatos.AVLTree;

public class EmpresaProyectos implements Comparable{

	private String empresa;
	private AVLTree<ProyectoCiudades> proyectosCiudades;
	
	public EmpresaProyectos (){
		empresa = "";
		proyectosCiudades = new AVLTree<ProyectoCiudades> ();
	}
	
	public EmpresaProyectos (String empr){
		empresa = empr;
		proyectosCiudades = new AVLTree <ProyectoCiudades>();
		
	}
	
	public boolean addProyectoCiudad (String proyecto, String ciudad){
	
		ProyectoCiudades proyectoCiudad;
		proyectoCiudad = new ProyectoCiudades (proyecto);
		proyectoCiudad.addCiudad(ciudad);
		return proyectosCiudades.add(proyectoCiudad);
		
	}
	
	public boolean addProyectoCiudadWithFind (String proyecto, String ciudad){
		
		ProyectoCiudades proyectoCiudad = new ProyectoCiudades(proyecto);
		ProyectoCiudades otroproyectoCiudad = proyectosCiudades.find(proyectoCiudad);
		if(otroproyectoCiudad == null){
			proyectoCiudad.addCiudad(ciudad);
			return proyectosCiudades.add(proyectoCiudad);
		}
		else{
		otroproyectoCiudad.addCiudad(ciudad);
		return false;
		}
	}
	
	public void setEmpresa (String empr){
		empresa = empr;
		
	}
	
	public String getEmpresa (){
		return empresa;
	}
	
	public AVLTree<ProyectoCiudades> getProyectoCiudades(){
		return proyectosCiudades;
	}
	
	
	
	public int size (){
		return proyectosCiudades.size();
	}
	
	/*public String toString (){
		String cadena ="";
		cadena = "Empresa: "+empresa+"\n";
		for (int i=0; i<proyectosCiudades.size(); i++)
			cadena = cadena + proyectosCiudades.get(i).toString();
		
		return cadena;
	}*/
	
	/*public boolean equals (Object obj) {
		EmpresaProyectos e = (EmpresaProyectos) obj;
		if (empresa.equals(e.empresa))
			return true;
		else
			return false;
	}*/
	
	public int compareTo (Object otraEmpresaProyectos) {
		if (! (otraEmpresaProyectos instanceof EmpresaProyectos))
			throw new ClassCastException("Error de comparacion");
		EmpresaProyectos e = (EmpresaProyectos) otraEmpresaProyectos;
		return empresa.compareTo(e.empresa);
	}
}
