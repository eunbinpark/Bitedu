package bitedu.bipa.member.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitedu.bipa.member.service.BlmService;
import bitedu.bipa.member.vo.BookCopy;

/**
 * Servlet implementation class BlmController
 */
@WebServlet("/BlmController")
public class BlmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		BlmService blm = new BlmService();
		boolean isRedirect = false;
		System.out.println(cmd);
		if(cmd.equals("list")) {
			ArrayList<BookCopy> list = blm.searchBookAll();
			
			request.setAttribute("list", list);
			
		} else if(cmd.equals("regist")) {	//등록
			
			BookCopy book = new BookCopy();
			/* book.setBookSeq(Integer.parseInt(request.getParameter("book_seq"))); */
			book.setIsbn(request.getParameter("isbn"));
			book.setTitle(request.getParameter("book_title"));
			book.setAuthor(request.getParameter("author"));
			book.setPublisher(request.getParameter("publisher"));
			book.setPublishDate(Timestamp.valueOf((request.getParameter("publish_date")+" 00:00:00.0")));
			
			blm.registBook(book);
			
		
		
			System.out.println("hi");
			//request.setAttribute("list", book);
			//url = "./manager/book_list.jsp";
			url="./BlmController";
			isRedirect=true;
			
		} else if(cmd.equals("remove")) {
			String bookSeq = request.getParameter("bookSeq");
			boolean flag = blm.removeBook(bookSeq);
			System.out.println(flag);
			System.out.println(bookSeq);

			url="./BlmController?cmd=list&flag=" + flag;
			isRedirect=true;
			
		} else if(cmd.equals("view_regist")) {
			url = "./manager/book_regist.jsp";
		} else if(cmd.equals("bookdetail")) {
			ArrayList<BookCopy> allBook = blm.searchBookAll();
			BookCopy book = new BookCopy();
			for(BookCopy temp : allBook) {
				if(temp.getBookSeq() == Integer.parseInt(request.getParameter("bookSeq"))) {
					book.setIsbn(temp.getIsbn());
					book.setBookSeq(temp.getBookSeq());
					book.setTitle(temp.getTitle());
					book.setAuthor(temp.getAuthor());
					book.setPublisher(temp.getPublisher());
					book.setPublishDate(temp.getPublishDate());
				}
			}
		
			
			request.setAttribute("book", book);
			url = "./manager/book_detail.jsp";
		
		} else if (cmd.equals("update")) {
			System.out.println("hey");
			BookCopy book = new BookCopy();
			book.setBookSeq(Integer.parseInt(request.getParameter("book_seq")));
			book.setIsbn(request.getParameter("isbn"));
			book.setTitle(request.getParameter("book_title"));
			book.setAuthor(request.getParameter("author"));
			book.setPublisher(request.getParameter("publisher"));
			book.setPublishDate(Timestamp.valueOf((request.getParameter("publish_date")+" 00:00:00.0")));
			System.out.println(book);
			if(blm.modifyBook(book)) {
				System.out.println("수정");
			}
			
			url="./BlmController";
			isRedirect=true;
		}
		
		if(!isRedirect) {
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}else {
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
