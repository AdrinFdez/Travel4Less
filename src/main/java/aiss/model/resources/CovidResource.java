package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.Request;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import aiss.model.Covid19data.CovidData;


public class CovidResource {

	private static final String COVID_API_KEY = "0d6fa3dfdamshc0cb1d1783d6ce7p145ea3jsn618e0c8702e7";  
	private static final String COVID_API_HOST = "covid-19-coronavirus-statistics.p.rapidapi.com";
	private static final Logger log = Logger.getLogger(CovidResource.class.getName());
	
	public CovidData getData() throws UnsupportedEncodingException {
		//https://covid-19-data.p.rapidapi.com/country?format=json&name=Spain
		
		String uri = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=Spain";
		
		log.log(Level.FINE, "Covid19 Data by Country URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		Request rq = cr.getRequest();
		Series<Header> headers = new Series<>(Header.class);
		headers.set("x-rapidapi-host", COVID_API_HOST);
		headers.set("x-rapidapi-key", COVID_API_KEY);
		rq.getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
		
//		log.log(Level.FINE, "Data cached fine: " + rq.toString());
		
		CovidData cd = cr.get(CovidData.class);
		
		log.log(Level.FINE, "Data retrieved from country: " + cd.getData().getCovid19Stats().get(0).getCountry());
		
		return cd;
	}
}
