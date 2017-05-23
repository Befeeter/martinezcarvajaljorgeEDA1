package org.eda1.practica02.ejercicio01;

public class MaquinaContador implements Comparable {

	private String maquina;
	private int contador;

	public MaquinaContador(String maquina, int contador) {
		this.maquina = maquina;
		this.contador = contador;
	}

	public MaquinaContador(String maquina) {
		this.maquina = maquina;
		this.contador = 1;
	}

	public MaquinaContador() {
		this.maquina = "";
		this.contador = 0;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int c) {
		this.contador = c;
	}

	public void incrementarContador() {
		this.contador++;
	}

	public int compareTo(Object otraMaquinaContador) {
		if (!(otraMaquinaContador instanceof MaquinaContador))
			throw new ClassCastException("Objeto Invalido");
		// String otra = ((MaquinaContador) otraMaquinacontador).getMaquina();
		// return this.maquina.compareTo(otra);
		MaquinaContador otra = (MaquinaContador) otraMaquinaContador;
		return this.maquina.compareTo(otra.getMaquina());
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof MaquinaContador))
			throw new ClassCastException("Objeto invalido");
		String otra = ((MaquinaContador) obj).getMaquina();
		return this.maquina.equals(otra);
	}

	public String toString() {
		String cadena = "";
		return "["+maquina+", "+contador+"]";
	}

}
