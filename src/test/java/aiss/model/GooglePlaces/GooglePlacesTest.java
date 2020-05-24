package aiss.model.GooglePlaces;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;


import aiss.model.GooglePlaces.PlacesSearch;
import aiss.model.resources.GooglePlacesResource;

public class GooglePlacesTest {
	
	@Test
	public void testGetPlacesOK() throws UnsupportedEncodingException{
		System.out.println("Test Places: Searching location by city.");
		GooglePlacesResource gpr = new GooglePlacesResource();
		String city = "Madrid";
		PlacesSearch place = gpr.getPlaces(city);
		
		if(place.getResults().size() != 0)
		{
			System.out.println("The method returns places");
		}
		else
			fail("getPlaces() did not return expected values");	
	}
	
	@Test
	public void testGetPlacesByCategory() throws UnsupportedEncodingException{
		System.out.println("Test Places: Searching places by category.");
		GooglePlacesResource gpr = new GooglePlacesResource();
		String category = "restaurants";
		PlacesSearch place = gpr.getPlaces("Madrid");
		
		if(place.getResults().size() != 0)
		{
			System.out.println("The method returns places");
		}
		else
			fail("getPlacesByCategory() did not return expected values");	
	}

}
