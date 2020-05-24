package aiss.controller.api;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.GooglePlaces.PlacesSearch;
import aiss.model.GooglePlaces.Result;
import aiss.model.resources.GooglePlacesResource;

public class GooglePlacesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GooglePlacesController.class.getName());

	public GooglePlacesController() {

		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;

//		String busqueda = request.getParameter("goToPlaces");
		String busqueda = (String) request.getSession().getAttribute("destination");
		
		log.log(Level.FINE, "Busqueda: " + busqueda);
		GooglePlacesResource gpresoruces = new GooglePlacesResource();

		log.log(Level.FINE, "Entra al controlador");
		PlacesSearch resultados = gpresoruces.getPlaces(busqueda);
		log.log(Level.FINE, "Nombre del resultados.getResults.getName: " + resultados.getResults().get(0).getName());
		List<Result> results = resultados.getResults();
		log.log(Level.FINE, "results.size " + results.size());
		for(int i = 0; i < results.size(); i++) {
			log.log(Level.FINE, "Nombre: " + i + results.get(i).getName());
		}
		if (resultados.getResults().size() > 0) {
			log.log(Level.FINE, "Entra al if");
			rd = request.getRequestDispatcher("/gplaces.jsp");
			request.setAttribute("placeSearch", results);
			log.log(Level.FINE, "Sale del if");
		} else {
			log.log(Level.FINE, "Entra al else");
			request.setAttribute("error", "No se ha encontrado ningún lugar con ese nombre");
			rd = request.getRequestDispatcher("/error.jsp");
			log.log(Level.FINE, "Sale del else");
		}
		log.log(Level.FINE, "rd.forward(request, response);");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
