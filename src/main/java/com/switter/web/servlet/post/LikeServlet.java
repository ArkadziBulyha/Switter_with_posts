package com.switter.web.servlet.post;

import com.switter.entity.Like;
import com.switter.service.PostService;
import com.switter.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/likeServlet", name = "LikeServlet")
public class LikeServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPost = Integer.parseInt(req.getParameter("idPost"));
        User user = (User) req.getSession().getAttribute("user");
        String userLogin = user.getLogin();

        Like like = new Like(1, userLogin);
        boolean isAddedLike = postService.addLike(idPost, like);

        if (isAddedLike) {
            resp.getWriter().println("like!");
        } else {
            resp.getWriter().println("error");
        }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPost = Integer.parseInt(req.getParameter("idPost"));
        User user = (User) req.getSession().getAttribute("user");
        String userLogin = user.getLogin();

        boolean isDeletedLike = postService.deleteLike(idPost, userLogin);

        if (isDeletedLike) {
            resp.getWriter().println("like was deleted");
        } else {
            resp.getWriter().println("error");
        }

    }
}
