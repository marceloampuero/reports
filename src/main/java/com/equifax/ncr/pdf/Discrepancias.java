package com.equifax.ncr.pdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Discrepancias {

	private List<Discrepancia> discrepanciasList = new ArrayList<Discrepancia>();

	public void addParams(Map<String, Object> params) {
		params.put("identificacionDiscrepanciasList", new JRBeanCollectionDataSource(discrepanciasList));

	}

	public void add(Discrepancia discrepancia) {
		discrepanciasList.add(discrepancia);
	}

	public void addDiscrepancia(String numero, String fecha, String seccion, String campo, String motivo) {

		Discrepancia discrepancia = new Discrepancia();

		discrepancia.setNumero(numero);
		discrepancia.setFecha(fecha);
		discrepancia.setSeccion(seccion);
		discrepancia.setCampo(campo);
		discrepancia.setMotivo(motivo);

		discrepanciasList.add(discrepancia);
	}

	public List<Discrepancia> getDiscrepanciasList() {

		return discrepanciasList;
	}

}
