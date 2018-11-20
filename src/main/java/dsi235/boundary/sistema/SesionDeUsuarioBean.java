package dsi235.boundary.sistema;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class SesionDeUsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void changeLanguageUS(String language) {
		System.out.println("cambiando a ingles");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.US);
	}
	
	public void changeLanguageES(String language) {
		System.out.println("cambiando a espanol");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.getDefault());
	}

//	
	   private String locale;

	   public static Map<String,Object> countries;
	   static {
	        countries = new LinkedHashMap<>();
	        countries.put("Español", Locale.forLanguageTag("es"));
	        countries.put("English", Locale.US);
	    }

	   public Map<String, Object> getCountries() {
	      return countries;
	   }

	   public String getLocale() {
	      return locale;
	   }

	   public void setLocale(String locale) {
	      this.locale = locale;
	   }

	   //value change event listener
	   public void localeChanged(ValueChangeEvent e) {
	      String newLocaleValue = e.getNewValue().toString();
	      
	      for (Map.Entry<String, Object> entry : countries.entrySet()) {
	         
	         if(entry.getValue().toString().equals(newLocaleValue)) {
	            FacesContext.getCurrentInstance()
	               .getViewRoot().setLocale((Locale)entry.getValue());         
	         }
	      }
	   }
	   
//	   public void changeLanguage(String language) {
//	        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
//	    }
	
	
	
	

//	private String codigoIdioma = "es";
//
//    private static Map<String, Object> paises;
//
//    static {
//        paises = new LinkedHashMap<>();
//        paises.put("Español", Locale.forLanguageTag("es"));
//        paises.put("English", Locale.US);
//
//    }
//
//    public Map<String, Object> getPaises() {
//        return paises;
//    }
//
//    public String getCodigoIdioma() {
//        return codigoIdioma;
//    }
//
//    public void setCodigoIdioma(String codigoIdioma) {
//        this.codigoIdioma = codigoIdioma;
//    }
//
//    public void cambioDeIdiomaHandler(ValueChangeEvent vce) {
//        if (vce.getNewValue() != null) {
//            try {
//                String nuevoCodigo = vce.getNewValue().toString();
//                for (Map.Entry<String, Object> entrySet : paises.entrySet()) {
//                    Locale value = (Locale) entrySet.getValue();
//                    if (value.toString().compareTo(nuevoCodigo) == 0) {
//                        FacesContext.getCurrentInstance().getViewRoot().setLocale(value);
//                        return;
//                    }
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            }
//        }
//    }
//
//    public String getMensaje(final String clave) {
//        try {
//            ResourceBundle propiedades = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "TraduccionesGenerales");
//            if (propiedades != null && propiedades.containsKey(clave)) {
//                return propiedades.getString(clave);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//        }
//        return null;
//    }

}
