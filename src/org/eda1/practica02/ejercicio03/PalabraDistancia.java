package org.eda1.practica02.ejercicio03;


public class PalabraDistancia implements Comparable{

	private String palabra;
	private int distancia;
	
	
	public PalabraDistancia (String pal, int dis){
		palabra = pal;
		distancia = dis;
	}
	
	public PalabraDistancia (String pal){
		palabra = pal;
		distancia = 0;
	}
	
	public PalabraDistancia (){
		palabra = "";
		distancia = 0;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public int compareTo (Object other){
		if ( ! (other instanceof PalabraDistancia))
			throw new ClassCastException("Error en la comparacion");
		PalabraDistancia p = (PalabraDistancia) other;
		if (distancia < p.distancia)
			return -1;
		if (distancia > p.distancia)
			return 1;
		return 0;
	}
	
	public boolean equals (Object obj){
		if ( ! (obj instanceof PalabraDistancia))
			throw new ClassCastException("Error en la comparacion");
		PalabraDistancia p = (PalabraDistancia) obj;
		return distancia == p.distancia;
	}
	
	
}
