package com.equifax.ncr.pdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class BoletinLaboral {

	private String totalImpagos = "0";
	private String montoTotalImpagos = "0";

	private List<Laboral> list = new ArrayList<Laboral>();

	public void addParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("laboralTotalImpagos", totalImpagos);
		params.put("laboralMontoTotalImpagos", "M$ " + montoTotalImpagos);
		params.put("boletinList", new JRBeanCollectionDataSource(list));

	}

	public void add(Laboral laboral) {

		list.add(laboral);

	}

	public void add(String motivo, String institucion, String boletin, String pagina, String fecha,
			String tipoInfraccion, String monto) {
		Laboral laboral = new Laboral();

		laboral.setMotivo(motivo);
		laboral.setInstitucion(institucion);
		laboral.setBoletin(boletin);
		laboral.setPagina(pagina);
		laboral.setFecha(fecha);
		laboral.setTipoInfraccion(tipoInfraccion);
		laboral.setMonto(monto);

		list.add(laboral);

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
