package my.display.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.model.BoardDAO;
import my.chicken.model.BoardDTO;

public class BoardListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String pageNum = req.getParameter("pageNum");
		if (pageNum==null){
			pageNum = "1";
		}
		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = pageSize * currentPage - (pageSize - 1);
		int endRow = pageSize * currentPage;
		int count = 0;
		try{
			count = dao.getCount();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (endRow>count) endRow = count;
		
		List<BoardDTO> list = null;
		try {
			list = dao.listBoard(startRow, endRow);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		int startNum = count - ((currentPage-1) * pageSize);
		
		int pageBlock = 3;
		int pageCount = count/pageSize + (count%pageSize == 0 ? 0 : 1);
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if (endPage>pageCount) endPage = pageCount;
		
		req.setAttribute("count", count);
		req.setAttribute("startNum", startNum);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageBlock", pageBlock);
		req.setAttribute("listBoard", list);
		return "WEB-INF/jsp/display/boardList.jsp";
	}
}
