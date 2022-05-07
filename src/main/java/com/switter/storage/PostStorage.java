package com.switter.storage;

import com.switter.entity.Comment;
import com.switter.entity.Like;
import com.switter.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class PostStorage {

    private static final List<Post> postList = new ArrayList<>();

    public int getPostId() {
        return postList.size() + 1;
    }

    public void savePost(Post post) {
        postList.add(post);
    }

    public List<Post> getAllPostsByLogin(String login) {

        List<Post> allPosts = new ArrayList<>();
        for (Post post : postList) {
            if (post.getUser().getLogin().equals(login)) {
                allPosts.add(post);
            }
        }
        return allPosts;
    }


    public boolean deletePostById(int idPost, String login) {

        boolean isDeleted = false;

        for (Post post : postList) {
//            if (post.getIdPost() == idPost & post.getUser().getLogin().equals(login)) {
            if (post.getIdPost() == idPost) {
                int arrayIndex = postList.indexOf(post);
                postList.remove(arrayIndex);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    public boolean editPostById(int idPost, String text, String login) {
        boolean isEdited = false;

        for (Post post : postList) {
            if (post.getIdPost() == idPost & post.getUser().getLogin().equals(login)) {
                post.setText(text);
                isEdited = true;
            }
        }
        return isEdited;
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(postList);
    }


    public boolean addComment(int idPost, Comment comment) {
        boolean isAdded = false;
        for (Post post : postList) {
            if (post.getIdPost() == idPost) {
                post.getCommentList().add(comment);
                isAdded = true;
            }
        }
        return isAdded;
    }

    public boolean addLikeToPost(int idPost, Like like) {

        boolean isAdded = false;
        for (Post post : postList) {
            if (post.getIdPost() == idPost) {
                post.getLikeList().add(like);
                isAdded = true;
            }
        }
        return isAdded;
    }

    public boolean deleteLike(int idPost, String userLogin) {
        boolean isDeleted = false;

        for (Post post : postList) {
            if (post.getIdPost() == idPost) {
                List<Like> newLikeList = post.getLikeList();

                for (Like like : newLikeList) {
                    if (like.getUserLogin().equals(userLogin)) {
                        post.getLikeList().remove(like);
                        isDeleted = true;
                    }
                }
            }
        }

        return isDeleted;
    }

    public String getLoginByIdPost(int idPost) {

        String userLogin = "";
        for (Post post : postList) {
            if (post.getIdPost() == idPost) {
                userLogin = post.getUser().getLogin();
            }
        }
        return userLogin;
    }


    public boolean deleteComment(int idPost, Comment comment, String userLogin) {
        boolean isDeleted = false;
        for (Post post : postList) {
            if (post.getIdPost() == idPost & post.getUser().getLogin().equals(userLogin)) {
                post.getCommentList().remove(comment);
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    public Post getPostByID(int idPost){
        Post lookingPost = new Post();
        for (Post post : postList){
            if (post.getIdPost() == idPost){
                lookingPost = post;
            }
        }
        return lookingPost;
    }


}
