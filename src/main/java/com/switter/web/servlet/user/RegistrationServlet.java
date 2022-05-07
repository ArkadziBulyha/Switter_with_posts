package com.switter.web.servlet.user;

import com.switter.entity.Role;
import com.switter.entity.User;
import com.switter.service.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private static Logger logger = LogManager.getLogger();
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId = userService.getIdUser();
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("radioRole");

        logger.info("Start registration {}", login);
        User user = new User();
        user.setIdUser(userId);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);

        if (userId == 1) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }

        boolean isAdded = userService.addUser(user);
        req.setAttribute("isAdded", isAdded);
        if (isAdded) {
            logger.info("Success registration {}", login);
            resp.sendRedirect("/authorization.jsp");
        } else {
            logger.info("Error registration {}", login);
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
            resp.setStatus(400);
        }

    }
}
