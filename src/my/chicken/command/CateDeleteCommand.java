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
			msg = "삭제성공!! 브랜드등록페이지로 이동합니다.";
		}else {
			msg = "삭제실패!! 브랜드등록페이지로 이동합니다.";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
