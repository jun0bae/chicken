package my.chicken.command;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.ProductDAO;

public class ProdDeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String pimage = req.getParameter("pimage");
		ProductDAO dao = new ProductDAO();
		
		int res=0;
		try {
			res = dao.deleteProduct(Integer.parseInt(pnum));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = null, url = "prodList.chi";
		if (res>0){
			String upPath = req.getServletContext().getRealPath("WEB-INF/jsp/admin/files");
			File file = new File(upPath, pimage);
			if (file.delete()){
				msg = "��ǰ ���� ����(�̹��� ������ ����)!! ��ǰ ��� �������� �̵��մϴ�.";
			}else {
				msg = "��ǰ ���� ����(�̹��� ������ ����)!! ��ǰ ��� �������� �̵��մϴ�.";
			}
		}else {
			msg = "��ǰ ���� ����!! ��ǰ ��� �������� �̵��մϴ�.";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}
}
