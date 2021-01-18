package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.BoardDAO;
import my.chicken.model.BoardDTO;
import my.chicken.model.CategoryDAO;
import my.chicken.model.CategoryDTO;
import my.chicken.model.ProductDAO;
import my.chicken.model.ProductDTO;

public class ProdEditCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = null;
		try{
			dto = dao.getProduct(num);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		CategoryDAO cdao = new CategoryDAO();
		CategoryDTO cdto = new CategoryDTO();
		List<CategoryDTO> clist =null;
		try {
			clist = cdao.listCate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("cateList", clist);
		req.setAttribute("getProd", dto);
		return "WEB-INF/jsp/admin/prodEdit.jsp";
	}

}
