package bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.service;


import bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.dao.LibraryDAO;
import bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.dto.BookDto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryBookService {
	
	private LibraryDAO dao;
	public LibraryBookService() throws IOException {
		dao = new LibraryDAO();
	}

	public void insertBookInfo(ArrayList<BookDto> books) throws IOException {
		dao.InsertBook(books);
	}

}
