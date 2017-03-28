/**
 * 27 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.web.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * @author Christopher CHARLERY
 *
 */
public class CorsFilter implements ContainerResponseFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.
	 * container.ContainerRequestContext,
	 * javax.ws.rs.container.ContainerResponseContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext cres) throws IOException {
		cres.getHeaders().add("Access-Control-Allow-Origin", "*");
		cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
		cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		cres.getHeaders().add("Access-Control-Max-Age", "1209600");
	}

}
