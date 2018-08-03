package br.com.akira.sistema.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class Filtro implements Filter {

	public Filtro() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		HttpSession sessao = req.getSession();

		//lastIndexOf retorna a -1 se não exitir a url
		//se for diferente de -1 deixa passar
		if (sessao.getAttribute("usuAutenticado") != null 
				|| uri.lastIndexOf("login.jsp") !=-1 
				|| uri.lastIndexOf("usuLogin")  !=-1) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect("login.jsp");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
