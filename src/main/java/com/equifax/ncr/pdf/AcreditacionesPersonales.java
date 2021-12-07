package com.equifax.ncr.pdf;

import java.util.Map;

public class AcreditacionesPersonales {

	private String numeroVehiculos;
	private String vehiculosMontoTotalAvaluo;
	private String numeroPropiedades;
	private String propiedadesMontoTotalAvaluo;
	private String socioeconomico;
	private String ise;
	private String sociedades;
	private String relacionesComoSocio;
	private String comercioExterior;
	private String ultimaExportacion;
	private String montoUltimaExportacion;
	private String ordenesNoPago;

	public void addParams(Map<String, Object> params) {

		params.put("numeroVehiculos", numeroVehiculos);
		params.put("vehiculosMontoTotalAvaluo", vehiculosMontoTotalAvaluo);
		params.put("numeroPropiedades", numeroPropiedades);
		params.put("propiedadesMontoTotalAvaluo", propiedadesMontoTotalAvaluo);
		params.put("socioeconomico", socioeconomico);
		params.put("ise", ise);
		params.put("sociedades", sociedades);
		params.put("relacionesComoSocio", relacionesComoSocio);
		params.put("comercioExterior", comercioExterior);
		params.put("ultimaExportacion", ultimaExportacion);
		params.put("montoUltimaExportacion", montoUltimaExportacion);
		params.put("ordenesNoPago", ordenesNoPago);

	}

	public String getNumeroVehiculos() {
		return numeroVehiculos;
	}

	public void setNumeroVehiculos(String numeroVehiculos) {
		this.numeroVehiculos = numeroVehiculos;
	}

	public String getVehiculosMontoTotalAvaluo() {
		return vehiculosMontoTotalAvaluo;
	}

	public void setVehiculosMontoTotalAvaluo(String vehiculosMontoTotalAvaluo) {
		this.vehiculosMontoTotalAvaluo = vehiculosMontoTotalAvaluo;
	}

	public String getNumeroPropiedades() {
		return numeroPropiedades;
	}

	public void setNumeroPropiedades(String numeroPropiedades) {
		this.numeroPropiedades = numeroPropiedades;
	}

	public String getPropiedadesMontoTotalAvaluo() {
		return propiedadesMontoTotalAvaluo;
	}

	public void setPropiedadesMontoTotalAvaluo(String propiedadesMontoTotalAvaluo) {
		this.propiedadesMontoTotalAvaluo = propiedadesMontoTotalAvaluo;
	}

	public String getSocioeconomico() {
		return socioeconomico;
	}

	public void setSocioeconomico(String socioeconomico) {
		this.socioeconomico = socioeconomico;
	}

	public String getIse() {
		return ise;
	}

	public void setIse(String ise) {
		this.ise = ise;
	}

	public String getSociedades() {
		return sociedades;
	}

	public void setSociedades(String sociedades) {
		this.sociedades = sociedades;
	}

	public String getRelacionesComoSocio() {
		return relacionesComoSocio;
	}

	public void setRelacionesComoSocio(String relacionesComoSocio) {
		this.relacionesComoSocio = relacionesComoSocio;
	}

	public String getComercioExterior() {
		return comercioExterior;
	}

	public void setComercioExterior(String comercioExterior) {
		this.comercioExterior = comercioExterior;
	}

	public String getUltimaExportacion() {
		return ultimaExportacion;
	}

	public void setUltimaExportacion(String ultimaExportacion) {
		this.ultimaExportacion = ultimaExportacion;
	}

	public String getMontoUltimaExportacion() {
		return montoUltimaExportacion;
	}

	public void setMontoUltimaExportacion(String montoUltimaExportacion) {
		this.montoUltimaExportacion = montoUltimaExportacion;
	}

	public String getOrdenesNoPago() {
		return ordenesNoPago;
	}

	public void setOrdenesNoPago(String ordenesNoPago) {
		this.ordenesNoPago = ordenesNoPago;
	}

}
