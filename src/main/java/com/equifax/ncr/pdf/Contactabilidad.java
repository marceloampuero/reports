package com.equifax.ncr.pdf;

import java.util.Map;

public class Contactabilidad {

	private String direccion;
	private String ciudad;
	private String comuna;
	private String codigoPostal;
	private String tipoDireccion;
	private String fecha;
	private String fuente;
	private String telefono;
	private String fechaCarga;
	private String telefonoFuente;
	private String direccionElectronica;
	private String direccionUrl;

	public void addParams(Map<String, Object> params) {
		params.put("contactabilidadDireccion", direccion);
		params.put("contactabilidadCiudad", ciudad);
		params.put("contactabilidadComuna", comuna);
		params.put("contactabilidadCodigoPostal", codigoPostal);
		params.put("contactabilidadTipoDireccion", tipoDireccion);
		params.put("contactabilidadFecha", fecha);
		params.put("contactabilidadFuente", fuente);
		params.put("contactabilidadTelefono", telefono);
		params.put("contactabilidadFechaCarga", fechaCarga);
		params.put("contactabilidadTelefonoFuente", telefonoFuente);
		params.put("contactabilidadDireccionElectronica", direccionElectronica);
		params.put("contactabilidadDireccionUrl", direccionUrl);

	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public String getTelefonoFuente() {
		return telefonoFuente;
	}

	public void setTelefonoFuente(String telefonoFuente) {
		this.telefonoFuente = telefonoFuente;
	}

	public String getDireccionElectronica() {
		return direccionElectronica;
	}

	public void setDireccionElectronica(String direccionElectronica) {
		this.direccionElectronica = direccionElectronica;
	}

	public String getDireccionUrl() {
		return direccionUrl;
	}

	public void setDireccionUrl(String direccionUrl) {
		this.direccionUrl = direccionUrl;
	}

}
