package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnoMapping
 */
@WebServlet("/13Servlet/AnnoMapping.do")
public class AnnoMapping extends HttpServlet {
	@Override
//	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("message", "@webServlet으로 매핑");
		req.getRequestDispatcher("/13Servlet/AnnoMapping.jsp")
		.forward(req, resp);	
	}
}
