package com.switter.web.servlet.post;

import com.switter.entity.Role;
import com.switter.service.PostService;
import com.switter.entity.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deletePost", urlPatterns = "/post/deletePost")
public class PostDeleteServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        User user = (User) req.getSession().getAttribute("user");
        boolean isDeleted = false;

        if (user.getRole().equals(Role.ADMIN)) {
            String loginUser = postService.getLoginByIdPost(idPost);
            logger.info("Delete  post as Admin, name - {}, idPost {}", user.getLogin(), idPost);
            isDeleted = postService.deletePost(idPost, loginUser);
        } else {
            logger.info("Delete  post as User, name - {}, idPost {}", user.getLogin(), idPost);
            isDeleted = postService.deletePost(idPost, user.getLogin());
        }

        if (isDeleted) {
            getServletContext().getRequestDispatcher("/myPostsPage.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(req, resp);
            resp.setStatus(400);
        }
    }
}
