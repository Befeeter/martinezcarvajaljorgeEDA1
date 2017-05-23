package org.eda1.actividad01.serializacionED;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CiudadBarrios implements Serializable {

	public String ciudad;
	public Double latitud;
	public Double longitud;
	LinkedList<String> barrios;

	public CiudadBarrios() {
		ciudad = "";
		latitud = new Double(0);
		longitud = new Double(0);
		barrios = new LinkedList<String>();
	}

	public CiudadBarrios(String ciudad, Double latitud, Double longitud) {
		// TODO Auto-generated constructor stub
		this.ciudad = ciudad;
		this.latitud = latitud;
		this.longitud = longitud;
		barrios = new LinkedList<String>();
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public boolean addBarrio(String barrio) {
		if (barrios.contains(barrio))
			return false;
		else {
			barrios.add(barrio);
			return true;
		}
	}

	public LinkedList<String> getBarrios() {
		return barrios;
	}

	/*private void writeObject(ObjectOutputStream out) throws java.io.IOException {
		// Write out internal serialization magic
		out.defaultWriteObject();
		// write out the elements of the collection (using out.writeObject(…))
		out.writeObject(ciudad);
		out.writeDouble(latitud);
		out.writeDouble(longitud);
		out.writeObject(barrios);
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		// Read in internal serialization magic
		in.defaultReadObject();
		// read the elements of the collection (using in.readObject())
		ciudad = (String) in.readObject();
		latitud = in.readDouble();
		longitud = in.readDouble();
		barrios = (LinkedList<String>) in.readObject();

	}*/
}
