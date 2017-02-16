package party.infoo.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;
import party.infoo.model.BookType;
import party.infoo.service.BookTypeService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by infoo on 2017/2/12.
 */
@Controller
public class BookTypeAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    private HttpSession session;
    private BookType bookType;
    private String error;
    @Resource
    private BookTypeService bookTypeService;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
        this.session = request.getSession();
    }

    /**
     * 成员对象bookType的get set方法
     *
     * @return
     */
    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
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
     * 添加图书类别
     *
     * @return
     */
    public String saveBookType() {
        if (bookType.getBookTypeName() != null) {
            bookTypeService.saveBookType(bookType);
            request.setAttribute("a",(Object)"bookTypes");
            request.setAttribute("b",(Object)"info_bookTypes");
            return SUCCESS;
        } else {
            error = "添加图书类别失败，请检查图书类别信息是否完整";
            return ERROR;
        }
    }

    /**
     * 删除图书类别
     *
     * @return
     */
    public String deleteBookType() {
        if (bookType != null) {
            bookTypeService.deleteBookType(bookType);
            request.setAttribute("a", (Object) "users");
            request.setAttribute("b", (Object) "info_mine");
            return SUCCESS;
        } else {
            error = "图书类别删除失败，或该图书类别不存在";
            return ERROR;
        }
    }

    /**
     * 更新图书类别
     *
     * @return
     */
    public String updateBookType() {
        if (bookType.getBookTypeName() != null) {
            bookTypeService.updateBookType(bookType);
            request.setAttribute("a", (Object) "users");
            request.setAttribute("b", (Object) "info_mine");
            return SUCCESS;
        } else {
            BookType resultBookType = bookType;
            request.setAttribute("resultBookType",resultBookType);
            request.setAttribute("a",(Object)"bookTypes");
            request.setAttribute("b",(Object)"info_bookType");
            error = "图书类别更细失败，请检查信息是否填写完整";
            return ERROR;
        }

    }

    /**
     * 查看所有图书类别
     *
     * @return
     */
    public String findAllBookTypes() {
        List<BookType> resultBookTypes = bookTypeService.findAllBookTypes();
        if (resultBookTypes != null) {
            request.setAttribute("resultBookTypes", resultBookTypes);
            request.setAttribute("a",(Object)"bookTypes");
            request.setAttribute("b",(Object)"info_bookTypes");
            return SUCCESS;
        } else {
            error = "查无结果";
            return ERROR;
        }

    }

    /**
     * 查找特定图书类别
     * @return
     */
    public String findBookTypeById() {
        BookType resultBookType = bookTypeService.findBookTypeById(bookType.getBookTypeId());
        if(resultBookType!=null){
            request.setAttribute("resultBookType",resultBookType);
            request.setAttribute("a",(Object)"bookTypes");
            request.setAttribute("b",(Object)"info_bookType");
            return SUCCESS;
        }else{
            error="查无结果";
            return ERROR;
        }
    }

}
