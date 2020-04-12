package com.gongmao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//点击被实现的接口HandlerInterceptor，右键点击Generate...，选择Override Methods...,选择以下的三个方法
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //   在拦截点执行拦截，如果返回的true则不执行拦截点后的操作(拦截成功)

    //1、获取当前的登录方法，判断当前的User用户不为空;
        HttpSession session=request.getSession();
//        String url=request.getRequestURI();
//        System.out.println("接收到的action为："+url);

        //在spring-mvc.xml配置拦截器后，全部拦截并且指定路径放行，url.indexOf("user/doLogin.do")!=-1判断就可以不用了
//        if (session.getAttribute("userInfo")!=null||url.indexOf("user/doLogin.do")!=-1){
        if (session.getAttribute("userInfo")!=null){
            return true;
        }else {
            //进行拦截，返回登录页面
            response.sendRedirect(request.getContextPath() + "/user/doLogin.do");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    //在处理中，进行拦截
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    //执行完毕，返回前拦截
    }
}
