package party.infoo.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;
import party.infoo.model.Book;
import party.infoo.model.BorrowInfo;
import party.infoo.model.User;
import party.infoo.service.BorrowInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by infoo on 2017/2/12.
 */
@Controller
public class BorrowInfoAction extends ActionSupport implements ServletRequestAware {
    @Resource
    private BorrowInfoService borrowInfoService;
    private HttpServletRequest request;
    private HttpSession session;
    private User currentUser;
    private User user;
    private Book book;
    private BorrowInfo borrowInfo;
    private String error;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public BorrowInfo getBorrowInfo() {
        return borrowInfo;
    }

    public void setBorrowInfo(BorrowInfo borrowInfo) {
        this.borrowInfo = borrowInfo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }



    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
        this.session = request.getSession();
    }

    /**
     * 借阅图书
     *
     * @return
     */
    public String saveBorrowInfo() {
        borrowInfoService.saveBorrowInfo(borrowInfo);
        return SUCCESS;
    }

    /**
     * 归还图书
     *
     * @return
     */
    public String deleteBorrowInfo() {
        borrowInfoService.deleteBorrowInfo(borrowInfo);
        return SUCCESS;
    }

    /**
     * 查看图书借阅信息
     *
     * @return
     */
    public String findInfoByBook() {
        List<BorrowInfo> resultBorrowInfos =borrowInfoService.findInfoByBook(currentUser, book);
        if(resultBorrowInfos!=null){
            request.setAttribute("resultBorrowInfos",resultBorrowInfos);
            String Flag_findInfoByBook="findInfoByBook";
            session.setAttribute("Flag",Flag_findInfoByBook);
            return SUCCESS;
        }else{
            error="该图书无借阅信息";
            return ERROR;
        }
    }

    /**
     * 查看用户借阅信息
     *
     * @return
     */
    public String findInfoByUser() {
        List<BorrowInfo> resultBorrowInfos = borrowInfoService.findInfoByUser(currentUser, user);
        if(resultBorrowInfos!=null){
            request.setAttribute("resultBorrowInfos",resultBorrowInfos);
            String Flag_findInfoByUser="findInfoByUser";
            session.setAttribute("Flag",Flag_findInfoByUser);
            return SUCCESS;
        }else{
            error="该用户无借阅信息";
            return ERROR;
        }
    }

}
