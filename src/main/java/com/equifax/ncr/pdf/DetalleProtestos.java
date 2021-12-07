package com.equifax.ncr.pdf;

import java.util.Map;

public class DetalleProtestos {

	private Morosidades morosidades = new Morosidades();
	private BoletinLaboral boletinLaboral = new BoletinLaboral();

	public void addParams(Map<String, Object> params) {

		morosidades.addParams(params);
		boletinLaboral.addParams(params);
	}

	public Morosidades getMorosidades() {
		return morosidades;
	}

	public void setMorosidades(Morosidades morosidades) {
		this.morosidades = morosidades;
	}

	public BoletinLaboral getBoletinLaboral() {
		return boletinLaboral;
	}

	public void setBoletinLaboral(BoletinLaboral boletinLaboral) {
		this.boletinLaboral = boletinLaboral;
	}

}
