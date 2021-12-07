package com.equifax.ncr.pdf;

import java.util.Map;

public class Acreditaciones {

	private AcreditacionesPersonales acreditacionesPersonales = new AcreditacionesPersonales();
	private OrdenesNoPago ordenesNoPago = new OrdenesNoPago();
	private InformacionTributaria informacionTributaria = new InformacionTributaria();

	public void addParams(Map<String, Object> params) {

		acreditacionesPersonales.addParams(params);
		ordenesNoPago.addParams(params);
		informacionTributaria.addParams(params);

	}

	public AcreditacionesPersonales getAcreditacionesPersonales() {
		return acreditacionesPersonales;
	}

	public void setAcreditacionesPersonales(AcreditacionesPersonales acreditacionesPersonales) {
		this.acreditacionesPersonales = acreditacionesPersonales;
	}

	public OrdenesNoPago getOrdenesNoPago() {
		return ordenesNoPago;
	}

	public void setOrdenesNoPago(OrdenesNoPago ordenesNoPago) {
		this.ordenesNoPago = ordenesNoPago;
	}

	public InformacionTributaria getInformacionTributaria() {
		return informacionTributaria;
	}

	public void setInformacionTributaria(InformacionTributaria informacionTributaria) {
		this.informacionTributaria = informacionTributaria;
	}

}
