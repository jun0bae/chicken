package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.*;

public class CateDeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String no = req.getParameter("cnum");
		CategoryDAO dao = new CategoryDAO();
		int res = 0;
		try {
			res = dao.deleteCate(Integer.parseInt(no));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String msg = null, url = "cateAdd.chi";
		if (res>0) {
			msg = "��������!! �귣������������ �̵��մϴ�.";
		}else {
			msg = "��������!! �귣������������ �̵��մϴ�.";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
