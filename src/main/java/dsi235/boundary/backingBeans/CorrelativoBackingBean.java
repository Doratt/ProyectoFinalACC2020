package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.boundary.backingBeans.utils.CategoriaConverter;
import dsi235.boundary.backingBeans.utils.MarcaCoverter;
import dsi235.controllers.CategoryController;
import dsi235.controllers.CorrelativoController;
import dsi235.controllers.MarcaController;
import dsi235.entities.Categoria;
import dsi235.entities.Correlativo;
import dsi235.entities.Marca;
import dsi235.utilities.PageParser;

@ManagedBean(value = "correlativo")
@SessionScope
public class CorrelativoBackingBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate ingreso;
	private LazyDataModel<Correlativo> model;
	private Correlativo correlativo;
	private CorrelativoController controller;
	private MarcaController marcaController;
	private CategoryController categoryController;
	private List<Marca> marcas;
	private List<Categoria> categorias;
	private Marca marcaSeleccionada;
	private boolean assurance;

	public CorrelativoBackingBean(CorrelativoController controller, MarcaController marcaController,
			CategoryController cat) {
		super();
		this.controller = controller;
		this.marcaController = marcaController;
		this.categoryController = cat;
		this.categorias = this.categoryController.findAll();
		this.marcas = this.marcaController.findAll();
		CategoriaConverter.list = this.categorias;
		MarcaCoverter.list = this.marcas;
	}

	public void clean() {
//		this.correlativo = null;
		System.out.println("CLEAN TRIGGERED");
	}

	public void nuevo(ActionEvent ev) {
		this.correlativo = new Correlativo();
	}

	public void edit(ActionEvent evt) {
		tieneGarantia();
		if (this.controller.save(this.correlativo) != null)
			message(FacesMessage.SEVERITY_INFO, "Exito", "Elemento editado");
	}

	private void tieneGarantia() {
		if (!this.correlativo.getGarantia()) {
			this.correlativo.setDescripcionGarantia("---");
		}
	}

	public void save(ActionEvent evt) {
		tieneGarantia();
		this.controller.findById(this.correlativo.getCorrelativo()).ifPresentOrElse(
				corr -> message(FacesMessage.SEVERITY_ERROR, "Error!", "Ya existe/Already exists"), () -> {
					this.controller.save(this.correlativo);
					message(FacesMessage.SEVERITY_INFO, "Exito", "Elemento creado");
				});
	}

	private void message(Severity type, String header, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(type, header, message));
	}

	public void print() {
		System.out.println("GARANTIA EN PRINT ES: " + this.correlativo.getGarantia());
	}

	public void select(SelectEvent evt) {
		this.correlativo = (Correlativo) evt.getObject();
	}

	@PostConstruct
	public void init() {
		iniciar();
	}

	public void delete(Correlativo correlativo) {

		if (correlativo != null) {
			this.controller.deleteById(correlativo.getCorrelativo());
			message(FacesMessage.SEVERITY_INFO, "Exito", "Elemento eliminado");
		}
	}

	public void iniciar() {
		try {
			model = new LazyDataModel<Correlativo>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Correlativo getRowData(String rowKey) {
					return obtenerRowData(rowKey);
				}

				@Override
				public Object getRowKey(Correlativo object) {
					return obtenerRowKey(object);
				}

				@Override
				public List<Correlativo> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					return cargarDatos(first, pageSize, sortField, sortOrder, filters);
				}

			};
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private Correlativo obtenerRowData(String rowKey) {
		try {
			List<Correlativo> registros = (List<Correlativo>) this.model.getWrappedData();
			if (registros != null && !registros.isEmpty()) {
				Long buscado = Long.parseLong(rowKey);
				for (Correlativo r : registros) {
					if (r.getCorrelativo().compareTo(buscado) == 0) {
						return r;
					}
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
		return null;
	}

	private Object obtenerRowKey(Correlativo object) {
		if (object != null) {
			return object.getCorrelativo();
		}
		return null;
	}

	private List<Correlativo> cargarDatos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Correlativo> salida = null;
		Page<Correlativo> page = null;
		try {
			if (this.controller != null) {
				page = this.controller.findRange(PageRequest.of(PageParser.parsePage(first, pageSize), pageSize));

				salida = page.getContent();
				if (this.model != null) {
					this.model.setRowCount((Integer.valueOf(String.valueOf(page.getTotalElements()))));

				}
			}
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			if (salida == null) {
				salida = Collections.emptyList();
			}
		}
		return salida;
	}

	/**
	 * @return the ingreso
	 */
	public LocalDate getIngreso() {
		return ingreso;
	}

	/**
	 * @param ingreso the ingreso to set
	 */
	public void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}

	/**
	 * @return the model
	 */
	public LazyDataModel<Correlativo> getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(LazyDataModel<Correlativo> model) {
		this.model = model;
	}

	/**
	 * @return the correlativo
	 */
	public Correlativo getCorrelativo() {
		return correlativo;
	}

	/**
	 * @param correlativo the correlativo to set
	 */
	public void setCorrelativo(Correlativo correlativo) {
		this.correlativo = correlativo;
	}

	/**
	 * @return the marcas
	 */
	public List<Marca> getMarcas() {
		return marcas;
	}

	/**
	 * @param marcas the marcas to set
	 */
	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	/**
	 * @return the marcaSeleccionada
	 */
	public Marca getMarcaSeleccionada() {
		return marcaSeleccionada;
	}

	/**
	 * @param marcaSeleccionada the marcaSeleccionada to set
	 */
	public void setMarcaSeleccionada(Marca marcaSeleccionada) {
		this.marcaSeleccionada = marcaSeleccionada;
	}

	/**
	 * @return the assurance
	 */
	public boolean isAssurance() {
		return assurance;
	}

	/**
	 * @param assurance the assurance to set
	 */
	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}

	/**
	 * @return the categorias
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
