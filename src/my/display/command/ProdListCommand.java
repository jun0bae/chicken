package my.display.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.*;
public class ProdListCommand implements CommandIf {

	

	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String upPath = req.getRealPath("WEB-INF/jsp/admin/files");
		CategoryDAO cdao = new CategoryDAO();
		ProductDAO pdao = new ProductDAO();
		ProductDTO dto = new ProductDTO();
		List<ProductDTO> plist =null;
		List<CategoryDTO> cate =null;
		String cname = req.getParameter("cname");
	    if(cname==null) {
		try {
			plist = pdao.listProduct();
			cate = cdao.listCate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			try {
				plist = pdao.getCateProd(cname);
				cate = cdao.listCate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	    
		req.setAttribute("cname", cname);
		req.setAttribute("prodList", plist);
		req.setAttribute("cateList", cate);
		req.setAttribute("upPath", upPath);
		
		return "WEB-INF/jsp/display/prodList.jsp";
	}
}
