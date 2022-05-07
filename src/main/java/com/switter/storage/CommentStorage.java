package com.switter.storage;

import com.switter.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentStorage {

    private static final List<Comment> commentList = new ArrayList<>();

    public boolean addComment(Comment comment) {
        commentList.add(comment);
        return true;
    }

    public int getCommentId() {
        return commentList.size() + 1;
    }

    public boolean deleteCommentById(int commentId, String userLogin){
        boolean isDeleted = false;
        for (Comment comment : commentList){
            if (comment.getComment_id() == commentId & comment.getUser().equals(userLogin)){
                commentList.remove(comment);
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    public Comment getCommentById(int commentId){

        Comment comment = new Comment();
        for (Comment comment2 : commentList){
            if (comment.getComment_id() == commentId){
                comment = comment2;
            }
        }
        return comment;
    }


    public String getLoginById(int commentId ){

        String userLogin = "";
        for (Comment comment : commentList){
            if (comment.getComment_id() == commentId){
                userLogin = comment.getUser();
            }
        }
        return userLogin;
    }

    public boolean editCommentById(int commentId, String userLogin, String text){

        boolean isEdited = false;
        for (Comment comment : commentList){
            if (comment.getComment_id() == commentId & comment.getUser().equals(userLogin)){
                comment.setText(text);
                isEdited = true;
            }
        }
        return isEdited;
    }

}
