package org.eda1.examenParcialGrupoB.ejercicio01;

public class EmpresaProyectoCiudadBeneficio implements Comparable {
	
	private String empresa;
	private String proyecto; 
	private String ciudad;
	private Double beneficio;
	
	public EmpresaProyectoCiudadBeneficio(){
		empresa="";
		proyecto = "";
		ciudad = "";
		beneficio = 0.0;
	}
	
	public EmpresaProyectoCiudadBeneficio(String emp, String proy, String ciu, Double bene){
		empresa = emp;
		proyecto = proy;
		ciudad = ciu;
		beneficio = bene;
	}

	public void setEmpresa (String emp){
		empresa = emp;	
	}
	
	public void setProyecto (String proy){
		proyecto = proy;
	}
	
	public void setCiudad (String ciu){
		ciudad = ciu;
	}
	
	public void setBeneficio (Double bene){
		beneficio = bene;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getProyecto() {
		return proyecto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Double getBeneficio() {
		return beneficio;
	}
	
	public int compareTo (Object otroEmpresaProyectoCiudadBeneficio){
		if ( ! (otroEmpresaProyectoCiudadBeneficio instanceof EmpresaProyectoCiudadBeneficio))
			throw new ClassCastException("Error en la comparacion");
		EmpresaProyectoCiudadBeneficio  otra = (EmpresaProyectoCiudadBeneficio) otroEmpresaProyectoCiudadBeneficio;
		return beneficio.compareTo(otra.beneficio);
	}
}
