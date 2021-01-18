package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.chicken.model.*;

public class ProdAddCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAO();
		CategoryDTO dto = new CategoryDTO();
		List<CategoryDTO> list =null;
		try {
			list = dao.listCate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("cateList", list);
		return "WEB-INF/jsp/admin/prodAdd.jsp";
	}

}
