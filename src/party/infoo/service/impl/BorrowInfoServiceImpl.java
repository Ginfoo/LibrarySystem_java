package party.infoo.service.impl;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import party.infoo.dao.BaseDao;
import party.infoo.model.Book;
import party.infoo.model.BorrowInfo;
import party.infoo.model.User;
import party.infoo.service.BorrowInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by infoo on 2017/2/12.
 */
@Service("borrowInfoService")
public class BorrowInfoServiceImpl implements BorrowInfoService {
    @Resource
    private BaseDao<BorrowInfo> baseDao;

    @Override
    public List<BorrowInfo> findInfoByBook(User user, Book book) {
       if(book==null&&user.getUserLevel()==0){
          return  baseDao.find("from BorrowInfo");
       }else {
           return baseDao.find("from BorrowInfo b where b.bookId=?",new Object[]{book.getBookId()});
       }
    }

    @Override
    public List<BorrowInfo> findInfoByUser(User user, User user2) {
        if(user.getUserId()==user2.getUserId()||user.getUserLevel()==0){
            return baseDao.find("from BorrowInfo b where b.userId=?", new Object[]{user2.getUserId()});
        }else{
            return null;
        }
    }

    @Override
    public void saveBorrowInfo(BorrowInfo borrowInfo) {
        baseDao.save(borrowInfo);
    }

    @Override
    public void deleteBorrowInfo(BorrowInfo borrowInfo) {
       baseDao.delete(borrowInfo);
    }
}
