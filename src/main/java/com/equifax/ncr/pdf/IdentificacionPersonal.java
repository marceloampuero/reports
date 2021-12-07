package com.equifax.ncr.pdf;

import java.util.Map;

public class IdentificacionPersonal {

	private Identificacion identificacion = new Identificacion();
	private Contactabilidad contactabilidad = new Contactabilidad();
	private Discrepancias discrepancias = new Discrepancias();

	public void addParams(Map<String, Object> params) {
		identificacion.addParams(params);
		contactabilidad.addParams(params);
		discrepancias.addParams(params);

	}

	public Identificacion getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = identificacion;
	}

	public Contactabilidad getContactabilidad() {
		return contactabilidad;
	}

	public void setContactabilidad(Contactabilidad contactabilidad) {
		this.contactabilidad = contactabilidad;
	}

	public Discrepancias getDiscrepancias() {
		return discrepancias;
	}

	public void setDiscrepancias(Discrepancias discrepancias) {
		this.discrepancias = discrepancias;
	}

}
