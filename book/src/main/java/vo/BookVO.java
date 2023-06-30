package vo;

import java.sql.Date;

public class BookVO {
	private String book_seq;
	private String book_isbn;
	private String book_title;
	private String book_author;
	private String publisher;
	private String book_published_date;
	private String book_position;
	private String book_status;
	
	
	public String getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(String book_seq) {
		this.book_seq = book_seq;
	}
	public String getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBook_published_date() {
		return book_published_date;
	}
	public void setBook_published_date(String book_published_date) {
		this.book_published_date = book_published_date;
	}
	public String getBook_position() {
		return book_position;
	}
	public void setBook_position(String book_position) {
		this.book_position = book_position;
	}
	public String getBook_status() {
		return book_status;
	}
	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
}
