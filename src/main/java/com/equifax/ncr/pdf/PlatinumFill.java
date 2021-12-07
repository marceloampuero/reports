package com.equifax.ncr.pdf;

public class PlatinumFill {

	public static PlatinumPdf fillPlatinum() {
		PlatinumPdf platinum = new PlatinumPdf();

		platinum.setNombre("ARAVENA ESTAY CAROLINA DEL PILAR");
		platinum.setRut("13.407.071-6");
		platinum.setEdad("30");
		platinum.setFechaInforme("15-03-2016");
		platinum.setHoraInforme("18:18");
		platinum.setNumeroVerificacion("556789231234");

		fillResumen(platinum);
		fillIdentificacion(platinum);

		return platinum;

	}

	private static void fillResumen(PlatinumPdf platinum) {

		platinum.getResumen().setTotalImpagos("10");
		platinum.getResumen().setIndicadorRiesgo("777");
		platinum.getResumen().setAcreditacionesFinancieras("Sí");
		platinum.getResumen().setCreditoVigente("12.100");
		platinum.getResumen().setPuntajeCalculado("11-12-2015");
	}

	private static void fillIdentificacion(PlatinumPdf platinum) {
		Identificacion identificacion = platinum.getIdentificacionPersonal().getIdentificacion();
		identificacion.setFechaNacimiento("12 Enero 1975");
		identificacion.setEstadoCivil("Casado");
		identificacion.setSexo("Femenino");
		identificacion.setNacionalidad("Chilena");
		identificacion.setTipoNacionalidad("Chilena");

		identificacion.setIndicadorInterdicto("No");
		identificacion.setIndicadorPersonaDifunta("No");
		identificacion.setFechaDefuncion("No");
		identificacion.setFechaInterdicto("No");
		identificacion.setIndicadorVerificadorIdentidad("Sí");

	}

}
