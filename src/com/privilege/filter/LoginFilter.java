package com.privilege.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/jsp/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest re=(HttpServletRequest)req;
        HttpServletResponse rp=(HttpServletResponse)resp;
        if(re.getSession().getAttribute("username")==null) {
            re.setAttribute("msg", "你还未登录,请先登录");
            re.getRequestDispatcher("/login.jsp").forward(re, rp);;
        }else {
            chain.doFilter(re, rp);
        }
}

    public void init(FilterConfig config) throws ServletException {

    }

}
