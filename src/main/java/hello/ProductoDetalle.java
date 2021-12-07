package hello;

public class ProductoDetalle {
	private String cantidad;

	private String producto;

	private String precioUnitario;

	private String precioTotal;

	private String observacion;

	public String getCantidad() {

		return cantidad;

	}

	public void setCantidad(String cantidad) {

		this.cantidad = cantidad;

	}

	public String getPrecioUnitario() {

		return precioUnitario;

	}

	public void setPrecioUnitario(String precioUnitario) {

		this.precioUnitario = precioUnitario;

	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
