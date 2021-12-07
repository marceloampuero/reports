package hello;

import java.util.Map;

public class ResumenMorosidades {

	private String docsPeriodoUltimosSeis = "0";
	private String docsPeriodoSeisDoce = "0";
	private String docsPeriodoDoce24 = "0";
	private String docsPeriodoMas24 = "0";
	private String docsPeriodoTotales = "0";

	private String docsAcumuladosUltimosSeis = "0";
	private String docsAcumuladosSeisDoce = "0";
	private String docsAcumuladosDoce24 = "0";
	private String docsAcumuladosMas24 = "0";
	private String docsAcumuladosTotales = "0";

	private String docsMontosPeriodoUltimosSeis = "0";
	private String docsMontosPeriodoSeisDoce = "0";
	private String docsMontosPeriodoDoce24 = "0";
	private String docsMontosPeriodoMas24 = "0";
	private String docsMontosPeriodoTotales = "0";

	private String docsMontosAcumuladosUltimosSeis = "0";
	private String docsMontosAcumuladosSeisDoce = "0";
	private String docsMontosAcumuladosDoce24 = "0";
	private String docsMontosAcumuladosMas24 = "0";
	private String docsMontosAcumuladosTotales = "0";

	private String totalImpagos = "0";
	private String montoTotalImpagos = "0";
	private String vencimientoUltimoProtesto;
	private String montoUltimoPago = "0";

	public String getDocsPeriodoUltimosSeis() {
		return docsPeriodoUltimosSeis;
	}

	public void setDocsPeriodoUltimosSeis(String docsPeriodoUltimosSeis) {
		this.docsPeriodoUltimosSeis = docsPeriodoUltimosSeis;
	}

	public String getDocsPeriodoSeisDoce() {
		return docsPeriodoSeisDoce;
	}

	public void setDocsPeriodoSeisDoce(String docsPeriodoSeisDoce) {
		this.docsPeriodoSeisDoce = docsPeriodoSeisDoce;
	}

	public String getDocsPeriodoDoce24() {
		return docsPeriodoDoce24;
	}

	public void setDocsPeriodoDoce24(String docsPeriodoDoce24) {
		this.docsPeriodoDoce24 = docsPeriodoDoce24;
	}

	public String getDocsPeriodoMas24() {
		return docsPeriodoMas24;
	}

	public void setDocsPeriodoMas24(String docsPeriodoMas24) {
		this.docsPeriodoMas24 = docsPeriodoMas24;
	}

	public String getDocsPeriodoTotales() {
		return docsPeriodoTotales;
	}

	public void setDocsPeriodoTotales(String docsPeriodoTotales) {
		this.docsPeriodoTotales = docsPeriodoTotales;
	}

	public String getDocsAcumuladosUltimosSeis() {
		return docsAcumuladosUltimosSeis;
	}

	public void setDocsAcumuladosUltimosSeis(String docsAcumuladosUltimosSeis) {
		this.docsAcumuladosUltimosSeis = docsAcumuladosUltimosSeis;
	}

	public String getDocsAcumuladosSeisDoce() {
		return docsAcumuladosSeisDoce;
	}

	public void setDocsAcumuladosSeisDoce(String docsAcumuladosSeisDoce) {
		this.docsAcumuladosSeisDoce = docsAcumuladosSeisDoce;
	}

	public String getDocsAcumuladosDoce24() {
		return docsAcumuladosDoce24;
	}

	public void setDocsAcumuladosDoce24(String docsAcumuladosDoce24) {
		this.docsAcumuladosDoce24 = docsAcumuladosDoce24;
	}

	public String getDocsAcumuladosMas24() {
		return docsAcumuladosMas24;
	}

	public void setDocsAcumuladosMas24(String docsAcumuladosMas24) {
		this.docsAcumuladosMas24 = docsAcumuladosMas24;
	}

	public String getDocsAcumuladosTotales() {
		return docsAcumuladosTotales;
	}

	public void setDocsAcumuladosTotales(String docsAcumuladosTotales) {
		this.docsAcumuladosTotales = docsAcumuladosTotales;
	}

	public String getDocsMontosPeriodoUltimosSeis() {
		return docsMontosPeriodoUltimosSeis;
	}

	public void setDocsMontosPeriodoUltimosSeis(String docsMontosPeriodoUltimosSeis) {
		this.docsMontosPeriodoUltimosSeis = docsMontosPeriodoUltimosSeis;
	}

	public String getDocsMontosPeriodoSeisDoce() {
		return docsMontosPeriodoSeisDoce;
	}

	public void setDocsMontosPeriodoSeisDoce(String docsMontosPeriodoSeisDoce) {
		this.docsMontosPeriodoSeisDoce = docsMontosPeriodoSeisDoce;
	}

	public String getDocsMontosPeriodoDoce24() {
		return docsMontosPeriodoDoce24;
	}

