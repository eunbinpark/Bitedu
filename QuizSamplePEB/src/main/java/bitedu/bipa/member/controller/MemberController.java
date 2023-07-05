package bitedu.bipa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitedu.bipa.member.service.QuizService;
import bitedu.bipa.member.vo.BookCopy;

public class MemberController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		cmd = cmd == null?"list":cmd;
		String url = "./member/user_regist.html";
		resp.setContentType("text/html; charset=UTF-8");
		//한글처리
		request.setCharacterEncoding("UTF-8");
		boolean isAjax = false;
		if(cmd.equals("view_user_regist")) {
			
		} else if(cmd.equals("go_book_list")) {
			
		} else if(cmd.equals("checkId")){
			isAjax = true;
			
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