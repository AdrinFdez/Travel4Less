package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import aiss.model.Skyscanner.FlightPlaceSearch;
import aiss.model.Skyscanner.Skyscanner;

public class SkyscannerResource {

	private static final String SKYS_API_KEY = "80efaa2769msh7fd3623429abe25p1802efjsn626a8a628e45";  
	private static final String SKYS_API_HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";
	private static final Logger log = Logger.getLogger(SkyscannerResource.class.getName());
	
	public Skyscanner getFlight(String originPlace, String destinationPlace, String outDate) throws UnsupportedEncodingException {
		
		String origin = getPlaceId(originPlace);
		String destination = getPlaceId(destinationPlace);
		String date = URLEncoder.encode(outDate, "UTF-8");
		
		//https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsedates/v1.0/US/USD/en-US/SFO-sky/LAX-sky/2019-09-01?inboundpartialdate=2019-12-01
		// URL + SFO-sky/LAX-sky/2019-09-01
		// URL + origin + "/" + destination + "/" + goDate
		
		String uri = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsedates/v1.0/ES/EUR/es-spa/" + origin + "/" + destination + "/" + date;
		
		log.log(Level.FINE, "Skyscanner Flight Date URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		Request rq = cr.getRequest();
		Series<Header> headers = new Series<>(Header.class);
		headers.set("x-rapidapi-host", SKYS_API_HOST);
		headers.set("x-rapidapi-key", SKYS_API_KEY);
		rq.getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
		
		Skyscanner sc = cr.get(Skyscanner.class);
		
		return sc;
	}
	
	public String getPlaceId(String placeRaw)  throws UnsupportedEncodingException {
		
		String place = URLEncoder.encode(placeRaw, "UTF-8");
		
		String uri = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/ES/EUR/es-spa/?query=" + place;
		
		log.log(Level.FINE, "Skyscanner Place URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		Request rq = cr.getRequest();
		Series<Header> headers = new Series<>(Header.class);
		headers.set("x-rapidapi-host", SKYS_API_HOST);
		headers.set("x-rapidapi-key", SKYS_API_KEY);
		rq.getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
		
		String placeOut = cr.get(FlightPlaceSearch.class).getPlaces().get(0).getPlaceId();
		
		return placeOut;
	}

	public static void main(String[] args) throws UnsupportedEncodingException{
		
		SkyscannerResource scr = new SkyscannerResource();
		
		System.out.println(scr.getFlight("Sevilla", "Barcelona", "2020-05-27").getDates().getOutboundDates().get(0).getPartialDate());
//		System.out.println(scr.getPlaceId("Sevilla"));
	}
	
}
