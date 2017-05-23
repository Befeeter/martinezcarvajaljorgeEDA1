package org.eda1.examenSegundoParcialGrupoA.ejercicio02;

public class Vertice implements Comparable {

	private String pueblo;
	private double poblacion;
	
	public Vertice () {
		pueblo = "";
		poblacion = 0;
	}
	
	public Vertice (String pue, double pob) {
		pueblo = pue;
		poblacion = pob;
	}
	
	public void setPueblo (String pue) {
		pueblo = pue;
	}
	
	public String getPueblo () {
		return pueblo;
	}
	
	public double getPoblacion () {
		return poblacion;
	}
	
	public void setPoblacion (double pob) {
		poblacion = pob;
	}
	
	public int compareTo (Object otroVertice) {
		Vertice otro = (Vertice) otroVertice;
		if (poblacion < otro.poblacion)
			return -1;
		if (poblacion > otro.poblacion)
			return 1;
		return 0;
	}
	
	public String toString () {
		return poblacion+"="+pueblo;
	}
	
	public boolean equals (Object otroVertice) {
		Vertice otro = (Vertice) otroVertice;
		return pueblo.equals(otro.pueblo);
	}
}
