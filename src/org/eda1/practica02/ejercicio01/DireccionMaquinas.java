package org.eda1.practica02.ejercicio01;

import org.eda1.estructurasdedatos.BSTree;

public class DireccionMaquinas implements Comparable {

	private String direccion;
	private BSTree<MaquinaContador> maquinas;

	public DireccionMaquinas() {
		direccion = "";
		maquinas = new BSTree<MaquinaContador>();
	}

	public DireccionMaquinas(String direc) {
		direccion = direc;
		maquinas = new BSTree<MaquinaContador>();
		
	}

	public DireccionMaquinas(String direc, String maqui) {
		direccion = direc;
		MaquinaContador m = new MaquinaContador(maqui);
		maquinas = new BSTree<MaquinaContador>();
		maquinas.add(m);
	}

	public DireccionMaquinas(String direc, String maqui, int cont) {
		direccion = direc;
		MaquinaContador m = new MaquinaContador(maqui, cont);
		maquinas.add(m);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BSTree<MaquinaContador> getMaquinas() {
		return maquinas;
	}

	public boolean addMaquina(MaquinaContador mc) {
		maquinas.add(mc);
		return true;
	}

	public boolean addMaquinaWithFind(MaquinaContador mc) {
		MaquinaContador aux = maquinas.find(mc); // devuelve el objeto
													// (maquinacontador) del
													// bstree con el mismo
													// nombre.
		if (aux != null) {
			aux.incrementarContador();
			return false;
		} else {
			maquinas.add(mc);
			return true;
		}
	}

	public int compareTo(Object otraDireccionMaquina) {
		if (!(otraDireccionMaquina instanceof DireccionMaquinas))
			throw new ClassCastException("Error de clase");
		DireccionMaquinas otra = (DireccionMaquinas) otraDireccionMaquina;
		return this.getDireccion().compareTo(otra.getDireccion());
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof DireccionMaquinas))
			throw new ClassCastException("Error de clase");
		DireccionMaquinas otra = (DireccionMaquinas) obj;

		return this.getDireccion().equals(otra.getDireccion());
	}

	public String toString() {
		String cadena = "("+direccion+", "+maquinas.toString()+")";
		return cadena;
	}

}
