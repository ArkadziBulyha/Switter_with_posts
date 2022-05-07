package com.switter.entity;

public class Comment {

    private int comment_id;
    private String text;
    private String userLogin;

    public Comment(int comment_id, String text, String userLogin) {
        this.comment_id = comment_id;
        this.text = text;
        this.userLogin = userLogin;
    }

    public Comment() {
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return userLogin;
    }

    public void setUser(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "Comment: " + '\n' +
                "comment_id=" + comment_id + '\n' +
                "text='" + text + '\n' +
                "userLogin=" + userLogin + '\n';
    }
}
