package my.display.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.CategoryDAO;
import my.chicken.model.CategoryDTO;
import my.chicken.model.EventDAO;
import my.chicken.model.EventDTO;
import my.chicken.model.ProductDAO;
import my.chicken.model.ProductDTO;

public class EventListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String upPath = req.getRealPath("WEB-INF/jsp/admin/files");
		EventDAO dao = new EventDAO();
		EventDTO dto = new EventDTO();
		List<EventDTO> list =null;
		String event = req.getParameter("event");
		try {
			list = dao.listEvent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(event==null) {
			try {
				list = dao.listEvent();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				try {
					list = dao.getEvent(event);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		req.setAttribute("event", event);
		req.setAttribute("upPath", upPath);
		
		return "WEB-INF/jsp/display/eventList.jsp";
        }
}


