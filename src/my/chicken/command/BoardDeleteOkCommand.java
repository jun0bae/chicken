package my.chicken.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.BoardDAO;

public class BoardDeleteOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		String passwd = req.getParameter("passwd");
		
		BoardDAO dao = new BoardDAO();
		int res = 0;
		try {
			res = dao.deleteBoard(num, passwd);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String msg = null, url = null;
		if (res>0) {
			msg = "�Խñ� ���� ����!! �Խñ� ��� �������� �̵��մϴ�.";
			url = "boardList.chi";
		}else if (res==0){
			msg = "�Խñ� ���� ����!! �۳��뺸�� �������� �̵��մϴ�.";
			url = "boardContent.chi?num=" + num;
		}else {
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���";
			url = "boardDelete.chi?num="+ num;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}
