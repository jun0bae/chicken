package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import my.chicken.model.EventDAO;
import my.chicken.model.ProductDAO;

public class EventWriteOkCommand implements CommandIf {

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
		EventDAO dao = new EventDAO();
		int res = 0;
		try {
			res = dao.insertEvent(mr);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String msg = null, url = null;
		if (res>0) {
			msg = "�̺�Ʈ ��� ����!! �̺�Ʈ ��� �������� �̵��մϴ�.";
			url = "eventList.chi";
		}else {
			msg = "�̺�Ʈ ��� ����!! �̺�Ʈ �ۼ� �������� �̵��մϴ�.";
			url = "eventWrite.chi";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}
