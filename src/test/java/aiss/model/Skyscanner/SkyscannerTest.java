package aiss.model.Skyscanner;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;

import org.junit.Test;

import aiss.model.resources.SkyscannerResource;

public class SkyscannerTest {
	
	SkyscannerResource scr = new SkyscannerResource();
	
	@Test
	public void testGetFlight() throws UnsupportedEncodingException{
		String originPlace = "Sevilla";
		String destinationPlace = "Barcelona";
		String outDate = "2020-06-04";
		System.out.println("Test Skyscanner: With Origin: " + originPlace + " and Destination: " + destinationPlace + " on date: " + outDate);
		Skyscanner sc = scr.getFlight(originPlace, destinationPlace, outDate);
		
		if(sc.getQuotes().isEmpty()) {
			sc = null;
		}
		if(sc != null) {
			System.out.println("Found!");
		}
		
		assertNotNull("The list of Places shouldn't be empty.", sc);
	}
	
	@Test
	public void testGetPlaceId() throws UnsupportedEncodingException{
		String placeRaw = "Sevilla";
		System.out.println("Test Skyscanner: Get Place Id: " + placeRaw);
		String sc = scr.getPlaceId(placeRaw);
		
		if(sc.isEmpty()) {
			sc = null;
		}
		if(sc != null) {
			System.out.println("Found!");
		}
		
		assertNotNull("The list with Places shouldn't be empty.", sc);
	}


}
