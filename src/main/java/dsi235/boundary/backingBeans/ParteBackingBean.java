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
import javax.faces.event.FacesEvent;

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
import dsi235.controllers.ParteController;
import dsi235.entities.Categoria;
import dsi235.entities.Correlativo;
import dsi235.entities.Marca;
import dsi235.entities.Parte;
import dsi235.utilities.PageParser;

@ManagedBean(value = "partes_bb")
@SessionScope
public class ParteBackingBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate ingreso;
	private LazyDataModel<Parte> model;
	private Parte parte;
	private ParteController controller;
	private MarcaController marcaController;
	private CategoryController categoryController;
	private List<Marca> marcas;
	private List<Categoria> categorias;
	private Marca marcaSeleccionada;
	private boolean editando;
	private Correlativo corr;
	private CorrelativoController corrCon;

	/**
	 * @return the corr
	 */
	public Correlativo getCorr() {
		return corr;
	}

	/**
	 * @param corr the corr to set
	 */
	public void setCorr(Correlativo corr) {
		this.corr = corr;
	}

	public ParteBackingBean(ParteController controller, MarcaController marcaController,
			CategoryController cat, CorrelativoController corr) {
		super();
		this.controller = controller;
		this.corrCon = corr;
		this.marcaController = marcaController;
		this.categoryController = cat;
		this.categorias = this.categoryController.findAll();
		this.marcas = this.marcaController.findAll();
		CategoriaConverter.list = this.categorias;
		MarcaCoverter.list = this.marcas;
		this.editando=false;
	}

	public void clean() {
//		this.correlativo = null;
		System.out.println("CLEAN TRIGGERED");
	}

	public void nuevo(ActionEvent ev) {
		this.parte = new Parte();
	}

	public void edit(ActionEvent evt) {
		tieneGarantia();
		if (this.controller.save(this.parte) != null)
			message(FacesMessage.SEVERITY_INFO, "Exito", "Elemento editado");
	}
	
	public void toogle(FacesEvent evt) {
		System.out.println(this.editando);
		this.editando=!this.editando;
	}

	private void tieneGarantia() {
		if (!this.parte.getGarantia()) {
			this.parte.setDescripcionGarantia("---");
		}
	}
	
	public void innerSelect(SelectEvent ev) {
		this.corr = (Correlativo) ev.getObject();
		toogle(ev);
	}

	public void save(ActionEvent evt) {
		Correlativo c = this.corrCon.findById(this.parte.getCorrelativo().getCorrelativo()).get();
		this.parte.setCorrelativo(c);
		tieneGarantia();
		this.controller.findById(this.parte.getNumeroSerie()).ifPresentOrElse(
				corr -> message(FacesMessage.SEVERITY_ERROR, "Error!", "Ya existe/Already exists"), () -> {
					this.controller.save(this.parte);
					message(FacesMessage.SEVERITY_INFO, "Exito", "Elemento creado");
				});
	}

	private void message(Severity type, String header, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(type, header, message));
	}

	public void print() {
		System.out.println("GARANTIA EN PRINT ES: " + this.parte.getGarantia());
	}

	public void select(SelectEvent evt) {
		this.parte = (Parte) evt.getObject();
		System.out.println(this.parte.getCorrelativo());
	}

	@PostConstruct
	public void init() {
		iniciar();
	}

	public void delete(Parte parte) {

		if (parte!= null) {
			this.controller.deleteById(parte.getNumeroSerie());
			message(FacesMessage.SEVERITY_INFO, "Exito", "Elemento eliminado");
		}
	}

	public void iniciar() {
		try {
			model = new LazyDataModel<Parte>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Parte getRowData(String rowKey) {
					return obtenerRowData(rowKey);
				}

				@Override
				public Object getRowKey(Parte object) {
					return obtenerRowKey(object);
				}

				@Override
				public List<Parte> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					return cargarDatos(first, pageSize, sortField, sortOrder, filters);
				}

			};
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private Parte obtenerRowData(String rowKey) {
		try {
			List<Parte> registros = (List<Parte>) this.model.getWrappedData();
			if (registros != null && !registros.isEmpty()) {
				Long buscado = Long.parseLong(rowKey);
				for (Parte r : registros) {
					if (r.getNumeroSerie().compareTo(buscado) == 0) {
						return r;
					}
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
		return null;
	}

	private Object obtenerRowKey(Parte object) {
		if (object != null) {
			return object.getNumeroSerie();
		}
		return null;
	}

	private List<Parte> cargarDatos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Parte> salida = null;
		Page<Parte> page = null;
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
	public LazyDataModel<Parte> getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(LazyDataModel<Parte> model) {
		this.model = model;
	}

	/**
	 * @return the parte
	 */
	public Parte getParte() {
		return parte;
	}

	/**
	 * @param parte the parte to set
	 */
	public void setParte(Parte parte) {
		this.parte = parte;
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
	 * @return the editando
	 */
	public boolean isEditando() {
		return editando;
	}

	/**
	 * @param editando the editando to set
	 */
	public void setEditando(boolean editando) {
		this.editando = editando;
	}
	
	
	
	
}
