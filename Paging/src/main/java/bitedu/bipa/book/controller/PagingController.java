package bitedu.bipa.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitedu.bipa.book.service.PagingService;
import bitedu.bipa.book.vo.BookCopy;

public class PagingController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("UTF-8");
	String cmd = req.getParameter("cmd");
	cmd = cmd == null ? "list" : cmd;
	String url = "./manager/paging_list.jsp";
	PagingService ps = new PagingService();
	boolean isRedirect = false;
	if (cmd.equals("list")) {
		List<BookCopy> list = ps.searchBookAll();

		  int itemsPerPage = 5; // 한 페이지에 표시할 항목 수
		  int currentPage = 1; // 현재 페이지 번호
		  
		  // 전체 항목 수
		  int totalItems = list.size();

		  // 전체 페이지 수
		  int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

		  // 현재 페이지에 해당하는 항목의 시작 인덱스와 끝 인덱스 계산
		  int startIndex = (currentPage - 1) * itemsPerPage;
		  int endIndex = Math.min(startIndex + itemsPerPage, totalItems);

		  // 현재 페이지에 해당하는 항목 리스트
		  List<BookCopy> currentPageItems = list.subList(startIndex, endIndex);
		
		
		/*
		 * 현재 페이지에서 몇건이 보일건지(사이즈)
		 * 총 페이지 갯수가 몇개인지(화면에 페이지 갯수 보여줘야함) 1페이지 2페이지 3페이지 ... 
		 * 페이지 버튼을 클릭했을 때 1~10 11~20건 이렇게 보여줘야 할건데 알고 있는 데이터는 현재 페이지와 보여줄 데이터 건수, 총 목록의 건수인데 이 세개의 데이터로 어떻게 계산해야 할지
		 * 만약 총 데이터 수가 22개일 때 사이즈가 10이라면 1페이지-1~10까지 2페이지-11~20까지 보여주는데 남은 2개는 어떻게 처리할건지
		 * 
		 * */
		
		req.setAttribute("list", list);
		req.setAttribute("pageItem", currentPageItems);
		//이렇게 설정된 속성은 다른 서블릿이나 JSP 파일에서 해당 요청에 접근할 때 사용할 수 있습니다

	}
	if (!isRedirect) {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	} else {
		resp.sendRedirect(url);
	}
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
