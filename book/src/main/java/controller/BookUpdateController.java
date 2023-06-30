package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.BookRepository;
import vo.BookVO;

public class BookUpdateController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BookVO bookvo = new BookVO(); 
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		bookvo.setBook_seq(req.getParameter("book_seq"));
		bookvo.setBook_isbn(req.getParameter("isbn"));
		bookvo.setBook_author(req.getParameter("author"));
		bookvo.setBook_position(req.getParameter("book_position"));
		bookvo.setBook_published_date(req.getParameter("publish_date"));
		bookvo.setBook_status(req.getParameter("book_status"));
		bookvo.setBook_title(req.getParameter("book_title"));
		bookvo.setPublisher(req.getParameter("publisher"));
		System.out.println(bookvo.getPublisher());
		

		BookRepository bookDAO = new BookRepository();
		if(bookDAO.regist_book_info(bookvo) && bookDAO.regist_book_copy(bookvo)) {
			ArrayList<BookVO> list = bookDAO.getBookList();
			req.setAttribute("bookList", list);
			RequestDispatcher rd = req.getRequestDispatcher("./front/book_list.jsp");
			rd.forward(req, resp);
			for(BookVO vo: list) {
				System.out.println(vo.getBook_author());
			}
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
}
