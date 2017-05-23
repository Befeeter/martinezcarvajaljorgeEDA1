package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;

public class Empresas {

	private ArrayList<EmpresaProyectos> listaempresas;
	
	public Empresas (){
		listaempresas = new ArrayList<EmpresaProyectos>();
	}
	
	public void addEmpresa (EmpresaProyectos ep){

		int pos = listaempresas.indexOf(ep);
		//System.out.println("Busco "+ep.getEmpresa()+" y esta en posicion "+pos);
		if (pos == -1) //necesita un .equals en EmpresaProyectos.
			listaempresas.add(ep);
		else {
			String proyecto = ep.getProyectoCiudades(0).getProyecto();
			String ciudad = ep.getProyectoCiudades(0).getCiudad(0);
			listaempresas.get(pos).addProyectoCiudad(proyecto, ciudad);
		}
	}
	
	public ArrayList<EmpresaProyectos> devolverLista (){
		return listaempresas;
	}
	
	
}
