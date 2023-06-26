package bitedu.bipa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		
		resp.setContentType("text/html; charset=UTF-8");
		String userId = req.getParameter("userId");
		System.out.println(userId);
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
//		String result = "{\"result\":"+flag+"}";
//		PrintWriter out = resp.getWriter();
//		out.print(result);
//		out.close();
	}
}
