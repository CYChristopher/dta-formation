package fr.pizzeria.admin.web.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class TechnicListener
 *
 */
@WebListener
public class TechnicListener implements HttpSessionListener, ServletRequestListener {
	/**
	 * 
	 */
	private static final String COMPTEUR = "compteur";
	private long before;
	
    /**
     * Default constructor. 
     */
    public TechnicListener() {
    	//
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent se)  { 
         Integer compteur = (Integer) se.getSession().getServletContext().getAttribute(COMPTEUR);
         if(compteur == null)
        	 compteur = 0;
         se.getSession().getServletContext().setAttribute(COMPTEUR, compteur + 1);
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre)  { 
         long after = System.currentTimeMillis();
         List<String> timesExe = (List<String>) sre.getServletContext().getAttribute("timeExe");
         HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest();
         String user = (String) httpRequest.getSession().getAttribute("user");
         if(user == null)
        	 user = "Inconnu";
         if(timesExe == null) 
        	 timesExe = new ArrayList<>();
         String path = httpRequest.getRequestURI();
         timesExe.add(path + " par " + user + " : " + (after - before));
         sre.getServletContext().setAttribute("timeExe", timesExe);
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre)  { 
         this.before = System.currentTimeMillis();
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	Integer compteur = (Integer) se.getSession().getServletContext().getAttribute(COMPTEUR);
        se.getSession().getServletContext().setAttribute(COMPTEUR, compteur - 1);
    }
	
}
