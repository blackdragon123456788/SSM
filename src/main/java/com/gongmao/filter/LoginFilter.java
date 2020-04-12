package com.gongmao.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//接口Filter要选择servlet的
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //过滤器出生
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    //servletRequest是接口，HttpServletRequest是实现，但是有些方法是HttpServletRequest独有的，你如说getSession
    //HttpServletRequest接口是继承自servletRequest接口，增加了和Http相关的方法

        //强转得到想要的request和response
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        //获取Session,indexOf()-->求字符串内路径出现对应字符串的下标
        HttpSession session=request.getSession();
        if(session.getAttribute("userInfo")==null&&request.getRequestURL().indexOf("/user/doLogin,do")==-1){
            //没有登录
            response.sendRedirect(request.getContextPath()+"/user/doLogin.do");
        }else {
            //已经登录，继续下一个请求(继续访问)
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
