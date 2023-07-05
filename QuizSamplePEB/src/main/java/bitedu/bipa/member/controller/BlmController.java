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
			
		} else if(cmd.equals("list")) {
			ArrayList<BookCopy> list = null;

			request.setAttribute("list", list);

		} else if(cmd.equals("regist")) {
			BookCopy copy = new BookCopy();
			
			copy.setIsbn(request.getParameter("isbn"));
			copy.setTitle(request.getParameter("book_title"));
			copy.setAuthor(request.getParameter("author"));
			copy.setPublishDate(Timestamp.valueOf((request.getParameter("publish_date")+" 00:00:00.0")));
			
			quizService.registBook(copy);
		} else if(cmd.equals("remove")) {
			BookCopy copy = new BookCopy();
			if(quizService.removeBook(Integer.toString(copy.getBookSeq()))) {
				isRedirect = true;
			}
			
		} else if(cmd.equals("view_regist")) {
			url = "./manager/book_regist.jsp";
		} else if(cmd.equals("view_detail")) {
			BookCopy copy = new BookCopy();
			quizService.findBook(Integer.toString(copy.getBookSeq()));
			
			request.setAttribute("copy", copy);
			
		} else if(cmd.equals("view_update")) {
			BookCopy copy = new BookCopy();
			copy.setTitle(request.getParameter("book_title"));
			copy.setAuthor(request.getParameter("author"));
			copy.setPublishDate(Timestamp.valueOf((request.getParameter("publish_date")+" 00:00:00.0")));
			
			quizService.modifyBook(copy);
			
		} else if(cmd.equals("update")) {
			
		}
		
		if(!isRedirect) {
			
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
