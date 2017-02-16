package party.infoo.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import party.infoo.model.User;
import party.infoo.service.UserService;

import java.util.List;

/**
 * @author infoo
 */
@Controller
public class UserAction extends ActionSupport implements ServletRequestAware {
    private User user;
    private User currentUser;
    private String error;
    private HttpServletRequest request;
    private HttpSession session;
    /**
     * 注入userService
     */
    @Resource
    private UserService userService;

    /**
     * 成员对象 request session
     *
     * @param request
     */
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        this.session = request.getSession();
    }

    /**
     * 成员对象user的get set方法
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * 用户登录
     *
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        currentUser = userService.login(user);//通过注入的userService对象进行登录
        if (currentUser != null) {
            //登录成功在session中添加currentUser
            session.setAttribute("currentUser", currentUser);
            request.setAttribute("a", (Object) "users");
            request.setAttribute("b", (Object) "info_user");
            return SUCCESS;
        } else {
            //登录失败返回错误信息
            error = "用户名或者密码错误！";
            return ERROR;
        }
    }

    public String saveUser() {
        userService.saveUser(user);
        request.setAttribute("resultUser", user);
        request.setAttribute("a", (Object) "users");
        request.setAttribute("b", (Object) "info_user");
        return SUCCESS;
    }

    /**
     * 用户退出
     *
     * @return
     */
    public String exit() {
        session.invalidate();
        return "error_noLogin";
    }

    /**
     * 修改用户
     *
     */
    public String updateUser() {
        userService.updateUser(user);
        request.setAttribute("a", (Object) "users");
        request.setAttribute("b", (Object) "info_mine");
        return SUCCESS;
    }

    /**
     * 删除用户
     *
     *
     * @return
     */
    public String deleteUser() {
        userService.deleteUserById(user,user.getUserId());
        request.setAttribute("a", (Object) "users");
        request.setAttribute("b", (Object) "info_mine");
        return SUCCESS;
    }

    /**
     * 根据用户ID查找用户
     * * @return
     */
    public String findUserById() {
        User resultUser = userService.findUserById(user.getUserId());
        if (resultUser != null) {
            request.setAttribute("resultUser", resultUser);
            request.setAttribute("a", (Object) "users");
            request.setAttribute("b", (Object) "info_user");
            return SUCCESS;
        } else {
            error = "查无此用户";
            return ERROR;
        }

    }

    /**
     * 查找所有用户
     *
     * @return
     */
    public String findAllUsers() {
        List<User> resultUsers = userService.findAllUsers();
        if (resultUsers != null) {
            request.setAttribute("resultUsers", resultUsers);
            request.setAttribute("a", (Object) "users");
            request.setAttribute("b", (Object) "info_users");
            return SUCCESS;
        } else {
            error = "查无结果";
            return ERROR;
        }
    }

    public String addUser_jsp() {
        request.setAttribute("a", (Object) "actions");
        request.setAttribute("b", (Object) "addUser");
        return SUCCESS;
    }

    public String searchUser_jsp() {
        request.setAttribute("a", (Object) "actions");
        request.setAttribute("b", (Object) "searchUser");
        return SUCCESS;
    }

    public String info_mine_jsp() {
        request.setAttribute("a", (Object) "users");
        request.setAttribute("b", (Object) "info_mine");
        return SUCCESS;
    }

    public String findAllBorrowInfos(){
        request.setAttribute("a",(Object)"users");
        request.setAttribute("b",(Object)"info_my_borrowInfo");
        return SUCCESS;
    }
    public String findAllBuyInfos(){
        request.setAttribute("a",(Object)"users");
        request.setAttribute("b",(Object)"info_user_buyInfo");
        return SUCCESS;
    }
    public String findAllSellBoooks(){
        request.setAttribute("a",(Object)"books");
        request.setAttribute("b",(Object)"info_books_sell");
        return SUCCESS;
    }
}
