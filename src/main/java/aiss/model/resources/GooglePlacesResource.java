package aiss.model.resources;

import aiss.model.GooglePlaces.PlacesSearch;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class GooglePlacesResource {

    private static final Logger log = Logger.getLogger(GooglePlacesResource.class.getName());

    private final String GOOGLE_PLACES_API_KEY= "AIzaSyAu83NAI0SvUNfLo_IMpfDqI28GkMcL6X8";
    private final String url ="https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+";
//  private final String url2 ="https://maps.googleapis.com/maps/api/place/textsearch/json?";
    

    

    /**
     *
     * @return PlacesSearch
     */
	public PlacesSearch getPlaces(String search) throws UnsupportedEncodingException {
    	
    	String busqueda = URLEncoder.encode(search, "UTF-8");
    	
        ClientResource cr = null;
        PlacesSearch places = null;
        String uri = url + busqueda + "&key=" + GOOGLE_PLACES_API_KEY;
        log.log(Level.FINE, "URI: " + uri);
        try {
            cr = new ClientResource(uri);
            places = cr.get(PlacesSearch.class);
            log.log(Level.FINE, "places size: " + places.getResults().size());

        } catch (ResourceException re) {
            System.err.println(cr.getResponse().getStatus());
            }

        return places;

    }
	
	public PlacesSearch getPlacesByCategory(String search) throws UnsupportedEncodingException {
	
    	String busqueda = URLEncoder.encode("category", "UTF-8");
    	
        ClientResource cr = null;
        PlacesSearch places = null;
        String uri = url + "query=" + busqueda + "+in+Madrid" + "&key=" + GOOGLE_PLACES_API_KEY;
        log.log(Level.FINE, "URI: " + uri);
        try {
            cr = new ClientResource(uri);
            places = cr.get(PlacesSearch.class);
            log.log(Level.FINE, "places size: " + places.getResults().size());

        } catch (ResourceException re) {
            System.err.println(cr.getResponse().getStatus());
            }

        return places;

    }

}
