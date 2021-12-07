package com.equifax.ncr.pdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Morosidades {

	private String totalImpagos = "0";
	private String montoTotalImpagos = "0";

	private List<Morosidad> list = new ArrayList<Morosidad>();

	public void addParams(Map<String, Object> params) {

		params.put("morosidadTotalImpagos", totalImpagos);
		params.put("morosidadMontoTotalImpagos", montoTotalImpagos);
		params.put("morosidadList", new JRBeanCollectionDataSource(list));

	}

	public void add(Morosidad morosidad) {

		list.add(morosidad);

	}

	public void add(String fechaVencimiento, String tipoDocumento, String monto, String librador, String localidad,
			String tipoDeuda) {
		Morosidad morosidad = new Morosidad();

		morosidad.setFechaVencimiento(fechaVencimiento);
		morosidad.setTipoDocumento(tipoDocumento);
		morosidad.setMonto(monto);
		morosidad.setLibrador(librador);
		morosidad.setLocalidad(localidad);
		morosidad.setTipoDeuda(tipoDeuda);

		list.add(morosidad);

	}

	public String getTotalImpagos() {
		return totalImpagos;
	}

	public void setTotalImpagos(String totalImpagos) {
		this.totalImpagos = totalImpagos;
	}

	public String getMontoTotalImpagos() {
		return montoTotalImpagos;
	}

	public void setMontoTotalImpagos(String montoTotalImpagos) {
		this.montoTotalImpagos = montoTotalImpagos;
	}

}
