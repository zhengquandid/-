package com.likzn.lisblog.config.interceptor;

import com.likzn.lisblog.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther: Li jx
 * @date: 2019/6/3 17:43
 * @description:
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    private String username = "123456";
    private String password = "123456";
        @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag;
        User user = (User) request.getSession().getAttribute("user");
        if (null == user) {
            // 如果用户为空则跳转到error页面
            // 2018年6月29日20:23:05：修改sendRedirect方法为getRequestDispatcher，
            // 目的是保证地址栏不改变（与前台错误页面响应一致），这样用户就不知道后台页面的地址
            request.getRequestDispatcher(request.getContextPath() + "/error.html").forward(request, response);
            flag = false;
        } else {
            // 对用户账号进行验证,是否正确
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
}
