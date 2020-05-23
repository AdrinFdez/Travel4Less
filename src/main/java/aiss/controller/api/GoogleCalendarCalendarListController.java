package aiss.controller.api;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.GoogleCalendar.CalendarList;
import aiss.model.resources.GoogleCalendarResource;

public class GoogleCalendarCalendarListController extends HttpServlet{

	private static final Logger log = Logger.getLogger(GoogleCalendarCalendarListController.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
//      String idC = req.getParameter("calendarId");
        log.log(Level.FINE, "El accessToken " + accessToken);
        if (accessToken != null && !"".equals(accessToken)) {
        	log.log(Level.FINE, "Entra al if del token");
        	
            GoogleCalendarResource gcResource = new GoogleCalendarResource(accessToken);
            log.log(Level.FINE, "Entra al controlador");
//            CalendarList list = gcResource.getCalendarList();
            CalendarList list = gcResource.getCalendarList();
            if (list != null) {
            	log.log(Level.FINE, "Mostrando datos");
                req.setAttribute("list", list);
                req.getRequestDispatcher("/GoogleCalendarCalendarsListing.jsp").forward(req, resp);
            } else {
                log.info("The calendar list returned are null... probably your token has experied. Redirecting to OAuth servlet.");
                req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
            }
        } else {
            log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
            req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
	
}
