package party.infoo.service;

import party.infoo.model.Book;

import java.util.List;

/**
 * Created by infoo on 2017/2/11.
 */
public interface BookService {
    public void saveBook(Book book);
    public void deleteBook(Book book);
    public void deleteBookById(Book book,int bookId);
    public void updateBook(Book book);
    public Book findBookById(int bookId);
    public List<Book> findAllBooks();
}
