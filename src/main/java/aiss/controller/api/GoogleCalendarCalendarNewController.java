package aiss.controller.api;

import java.io.IOException; 
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.GoogleCalendar.Calendar;
import aiss.model.resources.GoogleCalendarResource;

public class GoogleCalendarCalendarNewController extends HttpServlet{

	private static final Logger log = Logger.getLogger(GoogleCalendarCalendarNewController.class.getName());
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
		String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
        String title = req.getParameter("title");
        if (accessToken != null && !"".equals(accessToken)) {
            if (title != null && !"".equals(title)) {
                GoogleCalendarResource gcResource = new GoogleCalendarResource(accessToken);
                Calendar calendar = new Calendar();
                calendar.setSummary(title);
                gcResource.insertCalendar(title);
                req.setAttribute("message", "Calendar '" + title + "' added to your Google Calendar!");
                req.getRequestDispatcher("/googleCalendarCalendarList").forward(req, resp);
            } else {
                req.setAttribute("message", "You must provide a valid title for calendar");
                req.getRequestDispatcher("GoogleCalendarCalendarEdit.jsp").forward(req, resp);
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
