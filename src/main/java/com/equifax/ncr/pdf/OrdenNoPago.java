package com.equifax.ncr.pdf;

public class OrdenNoPago {

	private String banco;
	private String cuentaCorriente;
	private String rangoCheque;
	private String sucursal;
	private String fecha;
	private String motivo;
	private String fuente;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getRangoCheque() {
		return rangoCheque;
	}

	public void setRangoCheque(String rangoCheque) {
		this.rangoCheque = rangoCheque;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

}
