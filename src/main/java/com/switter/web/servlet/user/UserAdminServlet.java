package com.switter.web.servlet.user;

import com.switter.entity.Role;
import com.switter.entity.User;
import com.switter.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/userHistory", name = "UserAdminServlet")
public class UserAdminServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userID = Integer.parseInt(req.getParameter("userId"));
        User user = (User) req.getSession().getAttribute("user");

        if (user.getRole() == Role.ADMIN) {
            boolean isEdited = userService.editRole(userID);
            if (isEdited) {
                resp.getWriter().println("Added admin rights");
            }

        } else {
            resp.getWriter().println("No access");
            resp.setStatus(403);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userID = Integer.parseInt(req.getParameter("userId"));
        User user = (User) req.getSession().getAttribute("user");

        if (user.getRole() == Role.ADMIN) {
            boolean isEdited = userService.deleteUser(userID);
            if (isEdited) {
                resp.getWriter().println("User was deleted");
            }

        } else {
            resp.getWriter().println("No access");
            resp.setStatus(403);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idUser = req.getParameter("idUser");
        User user = (User) req.getSession().getAttribute("user");

        if (user.getRole() != Role.ADMIN) {
            resp.getWriter().println("No access");
            resp.setStatus(403);
        } else {

            if (idUser != null & idUser.matches("\\d+")) {
                int idUserInt = Integer.parseInt(idUser);
                User userInfo = new User();
                userInfo = userService.getUserByID(idUserInt);
                resp.getWriter().println(userInfo.toString());
            } else {
                List<User> userList = new ArrayList<User>();
                userList = userService.getAllUsers();

                if (!userList.isEmpty()) {
                    for (User user1 : userList) {
                        resp.getWriter().println(user1.toString());
                    }
                } else {
                    resp.getWriter().println("No history yet =(");
                }
            }
        }
    }
}
