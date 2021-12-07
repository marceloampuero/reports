package com.equifax.ncr.pdf;

import java.util.HashMap;
import java.util.Map;

public class PlatinumPdf {

	private Resumen resumen = new Resumen();
	private IdentificacionPersonal identificacionPersonal = new IdentificacionPersonal();
	private Acreditaciones acreditaciones = new Acreditaciones();
	private Comportamiento comportamiento = new Comportamiento();
	private Antecedentes antedecentes = new Antecedentes();

	private String nombre;
	private String rut;
	private String edad;
	private String fechaInforme;
	private String horaInforme;
	private String numeroVerificacion;

	public Resumen getResumen() {
		return resumen;
	}

	public void setResumen(Resumen resumen) {
		this.resumen = resumen;
	}

	public IdentificacionPersonal getIdentificacionPersonal() {
		return identificacionPersonal;
	}

	public void setIdentificacionPersonal(IdentificacionPersonal identificacionPersonal) {
		this.identificacionPersonal = identificacionPersonal;
	}

	public Acreditaciones getAcreditaciones() {
		return acreditaciones;
	}

	public void setAcreditaciones(Acreditaciones acreditaciones) {
		this.acreditaciones = acreditaciones;
	}

	public Comportamiento getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(Comportamiento comportamiento) {
		this.comportamiento = comportamiento;
	}

	public Antecedentes getAntedecentes() {
		return antedecentes;
	}

	public void setAntedecentes(Antecedentes antedecentes) {
		this.antedecentes = antedecentes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getFechaInforme() {
		return fechaInforme;
	}

	public void setFechaInforme(String fechaInforme) {
		this.fechaInforme = fechaInforme;
	}

	public String getHoraInforme() {
		return horaInforme;
	}

	public void setHoraInforme(String horaInforme) {
		this.horaInforme = horaInforme;
	}

	public String getNumeroVerificacion() {
		return numeroVerificacion;
	}

	public void setNumeroVerificacion(String numeroVerificacion) {
		this.numeroVerificacion = numeroVerificacion;
	}

	private void addParams(Map<String, Object> params) {

		params.put("nombreCompleto", this.nombre);
		params.put("rut", this.rut);
		params.put("edad", this.edad);
		params.put("fechaInforme", this.fechaInforme);
		params.put("horaInforme", this.horaInforme);
		params.put("numeroCertificado", this.numeroVerificacion);

	}

	public Map<String, Object> getParams() {

		Map<String, Object> params = new HashMap<String, Object>();

		this.addParams(params);
		this.resumen.addParams(params);
		this.identificacionPersonal.addParams(params);
		this.acreditaciones.addParams(params);
		this.comportamiento.addParams(params);
		this.antedecentes.addParams(params);

		return params;

	}

}
