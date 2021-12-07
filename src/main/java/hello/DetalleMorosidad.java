package hello;

public class DetalleMorosidad {
	private String fechaVencimiento;
	private String tipoDocumento;
	private String monto;
	private String librador;
	private String localidad;
	private String tipoDeuda;

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getLibrador() {
		return librador;
	}

	public void setLibrador(String librador) {
		this.librador = librador;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTipoDeuda() {
		return tipoDeuda;
	}

	public void setTipoDeuda(String tipoDeuda) {
		this.tipoDeuda = tipoDeuda;
	}

}
