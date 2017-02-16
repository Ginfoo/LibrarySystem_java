package party.infoo.model;


/**
 *
 * @author infoo
 *
 */
public class Book {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private float bookPrice;
	private BookType bookType;

    public Book() {
        super();
    }

    public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
    
	

	public String getBookName() {
		return bookName;
	}
    
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
    

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
    
}
