package party.infoo.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;
import party.infoo.model.Book;
import party.infoo.service.BookService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by infoo on 2017/2/12.
 */
@Controller
public class BookAction extends ActionSupport implements ServletRequestAware {
    private Book book;
    private String error;
    private HttpServletRequest request;
    private HttpSession session;
    @Resource
    private BookService bookService;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
        this.session = request.getSession();
    }

    /**
     * 成员对象book的get set方法
     *
     * @return
     */
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 成员变量error的get set方法
     *
     * @return
     */
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     * 查看所有图书
     *
     * @return
     */
    public String findAllBooks() {
        List<Book> resultBooks = bookService.findAllBooks();
        if (resultBooks != null) {
            request.setAttribute("resultBooks", resultBooks);
            request.setAttribute("a",(Object)"books");
            request.setAttribute("b",(Object)"info_books");
            return SUCCESS;
        } else {
            error = "查无结果";
            return ERROR;
        }
    }

    /**
     * 根据图书Id查找图书
     *
     * @return
     */
    public String findBookById() {
        Book resultBook = bookService.findBookById(book.getBookId());
        if (resultBook != null) {
            request.setAttribute("resultBook", resultBook);
            request.setAttribute("a",(Object)"books");
            request.setAttribute("b",(Object)"info_book");
            return SUCCESS;
        } else {
            String Flag_findBookById="findBookById";
            session.setAttribute("Flag",Flag_findBookById);
            error = "查无结果";
            return ERROR;
        }
    }

    /**
     * 删除图书
     * @return
     */
    public String deleteBook() {
        if (this.book != null) {
            bookService.deleteBookById(book,book.getBookId());
            request.setAttribute("a", (Object) "users");
            request.setAttribute("b", (Object) "info_mine");
            return SUCCESS;
        }else{
            request.setAttribute("a",(Object)"books");
            request.setAttribute("b",(Object)"info_book");
            error="该图书不存在，或者已被删除";
            return ERROR;
        }
    }

    /**
     * 添加图书
     * @return
     */
    public String saveBook(){
        if(this.book.getBookName()!=null){
            bookService.saveBook(book);
            request.setAttribute("a", (Object) "users");
            request.setAttribute("b", (Object) "info_mine");
            return SUCCESS;
        }else{
            request.setAttribute("a",(Object)"books");
            request.setAttribute("b",(Object)"info_book");
            error="保存失败，请填完整图书信息";
            return ERROR;
        }
    }

    /**
     * 更新图书信息
     * @return
     */
    public String updateBook(){
        if(this.book.getBookName()!=null){
            bookService.updateBook(book);
            request.setAttribute("a", (Object) "users");
            request.setAttribute("b", (Object) "info_mine");
            return SUCCESS;
        }else{
            request.setAttribute("a",(Object)"books");
            request.setAttribute("b",(Object)"info_book");
            error="更新失败，请检查图书信息是否完整";
            return ERROR;
        }

    }
    public String searchBook_jsp(){
        request.setAttribute("a",(Object)"actions");
        request.setAttribute("b",(Object)"searchBook");
        return SUCCESS;
    }
    public String addBook_jsp(){
        request.setAttribute("a",(Object)"actions");
        request.setAttribute("b",(Object)"addBook");
        return SUCCESS;
    }


}
