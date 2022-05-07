package com.switter.web.servlet.post;

import com.switter.entity.*;
import com.switter.service.PostService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/post", name = "PostServlet")
public class PostServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPost = postService.getPostId();
        String text = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");
        logger.info("Add the post {} {} {}", idPost, text, user.getLogin());
        Post post = new Post(idPost, text, user, new ArrayList<Comment>(), new ArrayList<Like>());
        boolean isAdded = postService.addPost(post);

        if (isAdded) {
            logger.info("Added the post {} {} {}", idPost, text, user.getLogin());
            getServletContext().getRequestDispatcher("/myPostsPage.jsp").forward(req, resp);
        } else {
            logger.info("Error during adding with the post {} {} {}", idPost, text, user.getLogin());
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        List<Post> allPosts;
        if (user.getRole() == Role.ADMIN) {
            allPosts = postService.getAllPosts();
            logger.info("Get all posts as Admin, name - {}", user.getLogin());
        } else {
            logger.info("Get all posts as User, name - {}", user.getLogin());
            allPosts = postService.getAllPostsByLogin(user.getLogin());
        }

        if (allPosts.isEmpty()) {
            req.setAttribute("noPosts", true);

        } else {
            req.setAttribute("noPosts", false);
            req.setAttribute("allPosts", allPosts);
        }
        getServletContext().getRequestDispatcher("/myPostsPage.jsp").forward(req, resp);

    }

}
