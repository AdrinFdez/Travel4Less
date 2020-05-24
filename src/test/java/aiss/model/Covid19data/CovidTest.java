package aiss.model.Covid19data;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resources.CovidResource;

public class CovidTest {
	
	CovidResource cdr = new CovidResource();
	
	@Test
	public void testGetData() throws UnsupportedEncodingException{
		System.out.println("Test COVID19 SC: Get Data from Spain");
		CovidData cd = cdr.getData();
		
		if(cd.getData().getCovid19Stats().isEmpty()) {
			cd = null;
		}
		if(cd != null) {
			System.out.println("Found!");
		}
		
		assertNotNull("The list with stadistics shouldn't be empty.", cd);
	}


}