	public void setDocsMontosPeriodoDoce24(String docsMontosPeriodoDoce24) {
		this.docsMontosPeriodoDoce24 = docsMontosPeriodoDoce24;
	}

	public String getDocsMontosPeriodoMas24() {
		return docsMontosPeriodoMas24;
	}

	public void setDocsMontosPeriodoMas24(String docsMontosPeriodoMas24) {
		this.docsMontosPeriodoMas24 = docsMontosPeriodoMas24;
	}

	public String getDocsMontosPeriodoTotales() {
		return docsMontosPeriodoTotales;
	}

	public void setDocsMontosPeriodoTotales(String docsMontosPeriodoTotales) {
		this.docsMontosPeriodoTotales = docsMontosPeriodoTotales;
	}

	public String getDocsMontosAcumuladosUltimosSeis() {
		return docsMontosAcumuladosUltimosSeis;
	}

	public void setDocsMontosAcumuladosUltimosSeis(String docsMontosAcumuladosUltimosSeis) {
		this.docsMontosAcumuladosUltimosSeis = docsMontosAcumuladosUltimosSeis;
	}

	public String getDocsMontosAcumuladosSeisDoce() {
		return docsMontosAcumuladosSeisDoce;
	}

	public void setDocsMontosAcumuladosSeisDoce(String docsMontosAcumuladosSeisDoce) {
		this.docsMontosAcumuladosSeisDoce = docsMontosAcumuladosSeisDoce;
	}

	public String getDocsMontosAcumuladosDoce24() {
		return docsMontosAcumuladosDoce24;
	}

	public void setDocsMontosAcumuladosDoce24(String docsMontosAcumuladosDoce24) {
		this.docsMontosAcumuladosDoce24 = docsMontosAcumuladosDoce24;
	}

	public String getDocsMontosAcumuladosMas24() {
		return docsMontosAcumuladosMas24;
	}

	public void setDocsMontosAcumuladosMas24(String docsMontosAcumuladosMas24) {
		this.docsMontosAcumuladosMas24 = docsMontosAcumuladosMas24;
	}

	public String getDocsMontosAcumuladosTotales() {
		return docsMontosAcumuladosTotales;
	}

	public void setDocsMontosAcumuladosTotales(String docsMontosAcumuladosTotales) {
		this.docsMontosAcumuladosTotales = docsMontosAcumuladosTotales;
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

	public String getVencimientoUltimoProtesto() {
		return vencimientoUltimoProtesto;
	}

	public void setVencimientoUltimoProtesto(String vencimientoUltimoProtesto) {
		this.vencimientoUltimoProtesto = vencimientoUltimoProtesto;
	}

	public String getMontoUltimoPago() {
		return montoUltimoPago;
	}

	public void setMontoUltimoPago(String montoUltimoPago) {
		this.montoUltimoPago = montoUltimoPago;
	}

	public void fillParams(Map<String, Object> params) {

		params.put("docsPeriodoUltimosSeis", docsPeriodoUltimosSeis);
		params.put("docsPeriodoSeisDoce", docsPeriodoSeisDoce);
		params.put("docsPeriodoDoce24", docsPeriodoDoce24);
		params.put("docsPeriodoMas24", docsPeriodoMas24);
		params.put("docsPeriodoTotales", docsPeriodoTotales);

		params.put("docsAcumuladosUltimosSeis", docsAcumuladosUltimosSeis);
		params.put("docsAcumuladosSeisDoce", docsAcumuladosSeisDoce);
		params.put("docsAcumuladosDoce24", docsAcumuladosDoce24);
		params.put("docsAcumuladosMas24", docsAcumuladosMas24);
		params.put("docsAcumuladosTotales", docsAcumuladosTotales);

		params.put("docsMontosPeriodoUltimosSeis", docsMontosPeriodoUltimosSeis);
		params.put("docsMontosPeriodoSeisDoce", docsMontosPeriodoSeisDoce);
		params.put("docsMontosPeriodoDoce24", docsMontosPeriodoDoce24);
		params.put("docsMontosPeriodoMas24", docsMontosPeriodoMas24);
		params.put("docsMontosPeriodoTotales", docsMontosPeriodoTotales);

		params.put("docsMontosAcumuladosUltimosSeis", docsMontosAcumuladosUltimosSeis);
		params.put("docsMontosAcumuladosSeisDoce", docsMontosAcumuladosSeisDoce);
		params.put("docsMontosAcumuladosDoce24", docsMontosAcumuladosDoce24);
		params.put("docsMontosAcumuladosMas24", docsMontosAcumuladosMas24);
		params.put("docsMontosAcumuladosTotales", docsMontosAcumuladosTotales);

		params.put("morosidadesTotalImpagos", totalImpagos);
		params.put("morosidadesMontoTotalImpagos", montoTotalImpagos);
		params.put("morosidadesVencimientoUltimoProtesto", vencimientoUltimoProtesto);
		params.put("morosidadesMontoUltimoPago", montoUltimoPago);

	}

}
