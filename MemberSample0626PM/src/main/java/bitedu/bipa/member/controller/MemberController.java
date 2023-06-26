package bitedu.bipa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitedu.bipa.member.vo.TestVO;

public class MemberController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		
		resp.setContentType("text/html; charset=UTF-8");
		String userId = req.getParameter("userId");
		System.out.println(userId);
		TestVO test = new TestVO("admin","1234");
		req.setAttribute("test", test);
		//resp.sendRedirect("./member/view_update.jsp?user_id="+userId);
		//resp.sendRedirect("./member/view_update.jsp");
		RequestDispatcher rd = req.getRequestDispatcher("./member/view_update.jsp");
		rd.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post method");
		this.doGet(req, resp);
	}
	
	public void test() {
//		String id = req.getParameter("user_id");
//		boolean flag = false;
//		if(id.equals("admin")) {
//			flag = true;
//		} 
//		String result = "{\"result\":"+flag+"}"; //json
//		PrintWriter out = resp.getWriter();
//		out.print(result);
//		out.close();
	}
}
