package org.eda1.practica02.ejercicio03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

import org.eda1.estructurasdedatos.AVLTree;
import org.eda1.estructurasdedatos.Iterator;

public class CorrectorOrtografico {

	private AVLTree <String> treePalabras;
	
	
	
	public CorrectorOrtografico(){
		treePalabras = new AVLTree<String> ();
	}
	
	public CorrectorOrtografico (AVLTree<String> treePalabras){
		this.treePalabras = treePalabras;
	}
	
	public AVLTree <String> cargarDiccionario(String archivo){
		

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
			
				treePalabras.add(linea);
			

			}

			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return treePalabras;
	}
	
	public void guardarDiccionario (String archivo){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			Iterator <String> it1 = treePalabras.iterator();
			String palabra ="";
			while (it1.hasNext()){
				palabra = palabra+it1.next()+"\n";
			}
			bw.write(palabra);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int minimum (int a, int b, int c){
        if(a<=b && a<=c)
        {
            return a;
        } 
        if(b<=a && b<=c)
        {
            return b;
        }
        return c;
	}
	
	public static int computeLevenshteinDistance(String str1, String str2) {
        return computeLevenshteinDistance(str1.toCharArray(),
                                          str2.toCharArray());
    }
 
    private static int computeLevenshteinDistance(char [] str1, char [] str2) {
        int [][]distance = new int[str1.length+1][str2.length+1];
 
        for(int i=0;i<=str1.length;i++)
        {
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++)
        {
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++)
        {
            for(int j=1;j<=str2.length;j++)
            { 
                  distance[i][j]= minimum(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];
 
    }
    
    public ArrayList <String> listaSugerencias (int n, String s){
    	
    	ArrayList <String> sugerencias = new ArrayList <String>();
    	PriorityQueue <PalabraDistancia> cola = new PriorityQueue <PalabraDistancia> ();
    	Iterator <String> it1 = treePalabras.iterator();
    	
    	while (it1.hasNext()){
    		String palabra = it1.next();
    		int distancia = computeLevenshteinDistance(s, palabra);
    		if(distancia <= n){
    			PalabraDistancia p = new PalabraDistancia(palabra, distancia);
    			cola.add(p);
    		}
    	}
    	
    	for (int i =0; i<cola.size();i++){
    		sugerencias.add(cola.poll().getPalabra());
    	} 
    	return sugerencias;
    }
    
    public void addPalabra (String palabra){
    	treePalabras.add(palabra);
    }
    
    public boolean containsPalabra (String palabra){
    	return treePalabras.contains(palabra);  			
    }
    
    public int size (){
    	return treePalabras.size();
    }
    
    public boolean add(String palabra){
    	treePalabras.add(palabra);
    	return true;
    }
    public boolean find (String palabra){
    	if (treePalabras.find(palabra) != null)
    		return true;
    	else
    		return false;
    }
    
}
