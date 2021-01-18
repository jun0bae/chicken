package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.*;

public class ProdListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String upPath = req.getRealPath("WEB-INF/jsp/admin/files");
		ProductDTO dto = new ProductDTO();
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> list =null;
		try {
			list = dao.listProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("upPath", upPath);
		req.setAttribute("prodlist", list);
		return "WEB-INF/jsp/admin/prodList.jsp";
	}

}
