package bitedu.bipa.book.service;

import java.util.ArrayList;

import bitedu.bipa.book.dao.PagingDAO;
import bitedu.bipa.book.vo.BookCopy;

public class PagingService {
	private PagingDAO dao;
	public PagingService() {
		dao = new PagingDAO();
	}
	
	public ArrayList<BookCopy> searchBookAll(){
		ArrayList<BookCopy> list = null;
		list = dao.selectBookAll();
		System.out.println(list);
		return list;
	}
	
}