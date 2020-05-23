package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.GoogleCalendar.Calendar;
import aiss.model.GoogleCalendar.CalendarList;

public class GoogleCalendarResource {

	private static final Logger log = Logger.getLogger(GoogleCalendarResource.class.getName());
	
	private final String access_token;
	private final String uri_list = "https://www.googleapis.com/calendar/v3/users/me/calendarList";
	private final String uri_cal_eve = "https://www.googleapis.com/calendar/v3/calendars";
	
	public GoogleCalendarResource(String access_token) {
		this.access_token = access_token;
	}
	
	public CalendarList getCalendarList() throws UnsupportedEncodingException{
		
		ClientResource cr = new ClientResource(uri_list + "?access_token=" + access_token);
		CalendarList list = cr.get(CalendarList.class);
		
		return list;
	}
	
	public Calendar getCalendar(String id) {
		ClientResource cr = null;
		Calendar calendar = null;
		try {
			cr = new ClientResource(uri_cal_eve + "/" + id + "?access_token=" + access_token);
			String result = cr.get(String.class);
			calendar = cr.get(Calendar.class);
		} catch (ResourceException re) {
			log.warning("Error when retrieving all calendars: " + cr.getResponse().getStatus());
		}
		return calendar;
	}
	
	public String insertCalendar(String title) {
		ClientResource cr = null;
		String newId = null;
		Calendar calendar = new Calendar();
		calendar.setSummary(title);
		try {
			cr = new ClientResource(uri_cal_eve + "?access_token=" + access_token);
			Calendar newCalendar = cr.post(calendar, Calendar.class);
			newId = newCalendar.getId();
		} catch (ResourceException re) {
			log.warning("Error when trying to insert a new calendar: " + cr.getResponse().getStatus());
		}
		return newId;
	}
	
	public boolean updateCalendar(Calendar calendar, String idCalendar) {
		ClientResource cr = null;
		boolean result = true;
		try {
			cr = new ClientResource(uri_cal_eve + "/" + idCalendar + "?access_token=" + access_token);
			cr.put(calendar);
		} catch (ResourceException re) {
			log.warning("Error when updating a calendar: " + cr.getResponse().getStatus());
			result = false;
		}
		return result;
	}
	
	public boolean deleteCalendar(String idCalendar) {
		ClientResource cr = null;
		boolean result = true;
		try {
			cr = new ClientResource(uri_cal_eve + "/" + idCalendar + "?access_token=" + access_token);
			cr.delete();
		} catch (ResourceException re) {
			log.warning("Error when deleting a calendar: " + cr.getResponse().getStatus());
			result = false;
		}
		return result;
	}
	
}
