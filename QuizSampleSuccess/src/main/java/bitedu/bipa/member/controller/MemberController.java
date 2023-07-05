package bitedu.bipa.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		QuizService service = new QuizService();
		//한글처리
		request.setCharacterEncoding("UTF-8");
		boolean isAjax = false;
		if(cmd.equals("view_user_regist")) {
			url="./member/user_regist.html";
		} else if(cmd.equals("go_book_list")) {
			url="./BlmController?cmd=list";
		} else if(cmd.equals("checkId")){
			System.out.println("1");
			isAjax = true;
			boolean result = false;
			String Id = request.getParameter("user_id");
			if(service.checkId(Id)) {
				System.out.println("중복 아이디 있음");
			}else {
				System.out.println("중복 아이디 없음");
				result = true;
			}
			PrintWriter writer = resp.getWriter();//printwriter를 이용해서 ajax에 데이터를 json형태로 넘김
			String result1 = "{\"result\":"+result+"}";
			writer.print(result1);
			writer.close();
		}
		
		if(!isAjax) {
			resp.sendRedirect(url);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
