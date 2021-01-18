package my.display.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.ProductDAO;
import my.chicken.model.ProductDTO;

public class ProdViewCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int pnum = Integer.parseInt(req.getParameter("pnum"));
		String upPath = req.getServletContext().getRealPath("WEB-INF/jsp/admin/files");
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = null;
		try{
			dto = dao.getProduct(pnum);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("getProduct", dto);
		req.setAttribute("pimage", upPath);
		
		return "WEB-INF/jsp/display/prodView.jsp";
	}

}
