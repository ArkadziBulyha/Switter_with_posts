package com.switter.web.servlet.post;

import com.switter.entity.Post;
import com.switter.entity.Role;
import com.switter.entity.User;
import com.switter.service.PostService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditPost", urlPatterns = "/post/editPost")
public class PostEditServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPost = Integer.parseInt(req.getParameter("idPost"));
        String text = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");
        boolean isEdit = false;

        if (user.getRole().equals(Role.ADMIN)) {
            logger.info("Edit  post as Admin, name - {}, idPost {}", user.getLogin(), idPost);
            String loginUser = postService.getLoginByIdPost(idPost);
            isEdit = postService.editPost(idPost, text, loginUser);
        } else {
            logger.info("Edit  post as User, name - {}, idPost {}", user.getLogin(), idPost);
            isEdit = postService.editPost(idPost, text, user.getLogin());
        }

        if (isEdit) {
            getServletContext().getRequestDispatcher("/myPostsPage.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(req, resp);
            resp.setStatus(400);
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPost = Integer.parseInt(req.getParameter("idPost"));
        Post post = postService.getPostByID(idPost);
        req.setAttribute("idPost", idPost);
        req.setAttribute("loginUser", post.getUser().getLogin());
        req.setAttribute("text", post.getText());

        getServletContext().getRequestDispatcher("/editPostView.jsp").forward(req, resp);
    }
}
