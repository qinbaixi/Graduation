package cn.qut.graduation.interceptor;


import cn.qut.graduation.annotation.LoginRequired;
import cn.qut.graduation.pojo.SuVo;
import cn.qut.graduation.pojo.TeVo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 */
public class LoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //不映射到方法直接过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //方法级拦截器开始
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //判断接口是否需要登录
        LoginRequired annotation = method.getAnnotation(LoginRequired.class);
        //有认证
        if (annotation != null) {
            System.out.println("前置拦截器开始---");
            //拦截逻辑
            SuVo suLogin = (SuVo) request.getSession().getAttribute("suLogin");
            TeVo teLogin = (TeVo) request.getSession().getAttribute("teLogin");
            if (suLogin == null && teLogin == null) {
                System.out.println("前置拦截不放行--");
                System.out.println("跳转登录页面----");
                //在这里跳转到登录页面
                response.sendRedirect("login");
                return false;
            }else {
                return true;
            }

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post拦截器执行--");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
