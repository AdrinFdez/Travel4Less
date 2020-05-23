package aiss.controller.api;

import java.io.IOException; 
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.GoogleCalendarResource;

public class GoogleCalendarCalendarDeleteController extends HttpServlet{

	private static final Logger log = Logger.getLogger(GoogleCalendarCalendarDeleteController.class.getName());
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
		String id = req.getParameter("id");
        if (id != null && !"".equals(id)) {
            String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
            if (accessToken != null && !"".equals(accessToken)) {
                GoogleCalendarResource gcResource = new GoogleCalendarResource(accessToken);
                gcResource.deleteCalendar(id);
                log.info("Calendar with id '" + id + "' deleted!");
                req.getRequestDispatcher("/googleCalendarCalendarList").forward(req, resp);
            } else {
                log.info("Trying to access Google Drive without an access token, redirecting to OAuth servlet");
                req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
            }
        } else {
            log.warning("Invalid id for delete!");
            req.getRequestDispatcher("/GoogleCalendarCalendarList").forward(req, resp);
        }
    }
	
}
