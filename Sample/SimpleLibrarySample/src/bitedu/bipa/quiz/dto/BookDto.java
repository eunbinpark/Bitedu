package bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.dto;

public class BookDto {
    private String bookIsbn;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublishedDate;

    public BookDto(String bookIsbn, String bookTitle, String bookAuthor, String bookPublishedDate) {
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishedDate = bookPublishedDate;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublishedDate() {
        return bookPublishedDate;
    }

    public void setBookPublishedDate(String bookPublishedDate) {
        this.bookPublishedDate = bookPublishedDate;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookIsbn='" + bookIsbn + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublishedDate='" + bookPublishedDate + '\'' +
                '}';
    }
}
