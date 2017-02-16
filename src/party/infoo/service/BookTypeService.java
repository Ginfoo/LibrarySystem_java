package party.infoo.service;

import party.infoo.model.BookType;

import java.util.List;

/**
 * Created by infoo on 2017/2/11.
 */
public interface BookTypeService {
    public void saveBookType(BookType bookType);
    public void deleteBookType(BookType bookType);
    public void updateBookType(BookType bookType);
    public BookType findBookTypeById(int id);
    public List<BookType> findAllBookTypes();
}
