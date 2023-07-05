package bitedu.bipa.member.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitedu.bipa.member.service.QuizService;
import bitedu.bipa.member.vo.BookCopy;

/**
 * Servlet implementation class BlmController
 */
@WebServlet("/BlmController")
public class BlmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private QuizService quizService;
    
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		quizService = new QuizService();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public BlmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		cmd = cmd == null?"list":cmd;
		String url = "./manager/book_list.jsp";
		boolean isRedirect = false;
		
		if(cmd.equals("list")) {
			ArrayList<BookCopy> list = quizService.searchBookAll();
			request.setAttribute("list", list);

		} else if(cmd.equals("regist")) {
			BookCopy copy = new BookCopy();
			copy.setAuthor(request.getParameter("author"));
			copy.setIsbn(request.getParameter("isbn"));
			copy.setPublishDate(Timestamp.valueOf(request.getParameter("publish_date")+" 00:00:00.0"));
			copy.setTitle(request.getParameter("book_title"));
			
			if(quizService.registBook(copy)) {
				System.out.println("등록 성공");
			}else {
				System.out.println("등록 실패");
			}
			url = "./BlmController?cmd=list";
		} else if(cmd.equals("remove")) {
			BookCopy book = new BookCopy();
			String seq = request.getParameter("Seq");
			boolean result = quizService.removeBook(seq);
			if(result) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			url = "./BlmController?cmd=list&flag="+result;
			isRedirect = true;
			
		} else if(cmd.equals("view_regist")) {
			url = "./manager/book_regist.jsp";
		} else if(cmd.equals("view_detail")) {
			BookCopy book = quizService.findBook(request.getParameter("Seq"));
			request.setAttribute("copy", book);
			url = "./manager/book_detail.jsp";
			
		} else if(cmd.equals("view_update")) {
			BookCopy book = quizService.findBook(request.getParameter("book_seq"));
			request.setAttribute("copy", book);
			url = "./manager/book_update.jsp";
		} else if(cmd.equals("update")) {
			BookCopy copy = new BookCopy();
			copy.setBookSeq(Integer.parseInt(request.getParameter("book_seq")));
			copy.setTitle(request.getParameter("book_title"));
			copy.setAuthor(request.getParameter("author"));
			copy.setPublishDate(Timestamp.valueOf(request.getParameter("publish_date")+ " 00:00:00.0"));
			
			if(quizService.modifyBook(copy)) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			url = "./BlmController?cmd=list";
		}
		
		if(!isRedirect) {
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} else {
			response.sendRedirect(url);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
