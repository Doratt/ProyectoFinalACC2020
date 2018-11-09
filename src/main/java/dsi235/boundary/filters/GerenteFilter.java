package dsi235.boundary.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import dsi235.boundary.backingBeans.LoginSessionBean;

//@Component
public class GerenteFilter implements Filter {
	
	private static final String LOGIN_PAGE = "login.jsf";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		// managed bean name is exactly the session attribute name
		LoginSessionBean loginSession = (LoginSessionBean) httpServletRequest.getSession().getAttribute("loginSessionBean");

		if (loginSession != null) {
			if (loginSession.isGerente()) {
				System.out.println("Es gerente...");
				filterChain.doFilter(request, response);
			} else {
				System.out.println("NO es gerente...");
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
			}
		} else {
			System.out.println("loginSession es null");
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
