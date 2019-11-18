package dsi235.rest;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.export.XlsxExporterConfiguration;
import net.sf.jasperreports.export.XlsxReportConfiguration;

@RestController
public class ReportesController {

	@Autowired
	DataSource dataSource;

	@Autowired
	private ResourceLoader resourceLoader;

	@RequestMapping(value = "/reportes")
	public void getReporte(HttpServletResponse response, @RequestParam @Nullable Long id, @RequestParam String nombre,
			@Nullable @RequestParam String fechaInicio, @Nullable @RequestParam String fechaFin) {

		System.out.println("En /reportes");

		String formato = "pdf";

		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"reporte.pdf\""));

		try {
			OutputStream out = response.getOutputStream();

			String path = resourceLoader.getResource("classpath:" + nombre + ".jasper").getURI().getPath();
			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);

			// Parameters for report
			Map<String, Object> parameters = new HashMap<String, Object>();

			if (nombre.equals("historialPorCorrelativo")) {
				parameters.put("id", id);
			}
			if(nombre.equals("costos")) {
				Timestamp fechaInicioDate = new Timestamp(Long.parseLong(fechaInicio));
				Timestamp fechaFinDate = new Timestamp(Long.parseLong(fechaFin));
				
				System.out.println(fechaInicioDate);
				System.out.println(fechaFinDate);
				
				parameters.put("FECHA_INICIO", fechaInicioDate);
				parameters.put("FECHA_FIN", fechaFinDate);
			}

			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());

			switch (formato) {
			case "pdf":
				JasperExportManager.exportReportToPdfStream(print, out);
				break;
			case "xlsx":
				SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
				configuration.setOnePagePerSheet(false);
				configuration.setIgnoreGraphics(false);
				configuration.setIgnorePageMargins(true);
				configuration.setRemoveEmptySpaceBetweenRows(true);

				// File outputFile = new File("output.xlsx");
				try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();) {
					Exporter<ExporterInput, XlsxReportConfiguration, XlsxExporterConfiguration, OutputStreamExporterOutput> exporter = new JRXlsxExporter();
					exporter.setExporterInput(new SimpleExporterInput(print));
					exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
					exporter.setConfiguration(configuration);
					exporter.exportReport();
					byteArrayOutputStream.writeTo(out);
				} catch (Exception e) {
					e.printStackTrace();
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error");
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + formato);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error");
		}

	}
}
