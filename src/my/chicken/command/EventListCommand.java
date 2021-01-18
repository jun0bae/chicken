package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.EventDAO;
import my.chicken.model.EventDTO;

public class EventListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String upPath = req.getRealPath("WEB-INF/jsp/admin/files");
		EventDTO dto = new EventDTO();
		EventDAO dao = new EventDAO();
		List<EventDTO> list =null;
		try {
			list = dao.listEvent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("upPath", upPath);
		req.setAttribute("eventlist", list);
		return "WEB-INF/jsp/admin/eventList.jsp";
	}

}
