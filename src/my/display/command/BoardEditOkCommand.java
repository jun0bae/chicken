package my.display.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.BoardDAO;
import my.chicken.model.BoardDTO;

public class BoardEditOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		BoardDTO dto = new BoardDTO();
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content"));
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		
		BoardDAO dao = new BoardDAO();
		int res = 0;
		try {
			res = dao.updateBoard(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String msg = null, url = null;
		if (res>0) {
			msg = "�Խñ� ���� ����!! �Խñ� ��� �������� �̵��մϴ�.";
			url = "boardList.dis";
		}else if (res==0){
			msg = "�Խñ� ���� ����!! �۳��뺸�� �������� �̵��մϴ�.";
			url = "boardContent.dis?num=" + dto.getNum();
		}else {
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���";
			url = "boardEdit.dis?num="+ dto.getNum();
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}
