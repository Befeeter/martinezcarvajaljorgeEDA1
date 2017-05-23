package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;

	public class Mainprueba {

		

		public static void main(String[] args) {
			ArrayList<EmpresaProyectos> lista;
			lista = ProcesarDatos.cargarArchivo("empresasProyectosCiudades.txt");
			
			System.out.println(lista.size());
			System.out.println(lista.get(2));
			
			
			//for (int i=0;i<lista.size();i++)
			//	System.out.println(lista.get(i).);
				//System.out.println(lista.get(i));
				
			
			

		}

	}
