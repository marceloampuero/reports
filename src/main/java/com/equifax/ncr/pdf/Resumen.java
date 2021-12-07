package com.equifax.ncr.pdf;

import java.util.Map;

public class Resumen {

	private String totalImpagos;
	private String acreditacionesFinancieras;
	private String creditoVigente;
	private String indicadorRiesgo;
	private String puntajeCalculado;

	public void addParams(Map<String, Object> params) {

		params.put("totalImpagos", totalImpagos);
		params.put("acreditacionesFinancieras", acreditacionesFinancieras);
		params.put("creditoVigente", creditoVigente);
		params.put("indicadorRiesgo", indicadorRiesgo);
		params.put("puntajeCalculado", puntajeCalculado);

	}

	public String getTotalImpagos() {
		return totalImpagos;
	}

	public void setTotalImpagos(String totalImpagos) {
		this.totalImpagos = totalImpagos;
	}

	public String getAcreditacionesFinancieras() {
		return acreditacionesFinancieras;
	}

	public void setAcreditacionesFinancieras(String acreditacionesFinancieras) {
		this.acreditacionesFinancieras = acreditacionesFinancieras;
	}

	public String getCreditoVigente() {
		return creditoVigente;
	}

	public void setCreditoVigente(String creditoVigente) {
		this.creditoVigente = creditoVigente;
	}

	public String getIndicadorRiesgo() {
		return indicadorRiesgo;
	}

	public void setIndicadorRiesgo(String indicadorRiesgo) {
		this.indicadorRiesgo = indicadorRiesgo;
	}

	public String getPuntajeCalculado() {
		return puntajeCalculado;
	}

	public void setPuntajeCalculado(String puntajeCalculado) {
		this.puntajeCalculado = puntajeCalculado;
	}

}
