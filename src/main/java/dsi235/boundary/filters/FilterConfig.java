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
    registration.addUrlPatterns("/paginaprincipal.jsf");
    return registration;
  }
}