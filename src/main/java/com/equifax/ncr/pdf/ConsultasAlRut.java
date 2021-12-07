package com.equifax.ncr.pdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ConsultasAlRut {

	private String consultasRutUltimos6Meses = "0";
	private List<ConsultaRut> list = new ArrayList<ConsultaRut>();

	public void addParams(Map<String, Object> params) {
		params.put("consultasRutUltimos6Meses", consultasRutUltimos6Meses);
		params.put("consultasRutList", new JRBeanCollectionDataSource(list));
	}

	public String getConsultasRutUltimos6Meses() {
		return consultasRutUltimos6Meses;
	}

	public void setConsultasRutUltimos6Meses(String consultasRutUltimos6Meses) {
		this.consultasRutUltimos6Meses = consultasRutUltimos6Meses;
	}

	public List<ConsultaRut> getList() {
		return list;
	}

	public void add(ConsultaRut consultaRut) {
		list.add(consultaRut);
	}

	public void add(String fecha, String empresa, String informe) {
		ConsultaRut consultaRut = new ConsultaRut();
		consultaRut.setFecha(fecha);
		consultaRut.setEmpresa(empresa);
		consultaRut.setInforme(informe);

		list.add(consultaRut);
	}

}
