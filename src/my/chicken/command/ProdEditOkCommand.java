package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import my.chicken.model.ProductDAO;

public class ProdEditOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MultipartRequest mr = null;
		String upPath = req.getServletContext().getRealPath("WEB-INF/jsp/admin/files");
		try{
			mr = new MultipartRequest(req, upPath, 10*1024*1024, "EUC-KR");
		}catch(IOException e){
			e.printStackTrace();
	}
		ProductDAO dao = new ProductDAO();
		int res = 0;
		try {
			res = dao.editProd(mr);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String msg = null, url = null;
		if (res>0) {
			msg = "��ǰ ���� ����!! ��ǰ ��� �������� �̵��մϴ�.";
			url = "prodList.chi";
		}else {
			msg = "��ǰ ��� ����!! ��ǰ ��� �������� �̵��մϴ�.";
			url = "prodList.chi";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}
