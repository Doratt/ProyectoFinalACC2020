package dsi235.boundary.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean<LoginFilter> loginFilter() {
    FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<LoginFilter>();
    registration.setFilter(new LoginFilter());
    //TODO agregar todas las pantallas...
    registration.addUrlPatterns("/dashboard.jsf", "/adminView.jsf", "/asignaciones.jsf", "/historialTecnico.jsf", 
    		"/historialUsuario.jsf","/roles.jsf");
    return registration;
  }
}