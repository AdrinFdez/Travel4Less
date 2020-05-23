package aiss.controller.api;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.GoogleCalendar.Calendar;
import aiss.model.resources.GoogleCalendarResource;

public class GoogleCalendarCalendarUpdateController extends HttpServlet{

	private static final Logger log = Logger.getLogger(GoogleCalendarCalendarUpdateController.class.getName());
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
		String id = req.getParameter("id");
        if (id != null && !"".equals(id)) {
            String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
            if (accessToken != null && !"".equals(accessToken)) {
                GoogleCalendarResource gcResource = new GoogleCalendarResource(accessToken);
                Calendar calendar = gcResource.getCalendar(id);
                req.setAttribute("calendar", calendar);
                req.setAttribute("title", gcResource.getCalendar(id).getSummary());
                req.getRequestDispatcher("/GoogleCalendarCalendarEdit.jsp").forward(req, resp);
            } else {
                log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
                req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
            }
        } else {
            log.warning("Invalid id for update!");
            req.getRequestDispatcher("/googleCalendarCalendarList").forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        if (id != null && !"".equals(id)) {
            String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
            String title = req.getParameter("title");
            if (accessToken != null && !"".equals(accessToken)) {
                GoogleCalendarResource gcResource = new GoogleCalendarResource(accessToken);
                Calendar cal = gcResource.getCalendar(id);
                cal.setSummary(title);
                gcResource.updateCalendar(cal, id);
                req.getRequestDispatcher("/googleCalendarCalendarList").forward(req, resp);
            } else {
                log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
                req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
            }
        } else {
            log.warning("Invalid id for update!");
            req.getRequestDispatcher("/googleCalendarCalendarList").forward(req, resp);
        }
    }
	
}
