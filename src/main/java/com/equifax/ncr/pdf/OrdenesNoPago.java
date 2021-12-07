package com.equifax.ncr.pdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class OrdenesNoPago {

	private List<OrdenNoPago> list = new ArrayList<OrdenNoPago>();

	public void add(String banco, String cuentaCorriente, String rangoCheque, String sucursal, String fecha,
			String motivo, String fuente) {

		OrdenNoPago orden = new OrdenNoPago();

		orden.setBanco(banco);
		orden.setCuentaCorriente(cuentaCorriente);
		orden.setRangoCheque(rangoCheque);
		orden.setSucursal(sucursal);
		orden.setFecha(fecha);
		orden.setMotivo(motivo);
		orden.setFuente(fuente);

		list.add(orden);

	}

	public void add(OrdenNoPago ordenNoPago) {
		list.add(ordenNoPago);
	}

	public void addParams(Map<String, Object> params) {
		// TODO Auto-generated method stub

		params.put("ordenesNoPagoList", new JRBeanCollectionDataSource(list));

	}

}
