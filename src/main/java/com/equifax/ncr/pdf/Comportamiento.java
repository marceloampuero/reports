package com.equifax.ncr.pdf;

import java.util.Map;

public class Comportamiento {

	private IndicadorRiesgo indicadorRiesgo = new IndicadorRiesgo();
	private ResumenMorosidades resumenMorosidades = new ResumenMorosidades();
	private ConsultasAlRut consultasAlRut = new ConsultasAlRut();
	private DetalleProtestos detalleProtestos = new DetalleProtestos();
	private DeudaSistemaFinanciero deudaSistemaFinanciero = new DeudaSistemaFinanciero();

	public void addParams(Map<String, Object> params) {

		indicadorRiesgo.addParams(params);
		resumenMorosidades.addParams(params);
		consultasAlRut.addParams(params);
		detalleProtestos.addParams(params);
		deudaSistemaFinanciero.addParams(params);

	}

	public IndicadorRiesgo getIndicadorRiesgo() {
		return indicadorRiesgo;
	}

	public void setIndicadorRiesgo(IndicadorRiesgo indicadorRiesgo) {
		this.indicadorRiesgo = indicadorRiesgo;
	}

	public ResumenMorosidades getResumenMorosidades() {
		return resumenMorosidades;
	}

	public void setResumenMorosidades(ResumenMorosidades resumenMorosidades) {
		this.resumenMorosidades = resumenMorosidades;
	}

	public ConsultasAlRut getConsultasAlRut() {
		return consultasAlRut;
	}

	public void setConsultasAlRut(ConsultasAlRut consultasAlRut) {
		this.consultasAlRut = consultasAlRut;
	}

	public DetalleProtestos getDetalleProtestos() {
		return detalleProtestos;
	}

	public void setDetalleProtestos(DetalleProtestos detalleProtestos) {
		this.detalleProtestos = detalleProtestos;
	}

	public DeudaSistemaFinanciero getDeudaSistemaFinanciero() {
		return deudaSistemaFinanciero;
	}

	public void setDeudaSistemaFinanciero(DeudaSistemaFinanciero deudaSistemaFinanciero) {
		this.deudaSistemaFinanciero = deudaSistemaFinanciero;
	}

}
