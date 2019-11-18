package dsi235.boundary.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean<LoginFilter> loginFilter() {
    FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<LoginFilter>();
    registration.setFilter(new LoginFilter());
    
    registration.addUrlPatterns("/dashboard.jsf", "/adminView.jsf", "/asignaciones.jsf", "/historialTecnico.jsf", 
    		"/historialUsuario.jsf","/roles.jsf", "/estadisticasNumeroTickets.jsf", 
    		"/estadisticasRetroalimentacion.jsf", "/estadisticasTiempo.jsf", "/correlativo.jsf");
    return registration;
  }
}