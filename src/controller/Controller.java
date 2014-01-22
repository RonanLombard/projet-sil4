package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;



@SuppressWarnings("serial")
public class Controller extends HttpServlet {
	
	private String urlMenu;
	private static final String TORQUE_PROPS = new String("/torque.properties");
	
	public void init() throws ServletException {
		urlMenu = getServletConfig().getInitParameter("urlMenu");
		
		if (!Torque.isInit()) {
			try {
				PropertiesConfiguration pc = new PropertiesConfiguration();
				pc.load(this.getClass().getClassLoader().getResourceAsStream(TORQUE_PROPS));
				Torque.init(pc);

			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// POST
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			// on passe la main au GET
			doGet(request, response);
		}
		
		// GET
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {


			// On récupère la méthode d'envoi de la requête
			String methode = request.getMethod().toLowerCase();
			
			// On récupère l'action à exécuter
			String action = request.getPathInfo();
			if (action == null) {
				action = "/menu";
				System.out.println("action == null");
			}
			//System.out.println(action);
			
			// Exécution action
			if (methode.equals("get") && action.equals("/menu")) {
				menu(request, response);
				
			} 
			else {
				// Autres cas
				menu(request, response);
			}
		}
		
		public void menu(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			loadJSP(urlMenu, request, response);
		}
		

		public void loadJSP(String url, HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request, response);
		}
}
