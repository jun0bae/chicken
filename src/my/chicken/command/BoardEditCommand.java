package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.BoardDAO;
import my.chicken.model.BoardDTO;

public class BoardEditCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = null;
		try{
			dto = dao.getBoard(num);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("getBoard", dto);
		return "WEB-INF/jsp/admin/boardEdit.jsp";
	}

}
