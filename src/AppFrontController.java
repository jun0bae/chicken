import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="*.do")
public class AppFrontController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
															throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		
		String reqUri = req.getRequestURI();
		String upPath = req.getContextPath();
		String cmd = reqUri.substring(upPath.length());
		//PrintWriter pw = resp.getWriter();
		String nextPage = null;
		if (cmd.equals("/main.do")) {
			nextPage = "WEB-INF/jsp/display/main.jsp";
		}
		
		
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
	
}








