package com.equifax.ncr.pdf;

import java.util.Map;

public class Identificacion {

	private String fechaNacimiento;
	private String nacionalidad;
	private String tipoNacionalidad;
	private String sexo;
	private String indicadorPersonaDifunta;
	private String fechaDefuncion;
	private String indicadorInterdicto;
	private String fechaInterdicto;
	private String indicadorVerificadorIdentidad;
	private String estadoCivil;
	private String rutConyuge;

	public void addParams(Map<String, Object> params) {

		params.put("fechaNacimiento", fechaNacimiento);
		params.put("nacionalidad", nacionalidad);
		params.put("tipoNacionalidad", tipoNacionalidad);
		params.put("sexo", sexo);
		params.put("indicadorPersonaDifunta", indicadorPersonaDifunta);
		params.put("fechaDefuncion", fechaDefuncion);
		params.put("indicadorInterdicto", indicadorInterdicto);
		params.put("fechaInterdicto", fechaInterdicto);
		params.put("indicadorVerificadorIdentidad", indicadorVerificadorIdentidad);
		params.put("estadoCivil", estadoCivil);
		params.put("rutConyuge", rutConyuge);
		params.put("identificacionList", Util.oneElementList());
		params.put("identificacionIdList", Util.oneElementList());
		params.put("identificacionContactabilidadList", Util.oneElementList());
		params.put("identificacionDiscrepanciasList", Util.oneElementList());

	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTipoNacionalidad() {
		return tipoNacionalidad;
	}

	public void setTipoNacionalidad(String tipoNacionalidad) {
		this.tipoNacionalidad = tipoNacionalidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getIndicadorPersonaDifunta() {
		return indicadorPersonaDifunta;
	}

	public void setIndicadorPersonaDifunta(String indicadorPersonaDifunta) {
		this.indicadorPersonaDifunta = indicadorPersonaDifunta;
	}

	public String getFechaDefuncion() {
		return fechaDefuncion;
	}

	public void setFechaDefuncion(String fechaDefuncion) {
		this.fechaDefuncion = fechaDefuncion;
	}

	public String getIndicadorInterdicto() {
		return indicadorInterdicto;
	}

	public void setIndicadorInterdicto(String indicadorInterdicto) {
		this.indicadorInterdicto = indicadorInterdicto;
	}

	public String getFechaInterdicto() {
		return fechaInterdicto;
	}

	public void setFechaInterdicto(String fechaInterdicto) {
		this.fechaInterdicto = fechaInterdicto;
	}

	public String getIndicadorVerificadorIdentidad() {
		return indicadorVerificadorIdentidad;
	}

	public void setIndicadorVerificadorIdentidad(String indicadorVerificadorIdentidad) {
		this.indicadorVerificadorIdentidad = indicadorVerificadorIdentidad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getRutConyuge() {
		return rutConyuge;
	}

	public void setRutConyuge(String rutConyuge) {
		this.rutConyuge = rutConyuge;
	}

}
