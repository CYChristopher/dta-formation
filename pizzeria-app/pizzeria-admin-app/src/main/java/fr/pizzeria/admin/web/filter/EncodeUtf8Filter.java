package fr.pizzeria.admin.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodeUtf8Filter
 */
@WebFilter({ "/pizzas/list", "/pizzas/edit", "/pizzas/new" })
public class EncodeUtf8Filter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodeUtf8Filter() {
        // 
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
		// 
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		// 
	}

}
