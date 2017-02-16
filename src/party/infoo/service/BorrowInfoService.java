package party.infoo.service;

import party.infoo.model.Book;
import party.infoo.model.BorrowInfo;
import party.infoo.model.User;

import java.util.List;

/**
 * Created by infoo on 2017/2/12.
 */
public interface BorrowInfoService {
    public List<BorrowInfo> findInfoByBook(User user, Book book);
    public List<BorrowInfo> findInfoByUser(User user, User user2);
    public void saveBorrowInfo(BorrowInfo borrowInfo);
    public void deleteBorrowInfo(BorrowInfo borrowInfo);
}
