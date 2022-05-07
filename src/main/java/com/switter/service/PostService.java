package com.switter.service;

import com.switter.entity.Comment;
import com.switter.entity.Like;
import com.switter.entity.Post;
import com.switter.storage.PostStorage;

import java.util.ArrayList;
import java.util.List;

public class PostService {

    private final PostStorage postStorage = new PostStorage();

    public int getPostId() {
        return postStorage.getPostId();
    }

    public boolean addPost(Post post) {
        postStorage.savePost(post);
        return true;
    }

    public List<Post> getAllPostsByLogin(String userLogin) {

        List<Post> allPosts = new ArrayList<>();
        allPosts = postStorage.getAllPostsByLogin(userLogin);
        return allPosts;

    }

    public boolean deletePost(int idPost, String userLogin) {
        return postStorage.deletePostById(idPost, userLogin);
    }

    public boolean editPost(int idPost, String text, String login) {
        return postStorage.editPostById(idPost, text, login);
    }

    public List<Post> getAllPosts() {
        List<Post> allPosts = new ArrayList<>();
        allPosts = postStorage.getAllPosts();
        return allPosts;
    }


    public boolean addCommentToPost(int idPost, Comment comment) {
        return postStorage.addComment(idPost, comment);
    }

    public boolean addLike(int idPost, Like like) {
        return postStorage.addLikeToPost(idPost, like);
    }

    public boolean deleteLike(int idPost, String userLogin){
        return postStorage.deleteLike(idPost, userLogin);
    }

    public String getLoginByIdPost(int idPost){
        return postStorage.getLoginByIdPost(idPost);
    }

    public boolean deleteComment(int idPost, Comment comment, String userLogin){
        return postStorage.deleteComment(idPost, comment, userLogin);
    }

    public Post getPostByID(int idPost){
        return postStorage.getPostByID(idPost);
    }

}
