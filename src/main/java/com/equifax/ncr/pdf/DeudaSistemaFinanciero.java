package com.equifax.ncr.pdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hello.DetalleDeudaSistemaFinanciero;

public class DeudaSistemaFinanciero {

	private List<String> meses = new ArrayList<String>();

	public void addParams(Map<String, Object> params) {
		// TODO Auto-generated method stub

	}

	private List<DetalleDeudaSistemaFinanciero> getListDetalleSistemaFinanciero() {

		List<DetalleDeudaSistemaFinanciero> list = new ArrayList<DetalleDeudaSistemaFinanciero>();
		String[] tiposDeCredito = { "Derechos al día e Impagos < 30 días", "Leasing al día",
				"Directos impagos entre 30 y < 90 días", "Directos impagos entre 90 y < 180 días",
				"Direct. impagos entre 180 ds y < 3 años", "Directos impagos > = 3 años", "Leasing impagos",
				"Consumo Monto", "Consumo Acreedor", "Vivienda", "Operaciones Financieras",
				"Instrumentos de Deudas Adquiridas", "Comerciales", "Indirectos al día e impagos < 30 días",
				"Indir. impagos entre 30 ds y < 3 años", "Indirectos impagos >= 3 años", "Línea de Crédito Disponible",
				"Contingentes" };
		String[] colPeriodo = { "7.626", "0", "0", "100.999", "0", "0", "0", "0", "7.636", "0", "0", "0", "0", "0",
				"4.289", "0", "0", "0" };

		DetalleDeudaSistemaFinanciero ddsf;

		for (int i = 0; i < tiposDeCredito.length; i++) {

			ddsf = new DetalleDeudaSistemaFinanciero();

			ddsf.setTipoDeCredito(tiposDeCredito[i]);
			ddsf.setCol1Periodo(colPeriodo[i]);
			ddsf.setCol2Periodo(colPeriodo[i]);
			ddsf.setCol3Periodo(colPeriodo[i]);
			ddsf.setCol4Periodo(colPeriodo[i]);
			ddsf.setCol5Periodo(colPeriodo[i]);
			ddsf.setCol6Periodo(colPeriodo[i]);
			ddsf.setCol7Periodo(colPeriodo[i]);
			ddsf.setCol8Periodo(colPeriodo[i]);
			ddsf.setCol9Periodo(colPeriodo[i]);
			ddsf.setCol10Periodo(colPeriodo[i]);
			ddsf.setCol11Periodo(colPeriodo[i]);
			ddsf.setCol12Periodo(colPeriodo[i]);
			ddsf.setAgrupado("");
			ddsf.setRojo(this.isRojo(tiposDeCredito[i]));

			list.add(ddsf);
		}

		return list;
	}

	private String isRojo(String tipoCredito) {

		if (tipoCredito == "Directos impagos entre 30 y < 90 días"
				|| tipoCredito == "Directos impagos entre 90 y < 180 días"
				|| tipoCredito == "Direct. impagos entre 180 ds y < 3 años"
				|| tipoCredito == "Directos impagos > = 3 años" || tipoCredito == "Leasing impagos"
				|| tipoCredito == "Indir. impagos entre 30 ds y < 3 años"
				|| tipoCredito == "Indirectos impagos >= 3 años") {
			return "1";
		}

		return "0";

	}

	class FechaValor {

		private String fecha;
		private String valor;

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

	}

}
