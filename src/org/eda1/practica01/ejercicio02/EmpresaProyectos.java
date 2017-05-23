package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;

public class EmpresaProyectos {

	private String empresa;
	private ArrayList<ProyectoCiudades> proyectosCiudades;
	
	public EmpresaProyectos (){
		empresa = "";
		proyectosCiudades = new ArrayList<ProyectoCiudades> ();
	}
	
	public EmpresaProyectos (String empr){
		empresa = empr;
		proyectosCiudades = new ArrayList <ProyectoCiudades>();
		
	}
	
	public void addProyectoCiudad (String proyecto, String ciudad){
		ProyectoCiudades proyectoCiudad;
		int n;
		
		proyectoCiudad = new ProyectoCiudades (proyecto);
		n = proyectosCiudades.indexOf(proyectoCiudad);
		//System.out.println("Busco: "+proyecto+" y esta en posicon "+n);
		if (n == -1) {
		proyectoCiudad.addCiudad (ciudad);
		proyectosCiudades.add(proyectoCiudad);
		}
		else
				proyectosCiudades.get(n).addCiudad(ciudad);
	}
	
	public void setEmpresa (String empr){
		empresa = empr;
		
	}
	
	public String getEmpresa (){
		return empresa;
	}
	
	public ArrayList<ProyectoCiudades> getProyectoCiudades(){
		return proyectosCiudades;
	}
	public ProyectoCiudades getProyectoCiudades (int i){
		return proyectosCiudades.get(i);
	}
	
	public int size (){
		return proyectosCiudades.size();
	}
	
	public String toString (){
		String cadena ="";
		cadena = "Empresa: "+empresa+"\n";
		for (int i=0; i<proyectosCiudades.size(); i++)
			cadena = cadena + proyectosCiudades.get(i).toString();
		
		return cadena;
	}
	
	public boolean equals (Object obj) {
		EmpresaProyectos e = (EmpresaProyectos) obj;
		if (empresa.equals(e.empresa))
			return true;
		else
			return false;
	}
	
	public int compareTo (Object obj) {
		EmpresaProyectos e = (EmpresaProyectos) obj;
		return empresa.compareTo(e.empresa);
	}
}
