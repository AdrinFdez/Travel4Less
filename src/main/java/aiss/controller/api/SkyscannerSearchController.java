package aiss.controller.api;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Skyscanner.Skyscanner;
import aiss.model.resources.SkyscannerResource;

/**
 * Servlet implementation class SkyscannerSearchController
 */
public class SkyscannerSearchController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final Logger log = Logger.getLogger(SkyscannerSearchController.class.getName());
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public SkyscannerSearchController() {
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String originPlace = request.getParameter("origin");
		String destinationPlace = request.getParameter("destination");
		String outDate = request.getParameter("date");
		RequestDispatcher rd = null;
		
		// Search for flight in Skyscanner
		log.log(Level.FINE, "Searching for flights from " + originPlace + " to the " + destinationPlace + " on the " + outDate);
		SkyscannerResource scr = new SkyscannerResource();
		Skyscanner sc = scr.getFlight(originPlace, destinationPlace, outDate);
		
		if(sc!=null) {
			rd = request.getRequestDispatcher("/skyscannerResults.jsp");
			request.setAttribute("flights", sc.getQuotes());
			request.setAttribute("carriers", sc.getCarriers());
			request.setAttribute("currenciess", sc.getCurrencies());
			request.setAttribute("dates", sc.getDates());
			request.setAttribute("places", sc.getPlaces());
		}else {
			log.log(Level.SEVERE, "Skyscanner object: " + sc + ".");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
