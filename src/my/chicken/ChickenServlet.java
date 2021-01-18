package my.chicken;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.chicken.command.CommandFactory;
import my.chicken.command.CommandIf;

public class ChickenServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		
		String reqUri = req.getRequestURI();
		String upPath = req.getContextPath();
		String cmd = reqUri.substring(upPath.length());
		
		CommandFactory factory = CommandFactory.getInstance();
		CommandIf cmdIf = factory.createCommand(cmd);
		String nextPage = (String)cmdIf.processCommand(req, resp);
		
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
	
}