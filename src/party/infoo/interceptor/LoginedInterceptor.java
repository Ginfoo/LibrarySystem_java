package party.infoo.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/**
 * Created by infoo on 2017/2/12.
 */
public class LoginedInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String result=null;
        Map<String,Object> session=actionInvocation.getInvocationContext().getSession();
        /**
         * 已登录直接进入main.jsp
         */
        if(session.get("currentUser")==null){
            result= actionInvocation.invoke();
        }else{
            result="success";
        }
        return result;
    }
}
