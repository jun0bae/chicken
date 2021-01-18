package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.chicken.model.*;
import java.util.*;

public class CateAddCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDTO dto = new CategoryDTO();
		CategoryDAO dao = new CategoryDAO();
		dto.setCname(req.getParameter("cname"));
		if(req.getParameter("cname")!=null) {
		
		try {
			dao.insertCate(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		List<CategoryDTO> list =null;
		try {
			list = dao.listCate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("catelist", list);
		
		return "WEB-INF/jsp/admin/cateAdd.jsp";
	}

}
