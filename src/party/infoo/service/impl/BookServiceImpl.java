package party.infoo.service.impl;

import org.springframework.stereotype.Service;
import party.infoo.dao.BaseDao;
import party.infoo.model.Book;
import party.infoo.service.BookService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by infoo on 2017/2/12.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BaseDao<Book> baseDao;
    @Override
    public void saveBook(Book book) {
      baseDao.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        baseDao.delete(book);
    }

    @Override
    public void deleteBookById(Book book,int bookId) {
        baseDao.delete(book,bookId);

    }

    @Override
    public void updateBook(Book book) {
        baseDao.update(book);
    }

    @Override
    public Book findBookById(int bookId) {
        return baseDao.get(Book.class,bookId);
    }

    @Override
    public List<Book> findAllBooks() {
        return baseDao.find("from Book");
    }
}
