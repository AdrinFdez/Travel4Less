package aiss.controller.api;

import aiss.model.GoogleDrive.FileItem;  
import aiss.model.resources.GoogleDriveResource;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoogleDrivePlacesController extends HttpServlet{

	private static final Logger log = Logger.getLogger(GoogleDriveFileDeleteController.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
    	String accessToken = (String) req.getSession().getAttribute("GoogleDrive-token");
//      String title = req.getParameter("title");
//      String content = req.getParameter("content");
        if(req.getParameter("rest")!=null && req.getParameter("address")!=null) {
        	req.getSession().setAttribute("place", req.getParameter("rest"));
        	req.getSession().setAttribute("adrs", req.getParameter("address"));
        }
        String title = (String) req.getSession().getAttribute("place");
        log.log(Level.FINE, "The title: " + title);
        String content = (String) req.getSession().getAttribute("adrs");
        log.log(Level.FINE, "The content: " + content);
//      title.concat((String) req.getSession().getAttribute("place"));
//      title.concat((String) req.getSession().getAttribute("gplace"));
        if (accessToken != null && !"".equals(accessToken)) {
            if (title != null && !"".equals(title)) {
                GoogleDriveResource gdResource = new GoogleDriveResource(accessToken);
                FileItem file = new FileItem();
                file.setTitle(title);
                file.setMimeType("text/plain");
                gdResource.insertFile(file, content);
                req.setAttribute("message", "File '" + title + "' added to your Drive!");
                req.getRequestDispatcher("/googleDriveFileList").forward(req, resp);
            } else {
                req.setAttribute("message", "You must provide a valid title for file");
                req.setAttribute("content", content);
                req.getRequestDispatcher("googleDriveFileEdit.jsp").forward(req, resp);
            }
        } else {
            log.info("Trying to access Google Drive without an access token, redirecting to OAuth servlet");
            req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
	
}
