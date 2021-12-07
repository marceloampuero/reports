package com.equifax.ncr.pdf;

import java.util.Map;

public class Antecedentes {

	private String profesion;
	private String oficio;
	private DatosEmpresa datosEmpresa = new DatosEmpresa();

	public void addParams(Map<String, Object> params) {

		params.put("antecedentesProfesion", profesion);
		params.put("antecedentesOficio", oficio);
		params.put("datosEmpresa", datosEmpresa.getDatosEmpresa());
		params.put("direccionLaboral", datosEmpresa.getDireccionLaboral());
		params.put("comunaDireccionLaboral", datosEmpresa.getComunaDireccionLaboral());
		params.put("ciudadDireccionLaboral", datosEmpresa.getCiudadDireccionLaboral());
		params.put("fechaVerificacionDatosLaboral", datosEmpresa.getFechaVerificacionDatos());
		params.put("fechaActualizacionLaboral", datosEmpresa.getFechaActualizacion());
		params.put("fuenteVerificacionLaboral", datosEmpresa.getFuenteVerificacion());

	}

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

	public DatosEmpresa getDatosEmpresa() {
		return datosEmpresa;
	}

	public void setDatosEmpresa(DatosEmpresa datosEmpresa) {
		this.datosEmpresa = datosEmpresa;
	}

}
