package my.display.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.BoardDAO;
import my.chicken.model.BoardDTO;

public class BoardWriteOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content"));
		dto.setIp(req.getRemoteAddr());
		String num = req.getParameter("num");
		if (num==null || num.trim().equals("")) {
			dto.setNum(0);
			dto.setRe_step(0);
			dto.setRe_level(0);
		}else {
			dto.setNum(Integer.parseInt(num));
			dto.setRe_step(Integer.parseInt(req.getParameter("re_step")));
			dto.setRe_level(Integer.parseInt(req.getParameter("re_level")));
		}
				
		BoardDAO dao = new BoardDAO();
		int res = 0;
		try {
			res = dao.insertBoard(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String msg = null, url = null;
		if (res>0) {
			msg = "게시글 등록 성공!! 게시글 목록 페이지로 이동합니다.";
			url = "boardList.dis";
		}else {
			msg = "게시글 등록 실패!! 게시글 등록 페이지로 이동합니다.";
			url = "boardWrite.dis";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}
}
