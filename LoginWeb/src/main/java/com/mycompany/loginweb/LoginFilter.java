package com.mycompany.loginweb;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author willian
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public LoginFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        Cookie[] cookies = httpRequest.getCookies();
        String userId = getCookieValue(cookies, "userId");
        String action = request.getParameter("action");

        if (userId != null) {
            if (action != null && action.equals("logout")) {
                if (session != null) {
                    session.invalidate();
                }

                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("userId".equals(cookie.getName())) {
                            cookie.setMaxAge(0);
                            httpResponse.addCookie(cookie);
                            break;
                        }
                    }
                }

                httpResponse.sendRedirect("index.jsp");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    private String getCookieValue(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
