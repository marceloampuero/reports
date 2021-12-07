package hello;

import java.util.List;
import java.util.Map;

public class AntecedentesLaborales {
	
	private String profesion;
	private String oficio;	
	private Map<String, String> datosEmpresa;	
	private List<DatosEmpresa> datosEmpresaHistoricos;
	
	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Map<String, String> getDatosEmpresa() {
		return datosEmpresa;
	}

	public void setDatosEmpresa(Map<String, String> datosEmpresa) {
		this.datosEmpresa = datosEmpresa;
	}

	public List<DatosEmpresa> getDatosEmpresaHistoricos() {
		return datosEmpresaHistoricos;
	}

	public void setDatosEmpresaHistoricos(List<DatosEmpresa> datosEmpresaHistoricos) {
		this.datosEmpresaHistoricos = datosEmpresaHistoricos;
	}

}
