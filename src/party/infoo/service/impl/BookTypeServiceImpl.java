package party.infoo.service.impl;

import org.springframework.stereotype.Service;
import party.infoo.dao.BaseDao;
import party.infoo.model.Book;
import party.infoo.model.BookType;
import party.infoo.service.BookService;
import party.infoo.service.BookTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by infoo on 2017/2/12.
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {
    @Resource
    private BaseDao<BookType> baseDao;

    @Override
    public void saveBookType(BookType bookType) {
        baseDao.save(bookType);
    }

    @Override
    public void deleteBookType(BookType bookType) {
        baseDao.delete(bookType);
    }

    @Override
    public void updateBookType(BookType bookType) {
        baseDao.update(bookType);
    }


    @Override
    public List<BookType> findAllBookTypes() {
        return baseDao.find("from BookType");
    }

    @Override
    public BookType findBookTypeById(int id) {
        return baseDao.get(BookType.class, id);
    }
}
