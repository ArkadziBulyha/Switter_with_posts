package com.switter.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"PostServlet", "PostHistoryServlet", "UserAdminServlet"})
public class UserFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") == null) {
            //res.sendError(403);
            res.setStatus(401);
            res.getWriter().println("You need to register");
        } else {
            chain.doFilter(req, res);
        }
    }
}
