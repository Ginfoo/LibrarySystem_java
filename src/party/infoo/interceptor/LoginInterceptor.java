package party.infoo.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by infoo on 2017/2/12.
 */
public class LoginInterceptor extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String result=null;
        Map<String,Object> session=actionInvocation.getInvocationContext().getSession();
        if(session.get("currentUser")!=null){
           result= actionInvocation.invoke();
        }else{
            result="error_noLogin";
        }
        return result;
    }
}
