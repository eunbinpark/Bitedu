package bitedu.bipa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitedu.bipa.member.service.QuizService;

public class MemberController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		cmd = cmd == null?"list":cmd;
		String url = "./manager/book_list.jsp";
		resp.setContentType("text/html; charset=UTF-8");
		//한글처리
		request.setCharacterEncoding("UTF-8");
		boolean isAjax = false;
		if(cmd.equals("view_user_regist")) {
			url = "./member/user_regist.html";
		} else if(cmd.equals("go_book_list")) {
			url = "BlmController?cmd=list";
		} else if(cmd.equals("checkId")){
			boolean flag = new QuizService().checkId(request.getParameter("user_id"));
			isAjax = true;
			String result = "{\"result\":"+flag+"}";
			PrintWriter out = resp.getWriter();
			out.print(result);
			System.out.println(result);
			out.close();
		}
		if(!isAjax) {
			resp.sendRedirect(url);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
