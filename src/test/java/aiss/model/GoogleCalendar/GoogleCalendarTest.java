package aiss.model.GoogleCalendar;

import aiss.model.GoogleCalendar.CalendarList;
import aiss.model.resources.GoogleCalendarResource;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

public class GoogleCalendarTest {

	String token = "ya29.a0AfH6SMCdexxv2YbrtwkEdJlfL2x2xRarpQJlVXN8aZL_Pt3mPEoUezIxJMrlTZNT154UGdd1i7oODfdSsKTveviikNNfxcqYhBTZ-z4w3b-9JkR9sfGEUDTeN5ecFbB3904hI7ixhJNeQxnMawgeZzLddpYeoc88vuU";
	GoogleCalendarResource gcr = new GoogleCalendarResource(token);

	@Test
	public void testGetCalendars() throws UnsupportedEncodingException{
		System.out.println("Test Calendar: Calendars of the account with token: " + token);
		CalendarList list = gcr.getCalendarList();
		
		if(list.getItems().isEmpty()) {
			list = null;
		}
		if(list != null) {
			System.out.println("Found!");
		}
		
		assertNotNull("The list with calendars shouldn't be empty.", list);
	}
	
	@Test
	public void testGetCalendar() throws UnsupportedEncodingException {
		String id = "pkkspuslqd0holfdgk31b8brns@group.calendar.google.com";
		System.out.println("Test Calendar: Calendar with the id " + id);
		Calendar cal = gcr.getCalendar(id);
		
		if(cal == null) {
			cal = null;
		}
		if(cal != null) {
			System.out.println("Found!");
		}
		
		assertNotNull("The calendar shouldn't be null", cal);
	}
	
	@Test
	public void testInsertFile() throws UnsupportedEncodingException {
		String title = "Title";
		System.out.println("Test Calendar: Insert a calendar with name: " + title);
		String res = gcr.insertCalendar(title);
		
		if(res.isEmpty()) {
			res = null;
		}
		if(res != null) {
			System.out.println("Successfully inserted!");
		}
		
		assertNotNull("The inserted calendar shouldn't be null", res);
	}
	
//	@Test
//	public void testUpdateFile() throws UnsupportedEncodingException {
//		System.out.println("Test Calendar: Update calendar.");
//		CalendarList calendars = gcr.getCalendarList();
//		List<CalendarListEntry> list = calendars.getItems();
//		CalendarListEntry cal = list.get(0);
//		Calendar cal2 = gcr.getCalendar(cal.getId());
//		Boolean res = gcr.updateCalendar(cal2, cal2.getId());
//		
//		if(res == true) {
//			System.out.println("Updated successfully!");
//		}
//		
//		assertTrue("The calendar wasn't updated correctly", res);
//	}
//	
//	@Test
//	public void testDeleteFile() throws UnsupportedEncodingException {
//		System.out.println("Test Calendar: Deleting calendar.");
//		CalendarList calendars = gcr.getCalendarList();
//		List<CalendarList> list = calendars.getItems();
//		String id = list.get(3).getId();
//		Boolean res = gcr.deleteCalendar(id);
//		
//		if(res == true) {
//			System.out.println("Deleted successfully!");
//		}
//		
//		assertTrue("The calendar wasn't deleted correctly", res);
//	}
	
}
