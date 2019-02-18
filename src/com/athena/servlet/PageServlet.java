package com.athena.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.athena.pojo.PageInfo;
import com.athena.service.PeopleService;
import com.athena.service.impl.PeopleServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/page")
public class PageServlet extends HttpServlet {
	PeopleService service = new PeopleServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String curNumStr = req.getParameter("curNum");
		int curNum = 1;
		if(curNumStr!=null && !curNumStr.equals("")) {
			curNum = Integer.parseInt(req.getParameter("curNum"));
		}
		String pageSizeStr = req.getParameter("pageSize");
		int pageSize = 2;
		if(pageSizeStr!=null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}
		
		PageInfo pi = service.showPage(curNum, pageSize);
		System.out.println(pi);
		req.setAttribute("PageInfo", pi);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
