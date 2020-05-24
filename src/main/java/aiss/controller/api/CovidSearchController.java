package aiss.controller.api;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Covid19data.CovidData;
import aiss.model.Covid19data.Data;
import aiss.model.resources.CovidResource;

/**
 * Servlet implementation class SkyscannerSearchController
 */
public class CovidSearchController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final Logger log = Logger.getLogger(CovidSearchController.class.getName());
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public CovidSearchController() {
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		// Search for flight in Skyscanner
		log.log(Level.FINE, "Searching for Covid19 data");
		CovidResource scr = new CovidResource();
		Data cd = scr.getData().getData();
		
		if(cd!=null) {
			rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("stats", cd.getCovid19Stats());
		}else {
			log.log(Level.SEVERE, "Covid object: " + cd + ".");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
