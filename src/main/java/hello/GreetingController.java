package hello;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.equifax.ncr.pdf.PlatinumFill;
import com.equifax.ncr.pdf.PlatinumPdf;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.PdfExporterConfiguration;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/pdf")
	public void newPdf(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {

		JasperPrint jasperPrint = this.generatePdf("factura-proforma.jasper", false, null);

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	@RequestMapping("/newpdf")
	public void new2Pdf(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {

		JasperPrint jasperPrint = this.generatePdf("factura-proforma.jasper", false, null);

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	@RequestMapping("/proforma")
	public void proforma(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {
		JasperReport report = this.getJasperReport("proforma-detalle.jasper");
		JasperReport subReport = this.getJasperReport("proforma-detalle-productos.jasper");

		JasperPrint jasperPrint = JasperFillManager.fillReport(report,
				populateProforma(subReport, populateProductDetails(), null, null), new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=proforma-detalle.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	@RequestMapping("/proformaDetalle")
	public void proformaDetalle(HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException {
		JasperReport subReport = this.getJasperReport("proforma-detalle-productos-2.jasper");

		JasperPrint jasperPrint = JasperFillManager.fillReport(subReport, populate(),
				new JRBeanCollectionDataSource(this.populateProductDetails()));

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=proforma-detalle.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	@RequestMapping("/proformaReferencia")
	public void proformaReferencia(HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException {
		JasperReport report = this.getJasperReport("proforma-detalle.jasper");
		JasperReport subReport = this.getJasperReport("proforma-detalle-productos.jasper");
		JasperReport referenciaReport = this.getJasperReport("proforma-detalle-referencia.jasper");

		JasperPrint jasperPrint = JasperFillManager.fillReport(report, populateProforma(subReport,
				populateProductDetails(), referenciaReport, this.populateReferenceDetails()), new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=proforma-detalle.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	@RequestMapping("/passwordPdf")
	public void passPdf(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {

		JasperPrint jasperPrint = this.generatePdf("factura-proforma.jasper", true, "1234");

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	private JasperReport getJasperReport(String jasperResourceFile) throws JRException, IOException {

		Resource rsrc = new ClassPathResource(jasperResourceFile);

		JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(rsrc.getFile().getAbsolutePath());

		return jasperReport;

	}

	private JasperPrint generatePdf(String jasperResourceFile, boolean isEncrypted, String password)
			throws JRException, IOException {

		JasperReport jasperReport = this.getJasperReport(jasperResourceFile);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, populate(),
				new JRBeanCollectionDataSource(populateDetails()));

		if (isEncrypted) {

			jasperPrint.setProperty(PdfExporterConfiguration.PROPERTY_ENCRYPTED, "true");
			jasperPrint.setProperty(PdfExporterConfiguration.PROPERTY_USER_PASSWORD, password);
			jasperPrint.setProperty(PdfExporterConfiguration.PROPERTY_OWNER_PASSWORD, password);

		}

		return jasperPrint;
	}

	private Map<String, Object> populate() {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("numeroFactura", "N° " + "1003465");

		params.put("fecha", "31 de Diciembre de 2015");

		params.put("razonSocial", "RIPLEY STORE LIMITADA");

		params.put("rut", "76.879.810-9");

		params.put("domicilio", "HUERFANOS 1052 PISO 4");

		params.put("ciudad", "SANTIAGO");

		params.put("telefono", "6941123");

		params.put("giroNegocios", "GRANDES TIENDAS");

		params.put("nota1", "UN COMENTARIO CUALQUIERA AL RESPECTO");

		params.put("nota2", "OTRO COMENTARIO CUALQUIERA");

		params.put("codigoCliente", "079979");

		params.put("comuna", "SANTIAGO");

		params.put("subTotal", "31.081");

		params.put("subTotalDescuento", "0");

		params.put("montoNeto", "31.081");

		params.put("iva", "5.905");

		params.put("montoTotal", "36.986");

		return params;

	}

	private List<Detail> populateDetails() {

		List<Detail> list = new ArrayList<Detail>();

		for (int i = 1; i < 26; i++) {

			Detail d1 = new Detail();
			d1.setCantidad(String.valueOf(i));
			d1.setDescripcion("REGISTRO DE DOMICILIO");
			d1.setPrecioUnitario("171,710");
			d1.setTotal("1.717");

			list.add(d1);

		}

		return list;

	}

	private List<ProductoDetalle> populateProductDetails() {

		List<ProductoDetalle> list = new ArrayList<ProductoDetalle>();

		for (int i = 1; i < 10; i++) {

			ProductoDetalle d1 = new ProductoDetalle();
			d1.setProducto("REGISTRO DE DOMICILIO");
			d1.setCantidad(String.valueOf(i));

			d1.setPrecioUnitario("171,710");
			d1.setPrecioTotal("1.717");
			d1.setObservacion("UNA OBSERVACION CUALQUIERA PERO CON HARTAS PALABRAS");

			list.add(d1);

		}

		return list;

	}

	private List<ReferenciaDetalle> populateReferenceDetails() {

		List<ReferenciaDetalle> list = new ArrayList<ReferenciaDetalle>();

		for (int i = 1; i < 10; i++) {

			ReferenciaDetalle d1 = new ReferenciaDetalle();

			d1.setDocumentoReferencia(String.valueOf(i * 27));
			d1.setFecha("12-12-2015");
			d1.setTipoDocumento("ORDEN DE COMPRA");

			list.add(d1);

		}

		return list;

	}

	private Map<String, Object> populateProforma(JasperReport productsSubreport, List<ProductoDetalle> productsList,
			JasperReport referenceSubreport, List<ReferenciaDetalle> referenceList) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("rutCliente", "76.879.810-9");
		params.put("fechaIncorporacion", "10-10-2015");
		params.put("codigoCliente", "1003465");
		params.put("fechaTermino", "10-10-2016");
		params.put("razonSocial", "RIPLEY STORE LIMITADA");
		params.put("emailCliente", "admin@ripley.cl");
		params.put("nombreEjecutivo", "Juan Pérez");
		params.put("emailEjecutivo", "juan.perez@gmail.com");
		params.put("nombreAsistente", "Juan Pérez");
		params.put("emailAsistente", "juan.perez@gmail.com");
		params.put("nombreManager", "Juan Pérez");
		params.put("emailManager", "juan.perez@gmail.com");
		params.put("numeroProforma", "6941123");
		params.put("fechaProforma", "10-12-2016");
		params.put("numeroFolio", "1003456");
		params.put("fechaEmision", "11-12-2016");
		params.put("montoNeto", "100.000");
		params.put("montoIva", "19.000");
		params.put("montoTotal", "119.000");
		params.put("nota1", "Un comentario cualquiera");
		params.put("nota2", "Otro comentario");

		params.put("productsSubreport", productsSubreport);

		params.put("productsList", new JRBeanCollectionDataSource(productsList));

		if (referenceSubreport != null) {
			params.put("showReferencia", Boolean.TRUE);
			params.put("referenceSubreport", referenceSubreport);
			params.put("referenceList", new JRBeanCollectionDataSource(referenceList));

		} else {
			params.put("showReferencia", Boolean.FALSE);
		}

		return params;

	}

	@RequestMapping("/platinum")
	public void platinum(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {
		JasperReport platinum = this.getJasperReport("efxncr.jasper");
		JasperReport resumen = this.getJasperReport("efxncr-resumen-1.jasper");
		JasperReport identificacion = this.getJasperReport("efxncr-identificacion.jasper");
		JasperReport comportamiento = this.getJasperReport("efxncr-comportamiento.jasper");
		JasperReport antecedentes = this.getJasperReport("efxncr-antecedentes-laborales.jasper");
		JasperReport acreditaciones = this.getJasperReport("efxncr-acreditaciones.jasper");
		JasperReport identificacionId = this.getJasperReport("efxncr-identificacion-id.jasper");
		JasperReport identificacionFamilia = this.getJasperReport("efxncr-identificacion-familia.jasper");
		JasperReport identificacionContactabilidad = this
				.getJasperReport("efxncr-identificacion-contactabilidad.jasper");

		JasperReport identificacionDiscrepancias = this.getJasperReport("efxncr-identificacion-discrepancias.jasper");

		JasperReport informacionBancaria = this.getJasperReport("efxncr-informacion-bancaria.jasper");
		JasperReport cuentaCorrients = this.getJasperReport("efxncr-cuenta-corriente.jasper");

		JasperReport ordenesNoPago = this.getJasperReport("efxncr-ordenes-no-pago.jasper");
		JasperReport vehiculosPropiedades = this.getJasperReport("efxncr-vehiculos-propiedades.jasper");
		JasperReport acreditacionesPersonales = this.getJasperReport("efxncr-acreditaciones-personales.jasper");
		JasperReport informacionTributaria = this.getJasperReport("efxncr-informacion-tributaria.jasper");

		JasperPrint jasperPrint = JasperFillManager.fillReport(platinum,
				this.populatePlatinum(resumen, identificacion, comportamiento, antecedentes, acreditaciones,
						identificacionId, identificacionFamilia, identificacionContactabilidad,
						identificacionDiscrepancias, informacionBancaria, cuentaCorrients, ordenesNoPago,
						vehiculosPropiedades, acreditacionesPersonales, informacionTributaria),
				new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=ncr.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	private Map<String, Object> populatePlatinum(JasperReport resumen, JasperReport identificacion,
			JasperReport comportamiento, JasperReport antecedentes, JasperReport acreditaciones,
			JasperReport identificacionId, JasperReport identificacionFamilia,
			JasperReport identificacionContactabilidad, JasperReport identificacionDiscrepancias,
			JasperReport informacionBancaria, JasperReport cuentaCorrients, JasperReport ordenesNoPago,
			JasperReport vehiculosPropiedades, JasperReport acreditacionesPersonales, JasperReport informacionTributaria

	) {

		Map<String, Object> params = new HashMap<String, Object>();

		List<ProductoDetalle> list = new ArrayList<ProductoDetalle>();
		list.add(new ProductoDetalle());

		params.put("resumenSubreport", resumen);
		params.put("resumenList", new JRBeanCollectionDataSource(new ArrayList<ProductoDetalle>()));
		params.put("identificacionSubreport", identificacion);
		params.put("identificacionList", new JRBeanCollectionDataSource(list));

		params.put("comportamientoSubreport", comportamiento);
		params.put("comportamientoList", new JRBeanCollectionDataSource(new ArrayList<ProductoDetalle>()));
		params.put("antecedentesSubreport", antecedentes);
		params.put("antecedentesList", new JRBeanCollectionDataSource(new ArrayList<ProductoDetalle>()));
		params.put("acreditacionesSubreport", acreditaciones);
		params.put("acreditacionesList", new JRBeanCollectionDataSource(list));

		params.put("identificacionIdSubreport", identificacionId);
		params.put("identificacionIdList", new JRBeanCollectionDataSource(list));

		params.put("identificacionFamiliaSubreport", identificacionFamilia);
		params.put("identificacionFamiliaList", new JRBeanCollectionDataSource(list));

		params.put("identificacionContactabilidadSubreport", identificacionContactabilidad);
		params.put("identificacionContactabilidadList", new JRBeanCollectionDataSource(list));

		params.put("identificacionDiscrepanciasSubreport", identificacionDiscrepancias);
		params.put("identificacionDiscrepanciasList", new JRBeanCollectionDataSource(list));

		params.put("informacionBancariaSubreport", informacionBancaria);
		params.put("informacionBancariaList", new JRBeanCollectionDataSource(new ArrayList<ProductoDetalle>()));

		params.put("cuentaCorrienteSubreport", cuentaCorrients);
		params.put("cuentaCorrienteList", new JRBeanCollectionDataSource(list));

		params.put("ordenesNoPagoSubreport", ordenesNoPago);
		params.put("ordenesNoPagoList", new JRBeanCollectionDataSource(list));

		params.put("vehiculosPropiedadesSubreport", vehiculosPropiedades);
		params.put("vehiculosPropiedadesList", new JRBeanCollectionDataSource(list));

		params.put("acreditacionesPersonalesSubreport", acreditacionesPersonales);
		params.put("acreditacionesPersonalesList", new JRBeanCollectionDataSource(list));

		params.put("informacionTributariaSubreport", informacionTributaria);
		params.put("informacionTributariaList", new JRBeanCollectionDataSource(list));

		return params;

	}

	@RequestMapping("/identificacion")
	public void identificacion(HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException {

		JasperReport identificacion = this.getJasperReport("efxncr-identificacion.jasper");
		JasperReport identificacionId = this.getJasperReport("efxncr-identificacion-id.jasper");
		JasperReport identificacionFamilia = this.getJasperReport("efxncr-identificacion-familia.jasper");
		JasperReport identificacionContactabilidad = this
				.getJasperReport("efxncr-identificacion-contactabilidad.jasper");
		JasperReport identificacionDiscrepancias = this.getJasperReport("efxncr-identificacion-discrepancias.jasper");

		JasperPrint jasperPrint = JasperFillManager
				.fillReport(
						identificacion, this.populateIdentificacion(identificacion, identificacionId,
								identificacionFamilia, identificacionContactabilidad, identificacionDiscrepancias),
						new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=ncr.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	private Map<String, Object> populateIdentificacion(JasperReport identificacion, JasperReport identificacionId,
			JasperReport identificacionFamilia, JasperReport identificacionContactabilidad,
			JasperReport identificacionDiscrepancias) {

		Map<String, Object> params = new HashMap<String, Object>();

		List<ProductoDetalle> list = new ArrayList<ProductoDetalle>();
		list.add(new ProductoDetalle());

		params.put("identificacionSubreport", identificacion);
		params.put("identificacionList", new JRBeanCollectionDataSource(new ArrayList<ProductoDetalle>()));

		params.put("identificacionIdSubreport", identificacionId);
		params.put("identificacionIdList", new JRBeanCollectionDataSource(list));

		params.put("identificacionFamiliaSubreport", identificacionFamilia);
		params.put("identificacionFamiliaList", new JRBeanCollectionDataSource(list));

		params.put("identificacionContactabilidadSubreport", identificacionContactabilidad);
		params.put("identificacionContactabilidadList", new JRBeanCollectionDataSource(list));

		params.put("identificacionDiscrepanciasSubreport", identificacionDiscrepancias);
		params.put("identificacionDiscrepanciasList", new JRBeanCollectionDataSource(list));

		return params;

	}

	@RequestMapping("/identificacionId")
	public void identificacionId(HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException {

		JasperReport identificacionId = this.getJasperReport("efxncr-identificacion-id.jasper");

		JasperPrint jasperPrint = JasperFillManager.fillReport(identificacionId,
				this.populateIdentificacionId(identificacionId), new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=ncr.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	private Map<String, Object> populateIdentificacionId(JasperReport identificacionId) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("identificacionIdSubreport", identificacionId);
		params.put("identificacionIdList", new JRBeanCollectionDataSource(new ArrayList<ProductoDetalle>()));

		return params;

	}

	@RequestMapping("/acreditaciones")
	public void acreditaciones(HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException {

		Map<String, Object> params = new HashMap<String, Object>();

		this.addAcreditaciones(params);

		JasperPrint jasperPrint = JasperFillManager.fillReport(this.getJasperReport("efxncr-acreditaciones.jasper"),
				params, new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=ncr.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	private void addBasicInfo(Map<String, Object> params) throws JRException, IOException {

		params.put("nombreCompleto", "ARAVENA ESTAY CAROLINA DEL PILARIO");
		params.put("rut", "16.480.990-9");
		params.put("edad", "30");
		params.put("fechaInforme", "22-05-2016");
		params.put("horaInforme", "16:18");
		params.put("numeroCertificado", "7d65cd7887ade78adasd78addsad7865");

	}

	private void addResumen(Map<String, Object> params) throws JRException, IOException {

		params.put("resumenList", new JRBeanCollectionDataSource(new ArrayList<ProductoDetalle>()));

		params.put("totalImpagos", "13");
		params.put("acreditacionesFinancieras", "Sí");
		params.put("creditoVigente", "12.100");
		params.put("indicadorRiesgo", "799");
		params.put("puntajeCalculado", "11-12-2006");

	}

	private void addResumen2(Map<String, Object> params) throws JRException, IOException {

		params.put("resumenList", new JRBeanCollectionDataSource(new ArrayList<ProductoDetalle>()));

		params.put("totalImpagos", "13");
		params.put("acreditacionesFinancieras", "Sí");
		params.put("creditoVigente", "12.100");
		params.put("indicadorRiesgo", "799");
		params.put("puntajeCalculado", "11-12-2006");

	}

	private void addIdentificacionId(Map<String, Object> params) {

		params.put("fechaNacimiento", "12 Enero 1976");
		params.put("nacionalidad", "Chilena");
		params.put("tipoNacionalidad", "Chilena");
		params.put("sexo", "Femenino");
		params.put("indicadorPersonaDifunta", "No");
		params.put("fechaDefuncion", "No");
		params.put("indicadorInterdicto", "No");
		params.put("fechaInterdicto", "No");
		params.put("indicadorVerificadorIdentidad", "Sí");
		params.put("estadoCivil", "Casada");
		params.put("rutConyuge", "12.123.456-7");

	}

	// private void addIdentificacionFamilia(Map<String, Object> params) {
	//
	// params.put("fechaUltimoMatrimonio", "31-12-2007");
	//
	// }

	private void addIdentificacion(Map<String, Object> params) throws JRException, IOException {

		List<ProductoDetalle> list = new ArrayList<ProductoDetalle>();
		list.add(new ProductoDetalle());

		Discrepancia discrepancia = new Discrepancia();
		discrepancia.setNumero("1");
		discrepancia.setFecha("07-07-2011");
		discrepancia.setSeccion("Identificación");
		discrepancia.setCampo("Fecha de Nacimiento");
		discrepancia.setMotivo(
				"La fecha de nacimiento que aparece contiene un error, aparece que nací en 1975 cuando en realidad nací en 1976.");

		List<Discrepancia> listDiscrepancia = new ArrayList<Discrepancia>();
		listDiscrepancia.add(discrepancia);

		Discrepancia d2 = new Discrepancia();
		d2.setNumero("2");
		d2.setFecha("25-07-2013");
		d2.setSeccion("Detalle de Protestos y Morosidades");
		d2.setCampo("Monto");
		d2.setMotivo(
				"El pagaré publicado por el Banco A no corresponde, pues presenta un monto de $ 89.560 cuando en realidad es de $ 45.200.");

		listDiscrepancia.add(d2);
		// params.put("identificacionSubreport",
		// this.getJasperReport("efxncr-identificacion.jasper"));
		params.put("identificacionList", new JRBeanCollectionDataSource(list));

		// params.put("identificacionIdSubreport",
		// this.getJasperReport("efxncr-identificacion-id.jasper"));
		params.put("identificacionIdList", new JRBeanCollectionDataSource(list));

		// params.put("identificacionFamiliaSubreport",
		// this.getJasperReport("efxncr-identificacion-familia.jasper"));
		// params.put("identificacionFamiliaList", new
		// JRBeanCollectionDataSource(list));

		// params.put("identificacionContactabilidadSubreport",
		// this.getJasperReport("efxncr-identificacion-contactabilidad.jasper"));
		params.put("identificacionContactabilidadList", new JRBeanCollectionDataSource(list));

		// params.put("identificacionDiscrepanciasSubreport",
		// this.getJasperReport("efxncr-identificacion-discrepancias.jasper"));
		params.put("identificacionDiscrepanciasList", new JRBeanCollectionDataSource(listDiscrepancia));

		this.addIdentificacionId(params);
		// this.addIdentificacionFamilia(params);

	}

	private void addAcreditacionesPersonales(Map<String, Object> params) {

		params.put("numeroVehiculos", "3");
		params.put("vehiculosMontoTotalAvaluo", "24.000.000");
		params.put("numeroPropiedades", "2");
		params.put("propiedadesMontoTotalAvaluo", "100.000.000");
		params.put("socioeconomico", "3");
		params.put("ise", "3");
		params.put("sociedades", "1");
		params.put("relacionesComoSocio", "1");
		params.put("comercioExterior", "Sí");
		params.put("ultimaExportacion", "24-04-2015");
		params.put("montoUltimaExportacion", "250.000.000");
		params.put("ordenesNoPago", "3");

	}

	private void addCuentaCorriente(Map<String, Object> params) {

		params.put("estadoCuentaCorriente", "Cuenta Corriente Bloqueada");

		List<CuentaCorrienteBloqueada> list = new ArrayList<CuentaCorrienteBloqueada>();

		CuentaCorrienteBloqueada c1 = new CuentaCorrienteBloqueada();

		c1.setNumeroCuenta("10923461914");
		c1.setBanco("BCI");

		list.add(c1);

		CuentaCorrienteBloqueada c2 = new CuentaCorrienteBloqueada();

		c2.setNumeroCuenta("10923461914");
		c2.setBanco("Banco de Chile");
		list.add(c2);

		params.put("cuentaCorrienteList", new JRBeanCollectionDataSource(list));

	}

	private void addOrdenesNoPago(Map<String, Object> params) {

		List<DetalleOrdenNoPago> list = new ArrayList<DetalleOrdenNoPago>();

		DetalleOrdenNoPago o1 = new DetalleOrdenNoPago();

		o1.setBanco("BCI");
		o1.setCuentaCorriente("12334556");
		o1.setFecha("10-03-2013");
		o1.setFuente("Titular");
		o1.setMotivo("Extravío");
		o1.setRangoCheque("12536/12539");
		o1.setSucursal("Santiago");

		list.add(o1);

		params.put("ordenesNoPagoList", new JRBeanCollectionDataSource(list));

	}

	private void addInformacionTributaria(Map<String, Object> params) {

		List<InfraccionTributaria> list = new ArrayList<InfraccionTributaria>();

		InfraccionTributaria i1 = new InfraccionTributaria();

		i1.setDetalle("Infracciones Tributaria 1");
		i1.setFecha("02-12-2007");
		i1.setAnotacion("Una anotacion");

		list.add(i1);

		params.put("informacionTributariaList", new JRBeanCollectionDataSource(list));

	}

	private void addAcreditaciones(Map<String, Object> params) throws JRException, IOException {

		List<ProductoDetalle> list = new ArrayList<ProductoDetalle>();
		list.add(new ProductoDetalle());

		// params.put("acreditacionesSubreport",
		// this.getJasperReport("efxncr-acreditaciones.jasper"));
		params.put("acreditacionesList", new JRBeanCollectionDataSource(list));

		params.put("informacionBancariaSubreport", this.getJasperReport("efxncr-informacion-bancaria.jasper"));
		params.put("informacionBancariaList", new JRBeanCollectionDataSource(list));

		params.put("cuentaCorrienteSubreport", this.getJasperReport("efxncr-cuenta-corriente.jasper"));
		// params.put("cuentaCorrienteList", new
		// JRBeanCollectionDataSource(list));

		params.put("ordenesNoPagoSubreport", this.getJasperReport("efxncr-ordenes-no-pago.jasper"));

		params.put("vehiculosPropiedadesSubreport", this.getJasperReport("efxncr-vehiculos-propiedades.jasper"));
		params.put("vehiculosPropiedadesList", new JRBeanCollectionDataSource(list));

		params.put("acreditacionesPersonalesSubreport",
				this.getJasperReport("efxncr-acreditaciones-personales.jasper"));
		params.put("acreditacionesPersonalesList", new JRBeanCollectionDataSource(list));

		params.put("informacionTributariaSubreport", this.getJasperReport("efxncr-informacion-tributaria.jasper"));

		this.addAcreditacionesPersonales(params);
		this.addCuentaCorriente(params);
		this.addOrdenesNoPago(params);
		this.addInformacionTributaria(params);

	}

	private void addConsultasRut(Map<String, Object> params) {

		List<ConsultaRut> list = new ArrayList<ConsultaRut>();

		ConsultaRut c1 = new ConsultaRut();

		c1.setFecha("01-01-2016");
		c1.setEmpresa("Duke Energy");
		c1.setInforme("SCORE");

		list.add(c1);

		ConsultaRut c2 = new ConsultaRut();

		c2.setFecha("15-01-2016");
		c2.setEmpresa("Duke Energy");
		c2.setInforme("SCORE");

		list.add(c2);

		params.put("consultasRutList", new JRBeanCollectionDataSource(list));

	}

	private void addResumenMorosidades(Map<String, Object> params) {

		ResumenMorosidades resumen = new ResumenMorosidades();
		resumen.setTotalImpagos("14");
		resumen.setMontoTotalImpagos("12.504");
		resumen.setVencimientoUltimoProtesto("15-12-2015");
		resumen.setMontoUltimoPago("12.504.203");
		resumen.setDocsAcumuladosUltimosSeis("6");
		resumen.setDocsAcumuladosTotales("6");

		resumen.fillParams(params);

	}

	private void addMorosidades(Map<String, Object> params) throws JRException, IOException {

		params.put("morosidadSubreport", this.getJasperReport("efxncr-morosidades.jasper"));

		// morosidadList

		List<DetalleMorosidad> list = new ArrayList<DetalleMorosidad>();

		DetalleMorosidad d1 = new DetalleMorosidad();

		d1.setFechaVencimiento("01-09-2015");
		d1.setTipoDocumento("LT");
		d1.setMonto("258.213");
		d1.setLibrador("Forum Servicios Libradores S.");
		d1.setLocalidad("Concepción");
		d1.setTipoDeuda("Morosidad");

		list.add(d1);

		DetalleMorosidad d2 = new DetalleMorosidad();

		d2.setFechaVencimiento("01-10-2015");
		d2.setTipoDocumento("LT");
		d2.setMonto("360.100");
		d2.setLibrador("Forum Servicios Libradores S.");
		d2.setLocalidad("Concepción");
		d2.setTipoDeuda("Morosidad");

		list.add(d2);

		params.put("morosidadList", new JRBeanCollectionDataSource(list));
		params.put("morosidadTotalImpagos", "5");
		params.put("morosidadMontoTotalImpagos", "M$ 2.518");

	}

	private void addBoletin(Map<String, Object> params) throws JRException, IOException {

		params.put("boletinSubreport", this.getJasperReport("efxncr-boletin-comercial.jasper"));

		// morosidadList

		List<DetalleBoletinLaboral> list = new ArrayList<DetalleBoletinLaboral>();

		DetalleBoletinLaboral d1 = new DetalleBoletinLaboral();

		d1.setMotivo("Declaraciones sin pago");
		d1.setInstitucion("AFP Cuprum");
		d1.setBoletin("156");
		d1.setPagina("34");
		d1.setFecha("10-12-2016");
		d1.setTipoInfraccion("Infracción Prev");
		d1.setMonto("$258.000");

		list.add(d1);

		DetalleBoletinLaboral d2 = new DetalleBoletinLaboral();

		d2.setMotivo("Declaraciones sin pago");
		d2.setInstitucion("AFP Cuprum");
		d2.setBoletin("156");
		d2.setPagina("34");
		d2.setFecha("05-08-2016");
		d2.setTipoInfraccion("Infracción Prev");
		d2.setMonto("$370.000");

		list.add(d1);

		params.put("boletinList", new JRBeanCollectionDataSource(list));
		params.put("laboralTotalImpagos", "2");
		params.put("laboralMontoTotalImpagos", "M$ 603");

	}

	private void addComportamiento(Map<String, Object> params) throws JRException, IOException {

		List<ProductoDetalle> list = new ArrayList<ProductoDetalle>();
		list.add(new ProductoDetalle());

		List<DetalleDeudaSistemaFinanciero> listDetalleSistemaFinanciero = getListDetalleSistemaFinanciero();

		// JasperReport comportamiento =
		// this.getJasperReport("efxncr-comportamiento.jasper");

		// params.put("comportamientoSubreport", comportamiento);
		params.put("comportamientoList", new JRBeanCollectionDataSource(list));

		params.put("indicadorRiesgoSubreport", this.getJasperReport("efxncr-indicador-riesgo.jasper"));
		params.put("indicadorRiesgoList", new JRBeanCollectionDataSource(list));

		params.put("resumenMorosidadesSubreport", this.getJasperReport("efxncr-resumen-morosidades.jasper"));
		params.put("resumenMorosidadesList", new JRBeanCollectionDataSource(list));

		params.put("indicadorPrevencionFraudeSubreport",
				this.getJasperReport("efxncr-indicadores-prevencion-fraude.jasper"));
		params.put("indicadorPrevencionFraudeList", new JRBeanCollectionDataSource(list));

		params.put("consultasRutSubreport", this.getJasperReport("efxncr-consultas-rut.jasper"));

		params.put("detalleProtestosSubreport", this.getJasperReport("efxncr-detalle-protestos.jasper"));
		params.put("detalleProtestosList", new JRBeanCollectionDataSource(list));

		params.put("deudaSistemaFinancieroSubreport", this.getJasperReport("efxncr-deuda-sistema-financiero.jasper"));
		params.put("deudaSistemaFinancieroList", new JRBeanCollectionDataSource(listDetalleSistemaFinanciero));

		this.addConsultasRut(params);
		this.addMorosidades(params);
		this.addResumenMorosidades(params);
		this.addBoletin(params);

	}

	private void addAntecedentesLaborales(Map<String, Object> params) throws JRException, IOException {

		// JasperReport antecedentes =
		// this.getJasperReport("efxncr-antecedentes-laborales.jasper");

		AntecedentesLaborales antecedentesLaborales = new AntecedentesLaborales();
		antecedentesLaborales.setProfesion("Ingeniero");
		antecedentesLaborales.setOficio("-");
		antecedentesLaborales.setDatosEmpresa(getAntecedentesDatosEmpresa());
		antecedentesLaborales.setDatosEmpresaHistoricos(getAntecedentesDatosEmpresaHistoricos());

		// params.put("antecedentesSubreport", antecedentes);
		params.put("antecedentesProfesion", antecedentesLaborales.getProfesion());
		params.put("antecedentesOficio", antecedentesLaborales.getOficio());
		params.put("antecedentesDatosEmpresa", antecedentesLaborales.getDatosEmpresa());
		params.put("antecedentesDatosEmpresaHistoricos",
				new JRBeanCollectionDataSource(antecedentesLaborales.getDatosEmpresaHistoricos()));

	}

	@RequestMapping("/platinum2")
	public void platinum2(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {
		JasperReport platinum = this.getJasperReport("efxncr.jasper");

		Map<String, Object> params = new HashMap<String, Object>();

		this.addBasicInfo(params);
		this.addResumen(params);
		this.addIdentificacion(params);
		this.addAcreditaciones(params);
		this.addComportamiento(params);
		this.addAntecedentesLaborales(params);

		JasperPrint jasperPrint = JasperFillManager.fillReport(platinum, params, new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=ncr2.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	@RequestMapping("/platinum3")
	public void platinum3(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {
		JasperReport platinum = this.getJasperReport("efxncr.jasper");
		PlatinumPdf pdf = PlatinumFill.fillPlatinum();

		Map<String, Object> params = pdf.getParams();

		JasperPrint jasperPrint = JasperFillManager.fillReport(platinum, params, new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=ncr2.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	@RequestMapping("/platinumCopia")
	public void platinumCopia(HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException {
		JasperReport platinum = this.getJasperReport("efxncr-copia.jasper");

		Map<String, Object> params = new HashMap<String, Object>();

		this.addBasicInfo(params);
		this.addResumen(params);
		this.addIdentificacion(params);
		this.addAcreditaciones(params);
		this.addComportamiento(params);
		this.addAntecedentesLaborales(params);

		JasperPrint jasperPrint = JasperFillManager.fillReport(platinum, params, new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=ncr-copia.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	@RequestMapping("/compra-online")
	public void compraOnline(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {
		JasperReport platinum = this.getJasperReport("efxncr-compra-online.jasper");

		Map<String, Object> params = new HashMap<String, Object>();

		this.addBasicInfo(params);
		this.addResumen2(params);
		this.addIdentificacion(params);
		this.addAcreditaciones(params);
		this.addComportamiento(params);
		this.addAntecedentesLaborales(params);

		JasperPrint jasperPrint = JasperFillManager.fillReport(platinum, params, new JREmptyDataSource());

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=ncr2.pdf");

		final OutputStream outStream = response.getOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

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

	private Map<String, String> getAntecedentesDatosEmpresa() {
		Map<String, String> datosEmpresa = new HashMap<String, String>();

		int number = 1000 + (int) (Math.random() * ((9999 - 1000) + 1));

		datosEmpresa.put("direccionLaboral", "El Salto " + number);
		datosEmpresa.put("comunaDireccionLaboral", "Huechuraba");
		datosEmpresa.put("ciudadDireccionLaboral", "Santiago");
		datosEmpresa.put("fechaVerificacionDatos", "16-05-2014");
		datosEmpresa.put("fechaActualizacion", "16-04-2014");
		datosEmpresa.put("fuenteVerificacion", "-");
		datosEmpresa.put("datosEmpresa", "-");
		return datosEmpresa;
	}

	private List<DatosEmpresa> getAntecedentesDatosEmpresaHistoricos() {

		List<DatosEmpresa> list = new ArrayList<DatosEmpresa>();
		DatosEmpresa datosEmpresa;

		for (int i = 0; i < 3; i++) {
			datosEmpresa = toDatosEmpresa(getAntecedentesDatosEmpresa());
			list.add(datosEmpresa);
		}
		return list;

	}

	private DatosEmpresa toDatosEmpresa(Map<String, String> datosEmpresaMap) {
		DatosEmpresa de = new DatosEmpresa();

		de.setDatosEmpresa(datosEmpresaMap.get("datosEmpresa"));
		de.setDireccionLaboral(datosEmpresaMap.get("direccionLaboral"));
		de.setComunaDireccionLaboral(datosEmpresaMap.get("comunaDireccionLaboral"));
		de.setCiudadDireccionLaboral(datosEmpresaMap.get("ciudadDireccionLaboral"));
		de.setFechaVerificacionDatos(datosEmpresaMap.get("fechaVerificacionDatos"));
		de.setFechaActualizacion(datosEmpresaMap.get("fechaActualizacion"));
		de.setFuenteVerificacion(datosEmpresaMap.get("fuenteVerificacion"));

		return de;

	}

}
