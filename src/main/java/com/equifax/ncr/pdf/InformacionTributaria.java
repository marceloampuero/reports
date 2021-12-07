package com.equifax.ncr.pdf;

import java.util.Map;

public class InformacionTributaria {

	private String descripcionActividadEconomica;
	private String infraccionesTributarias;

	public void addParams(Map<String, Object> params) {
		params.put("descripcionActividadEconomica", descripcionActividadEconomica);
		params.put("infraccionesTributarias", infraccionesTributarias);

	}

	public String getDescripcionActividadEconomica() {
		return descripcionActividadEconomica;
	}

	public void setDescripcionActividadEconomica(String descripcionActividadEconomica) {
		this.descripcionActividadEconomica = descripcionActividadEconomica;
	}

	public String getInfraccionesTributarias() {
		return infraccionesTributarias;
	}

	public void setInfraccionesTributarias(String infraccionesTributarias) {
		this.infraccionesTributarias = infraccionesTributarias;
	}

}
