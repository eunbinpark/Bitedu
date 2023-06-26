package bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz;

import bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.dto.BookDto;
import bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.service.LibraryBookService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		solution.getUserInfo("user1");
		solution.makeData();
	}
	
	public void getUserInfo(String userId) {
		// 도서이용현황에 대한 정보를 가져와서 
		
	}

	public void makeData(){

		ArrayList<BookDto> books = new ArrayList<>();

		File file = new File("Sample/SimpleLibrarySample/data/book_info.csv");
		BufferedReader reader;
		String line ;
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				BookDto dto;
				String[] lineArr = line.split(",");
				List<String> aLine = Arrays.asList(lineArr);
				dto = new BookDto(aLine.get(0), aLine.get(1), aLine.get(2), aLine.get(3));

				books.add(dto);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(books);
		LibraryBookService service = null;
		try {
			service = new LibraryBookService();
			service.insertBookInfo(books);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void saveUserInfo(String userId, String userInfo) throws IOException {
		// user1.json파일명으로 저장
	}

}
